/**
 * FileName: ActivitySetting
 * Author:baijie
 * Date: 2019/11/26 10:22
 * Description: 设置页面
 */
package com.kcwl.kht.tzkppda.functionmodule.Setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.application.TZKPApplication;
import com.kcwl.kht.tzkppda.base.BaseActivity;
import com.kcwl.kht.tzkppda.base.BaseModel;
import com.kcwl.kht.tzkppda.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ClassName: ActivitySetting
 * @Description: 设置页面
 * @Author: baijie
 * @Date: 2019/11/26 10:22
 */
public class ActivitySetting extends BaseActivity
{

    @BindView(R.id.activity_setting_cl_setnet_btn_saveip)
    Button btnSaveip;
    @BindView(R.id.activity_setting_cl_setnet_et_ip)
    EditText etIp;
    @BindView(R.id.activity_setting_cl_uhfpower_btn_saveuhfpower)
    Button btnSaveuhfpower;
    @BindView(R.id.activity_setting_cl_uhfpower_et_uhfpower)
    EditText etUhfpower;
    @BindView(R.id.activity_setting_cl_uhfscantime_btn_saveuhfscantime)
    Button btnSaveuhfscantime;
    @BindView(R.id.activity_setting_cl_uhfscantime_et_uhfscantime)
    EditText etUhfscantime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        showRememberIp();
    }

    private void showRememberIp()
    {
        etIp.setText(SPUtils.getInstance().getString(Constant.KEY_IP));
    }

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView()
    {
        setPageTitle(Constant.PAGE_TITLE_SETTING);
        setPageBackVisible(true);
    }

    @Override
    protected void initData()
    {

    }

    @OnClick({R.id.activity_setting_cl_setnet_btn_saveip, R.id.activity_setting_cl_uhfpower_btn_saveuhfpower,
            R.id.activity_setting_cl_uhfscantime_btn_saveuhfscantime})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.activity_setting_cl_setnet_btn_saveip:
                dealSaveIp();
                break;
            case R.id.activity_setting_cl_uhfpower_btn_saveuhfpower:
                saveUhfPower();
                break;
            case R.id.activity_setting_cl_uhfscantime_btn_saveuhfscantime:
                saveUhfScanTime();
                break;
        }
    }

    private void saveUhfScanTime()
    {
        String scanTime = etUhfscantime.getText().toString().trim();
        if (StringUtils.isEmpty(scanTime))
        {
            showLongToast("请输入扫描时长！");
            return;
        }

        if (Integer.valueOf(scanTime) < 1)
        {
            showLongToast("请输入大于0的时长！");
            etUhfscantime.setText("");
            return;
        }

        SPUtils.getInstance().put(Constant.KEY_SCANTIME, Long.parseLong(scanTime));
        showLongToast("扫描时长设置成功，当前扫描时长为：" + scanTime + "秒");
    }

    private void saveUhfPower()
    {
        String power = etUhfpower.getText().toString().trim();
        if (StringUtils.isEmpty(power))
        {
            showLongToast("请输入功率数值！");
            return;
        }

        if (Integer.valueOf(power) < 5 || Integer.valueOf(power) > 30)
        {
            showLongToast("请输入5-30之间的功率数值！");
            etUhfpower.setText("");
            return;
        }

        boolean flag = TZKPApplication.getUm7UHFUtil().getUhfMyLib().powerSet(Integer.valueOf(power));
        if (flag)
        {
            showLongToast("把枪功率设置成功，当前功率为：" + TZKPApplication.getUm7UHFUtil().getUhfMyLib().powerGet());
        }
    }


    private void dealSaveIp()
    {
        String ip = etIp.getText().toString().trim();

        if (TextUtils.isEmpty(ip))
        {
            showShortToast(Constant.IP_NOT_EMPTY);
            return;
        }

        if (!TextUtils.isEmpty(ip) && SPUtils.getInstance().getString(Constant.KEY_IP).equals(ip))
        {
            showShortToast(Constant.IP_NOT_CHANGE);
            return;
        }

        if (!RegexUtils.isURL(ip))
        {
            showShortToast(Constant.IP_REGEX);
            return;
        }

        SPUtils.getInstance().put(Constant.KEY_IP, ip);
        BaseModel.resetUrl(ip);
        showShortToast(Constant.SAVE_SUCCESS);
    }
}