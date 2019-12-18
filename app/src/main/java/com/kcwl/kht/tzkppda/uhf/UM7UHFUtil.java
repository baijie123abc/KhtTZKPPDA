/**
 * FileName: UM7UHFUtil
 * Author:baijie
 * Date: 2019/8/8 10:51
 * Description: 新版本扫码枪的工具类
 */
package com.kcwl.kht.tzkppda.uhf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.kcwl.kht.tzkppda.utils.SoundUtil;
import com.kcwl.kht.tzkppda.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import realid.rfidlib.EmshConstant;
import realid.rfidlib.MyLib;

/**
 * @ClassName: UM7UHFUtil
 * @Description: 新版本扫码枪的工具类
 * @Author: baijie
 * @Date: 2019/8/8 10:51
 */
public class UM7UHFUtil
{
    private String TAG = UM7UHFUtil.class.getSimpleName();
    private static final String UHFConnect_Success = "扫描枪连接成功！";
    private static final String UHFConnect_Charging = "扫描枪正在充电！";
    private static final String UHFConnect_ChargingFinish = "扫描枪电池已充满！";

    private MyLib uhfMyLib;
    private EmshStatusBroadcastReceiver mEmshStatusReceiver;
    private static Context mContext;
    private Timer mTimer = null;
    private TimerTask mTimerTask = null;
    //电池状态
    private int oldStatue = -1;
    private SoundUtil soundUtil;
    private UM7UHFResult um7UHFResult;
    private List<String> scanDataList = new ArrayList<>();
    //读取到的电子车牌前面加这个，历史遗留问题为了兼容硬件的旧程序
    private String params = "0C";
    //标签默认密码
    private static final String tagPwd = "00000000";
    //标签读取的开始位置
    private static final int tagStartPosition = 0;
    //标签读取的长度
    private static final int tagReadLen = 6;
    //读取标签的时间
    private long readTime = 0L;
    //扫码枪读取标签的总时长，暨每次扫描多长时间，默认是1秒，可以通过设置页面动态设置
    private long scanTagTime = 1000L;


    public UM7UHFUtil(Context context)
    {
        mContext = context;
        initUHF();
        soundUtil = new SoundUtil(mContext);
        monitorEmsh();
    }

    private void initUHF()
    {
        uhfMyLib = new MyLib(mContext);
        //读取本地存储的扫描总时长如有则设置，没有默认为1秒
        scanTagTime = SPUtils.getInstance().getLong(Constant.KEY_SCANTIME, 1) * 1000;
        LogUtils.dTag(TAG, "PowerOn:" + uhfMyLib.powerOn() + ",PowerValue:" + uhfMyLib.powerGet() + ",scanTagTime:" + scanTagTime);
    }


    public MyLib getUhfMyLib()
    {
        return uhfMyLib;
    }

