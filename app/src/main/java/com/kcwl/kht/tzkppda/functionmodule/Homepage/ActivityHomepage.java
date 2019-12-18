/**
 * FileName: ActivityHomepage
 * Author:baijie
 * Date: 2019/11/26 15:19
 * Description: 首页页面
 */
package com.kcwl.kht.tzkppda.functionmodule.Homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.application.TZKPApplication;
import com.kcwl.kht.tzkppda.base.BaseActivity;
import com.kcwl.kht.tzkppda.bean.ActivityHomepageBean;
import com.kcwl.kht.tzkppda.functionmodule.Query.ActivityQuery;
import com.kcwl.kht.tzkppda.functionmodule.ScanElectronicLicensePlate.ActivityScanResult;
import com.kcwl.kht.tzkppda.uhf.UM7UHFUtil;
import com.kcwl.kht.tzkppda.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ClassName: ActivityHomepage
 * @Description: 首页页面
 * @Author: baijie
 * @Date: 2019/11/26 15:19
 */
public class ActivityHomepage extends BaseActivity
{
    @BindView(R.id.activity_homepage_rclv)
    RecyclerView rclv;
    private AdapterActivityHomepage adapterActivityHomepage;
    private String businessCode = "";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        showView();
    }

    private void showView()
    {
        adapterActivityHomepage = new AdapterActivityHomepage(
                R.layout.adapter_activityhomepage_item, getList());
        rclv.setLayoutManager(new LinearLayoutManager(ActivityHomepage.this));
        rclv.setAdapter(adapterActivityHomepage);
        adapterActivityHomepage.setOnItemClickListener(onItemClickListener);
    }

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_homepage;
    }

    @Override
    protected void initView()
    {
        setPageBackVisible(true);
        setPageTitle(Constant.PAGE_TITLE_MAINPAGE);
        businessCode = getIntent().getStringExtra(Constant.KEY_BUSINESSCODE);

    }

    private BaseQuickAdapter.OnItemClickListener onItemClickListener = new BaseQuickAdapter.OnItemClickListener()
    {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position)
        {
            jumpActivity((ActivityHomepageBean) adapter.getItem(position));
        }
    };

    private void jumpActivity(ActivityHomepageBean item)
    {
        if (ObjectUtils.isEmpty(item))
        {
            showShortToast("当前无业务信息无法跳转页面！");
            return;
        }

        if (item.getPageType().equals(Constant.PAGE_TITLE_SCANRESULT))
        {
            LogUtils.dTag("UHFUtils", "onClickbtn: 点击扫描");
            TZKPApplication.getUm7UHFUtil().startOrStoptScan();
        } else if (item.getPageType().equals(Constant.PAGE_TITLE_QUERY))
        {
            Intent intent = new Intent();
            intent.putExtra(Constant.KEY_BUSINESSCODE, businessCode);
            intent.setClass(ActivityHomepage.this, ActivityQuery.class);
            ActivityUtils.startActivity(intent);
        }
    }

    @Override
    protected void initData()
    {

    }

    private List<ActivityHomepageBean> getList()
    {
        String title[] = {"扫描电子车牌", "查询车辆信息"};
        String pageType[] = {Constant.PAGE_TITLE_SCANRESULT, Constant.PAGE_TITLE_QUERY};

        List<ActivityHomepageBean> list = new ArrayList<>();
        for (int i = 0; i < title.length; i++)
        {
            ActivityHomepageBean homepageBean = new ActivityHomepageBean();
            homepageBean.setTitle(title[i]);
            homepageBean.setPageType(pageType[i]);
            list.add(homepageBean);
        }

        return list;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_F8 && event.getAction() == KeyEvent.ACTION_DOWN)
        {
            LogUtils.dTag("UHFUtils", "onClickF8: 点击扫描");
            TZKPApplication.getUm7UHFUtil().startOrStoptScan();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 新版本扫码枪返回结果接口
     */
    private UM7UHFUtil.UM7UHFResult um7UHFResult = new UM7UHFUtil.UM7UHFResult()
    {
        @Override
        public void Result(String data)
        {
            //扫描到结果跳转到扫描结果页面，携带扫描结果参数
            Intent intent = new Intent(ActivityHomepage.this, ActivityScanResult.class);
            intent.putExtra(Constant.KEY_BUSINESSCODE, businessCode);
            intent.putExtra(Constant.KEY_PLATE, data);
            ActivityUtils.startActivity(intent);
        }
    };

    /**
     * 扫描枪初始化
     */
    private void initUHF()
    {
        TZKPApplication.getUm7UHFUtil().setUm7UHFResult(um7UHFResult);
        LogUtils.dTag("initUHFReceiver", "start");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        initUHF();
    }

}