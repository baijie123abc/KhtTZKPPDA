/**
 * FileName: UmengUtil
 * Author:baijie
 * Date: 2019/5/28 9:22
 * Description: 友盟统计工具类
 */
package com.kcwl.kht.tzkppda.utils;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

/**
 * @ClassName: UmengUtil
 * @Description: 友盟统计工具类
 * @Author: baijie
 * @Date: 2019/5/28 9:22
 */
public class UmengUtil
{
    private static final String appkey = "5ddc7f970cafb29abb000c89";
    private static final String channel = "KCWL_TZKPPDA";
    private static final String pushSecret = "";

    /**
     * 注意: 即使您已经在AndroidManifest.xml中配置过appkey和channel值，也需要在App代码中调
     * 用初始化接口（如需要使用AndroidManifest.xml中配置好的appkey和channel值，
     * UMConfigure.init调用中appkey和channel参数请置为null）。
     * 参数1:上下文，必须的参数，不能为空。
     * 参数2:【友盟+】 AppKey，非必须参数，如果Manifest文件中已配置AppKey，该参数可以传空，则使用Manifest中配置的AppKey，否则该参数必须传入。
     * 参数3:【友盟+】 Channel，非必须参数，如果Manifest文件中已配置Channel，该参数可以传空，则使用Manifest中配置的Channel，否则该参数必须传入，Channel命名请详见Channel渠道命名规范。
     * 参数4:设备类型，必须参数，传参数为UMConfigure.DEVICE_TYPE_PHONE则表示手机；传参数为UMConfigure.DEVICE_TYPE_BOX则表示盒子；默认为手机。
     * 参数5:Push推送业务的secret，需要集成Push功能时必须传入Push的secret，否则传空。
     */
    public static void init(Context context)
    {

        UMConfigure.setLogEnabled(true);
        UMConfigure.init(context, appkey, channel, UMConfigure.DEVICE_TYPE_PHONE, pushSecret);
        MobclickAgent.setScenarioType(context, MobclickAgent.EScenarioType.E_UM_NORMAL);
    }

    public static void umengonResume(Context context)
    {
        MobclickAgent.onResume(context);
    }

    public static void umengonPause(Context context)
    {
        MobclickAgent.onPause(context);
    }

    public static void onKillProcess(Context context)
    {
        MobclickAgent.onKillProcess(context);
    }


}