    //定时监听把枪状态
    private void monitorEmsh()
    {
        mEmshStatusReceiver = new EmshStatusBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(EmshConstant.Action.INTENT_EMSH_BROADCAST);
        mContext.registerReceiver(mEmshStatusReceiver, intentFilter);

        mTimer = new Timer();
        mTimerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(EmshConstant.Action.INTENT_EMSH_REQUEST);
                intent.putExtra(EmshConstant.IntentExtra.EXTRA_COMMAND, EmshConstant.Command.CMD_REFRESH_EMSH_STATUS);
                mContext.sendBroadcast(intent);
            }
        };
        mTimer.schedule(mTimerTask, 0, 1000);
    }

    /**
     * 下电，回收停止线程，退出应用
     */
    public void recyleResoure()
    {
        soundUtil.stopSound();
        if (mEmshStatusReceiver != null)
        {
            mContext.unregisterReceiver(mEmshStatusReceiver);
            mEmshStatusReceiver = null;
        }
        if (mTimer != null || mTimerTask != null)
        {
            mTimerTask.cancel();
            mTimer.cancel();
            mTimerTask = null;
            mTimer = null;
        }
        LogUtils.dTag(TAG, "PowerOff:" + uhfMyLib.powerOff());
    }


    public void startOrStoptScan()
    {
        soundUtil.playSound();
        handler.postDelayed(runnable, 100);
    }

    private void readTag()
    {
        String tid = "";

        tid = uhfMyLib.readTag(tagPwd, 0, 0, 0, "0", uhfMyLib.TID, tagStartPosition, tagReadLen);
        LogUtils.dTag(TAG, tid);

        if (!TextUtils.isEmpty(tid))
        {
            scanDataList.add(tid);
        }
    }

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable()
    {
        @Override
        public void run()
        {
            readTime += 100;
            if (readTime <= scanTagTime)
            {
                handler.postDelayed(runnable, 100);
                readTag();
            } else
            {
                readTime = 0L;
                handler.removeCallbacks(runnable);

                String scanData = getScanata(pastLeep(scanDataList));
                if (StringUtils.isEmpty(scanData))
                {
                    ToastUtil.showLongToast(mContext, "未扫描到电子车牌，请重新扫描！");
                } else
                {
                    //接口回调发送数据
                    if (um7UHFResult != null)
                    {
                        um7UHFResult.Result(scanData);
                    }
                }
                if (scanDataList.size() > 0)
                {
                    scanDataList.clear();
                }
                soundUtil.stopSound();
            }
        }
    };

    /**
     * 将扫描到的电子车牌内码拼接成字符串形式，如果只有一条则不加逗号分隔
     * 如E20000194901009609303DF8,CE20000193809017912009FA9,CE2000017580D017626500E15,CE2000017580D022526700E6A
     *
     * @param scanDataList 去重过的电子车牌内码list
     * @return
     */
    private String getScanata(List<String> scanDataList)
    {
        if (scanDataList == null || scanDataList.size() == 0)
        {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < scanDataList.size(); i++)
        {
            if (i == 0)
            {
                stringBuffer.append(params);
                stringBuffer.append(scanDataList.get(i));
            } else
            {
                stringBuffer.append(",");
                stringBuffer.append(params);
                stringBuffer.append(scanDataList.get(i));
            }
        }
        String data = stringBuffer.toString();
        LogUtils.dTag(TAG, "扫描到的字符串:" + data);
        return data;
    }

    /**
     * 将扫描到的电子车牌内码list去重
     *
     * @param list 扫描到的列表
     * @return
     */
    private List<String> pastLeep(List<String> list)
    {
        List<String> listNew = new ArrayList<>();
        Set set = new HashSet();
        for (String str : list)
        {
            if (set.add(str))
            {
                listNew.add(str);
            }
        }
        return listNew;
    }

    public class EmshStatusBroadcastReceiver extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent)
        {
            if (EmshConstant.Action.INTENT_EMSH_BROADCAST.equalsIgnoreCase(intent.getAction()))
            {
                int sessionStatus = intent.getIntExtra("SessionStatus", 0);
                int batteryPowerMode = intent.getIntExtra("BatteryPowerMode", -1);
                //                LogUtils.dTag(TAG, "sessionStatus:" + sessionStatus + ",batteryPowerMode:" + batteryPowerMode);

                if ((sessionStatus & EmshConstant.EmshSessionStatus.EMSH_STATUS_POWER_STATUS) != 0)
                {
                    // 把枪电池当前状态
                    if (batteryPowerMode == oldStatue)
                    { //相同状态不处理
                        return;
                    }
                    oldStatue = batteryPowerMode;
                    switch (batteryPowerMode)
                    {
                        case EmshConstant.EmshBatteryPowerMode.EMSH_PWR_MODE_STANDBY:
                            ActivityUtils.finishActivity(UHFConnectFailedDialogActivity.class);
                            uhfMyLib.powerOn();
                            break;
                        case EmshConstant.EmshBatteryPowerMode.EMSH_PWR_MODE_DSG_UHF:
                            ToastUtil.showLongToast(mContext, UHFConnect_Success);
                            break;
                        case EmshConstant.EmshBatteryPowerMode.EMSH_PWR_MODE_CHG_GENERAL:
                        case EmshConstant.EmshBatteryPowerMode.EMSH_PWR_MODE_CHG_QUICK:
                            ToastUtil.showLongToast(mContext, UHFConnect_Charging);
                            break;
                        case EmshConstant.EmshBatteryPowerMode.EMSH_PWR_MODE_CHG_FULL:
                            ToastUtil.showLongToast(mContext, UHFConnect_ChargingFinish);
                            break;
                    }
                } else
                {
                    ActivityUtils.startActivity(UHFConnectFailedDialogActivity.class);
                }
            }
        }
    }

    public interface UM7UHFResult
    {
        void Result(String data);
    }

    public void setUm7UHFResult(UM7UHFResult um7UHFResult)
    {
        this.um7UHFResult = um7UHFResult;
    }

}