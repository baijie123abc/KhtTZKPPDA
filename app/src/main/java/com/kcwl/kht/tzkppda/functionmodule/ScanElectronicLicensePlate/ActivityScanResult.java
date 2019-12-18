/**
 * FileName: ActivityScanResult
 * Author:baijie
 * Date: 2019/11/26 15:49
 * Description: 扫描结果页面
 */
package com.kcwl.kht.tzkppda.functionmodule.ScanElectronicLicensePlate;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.application.TZKPApplication;
import com.kcwl.kht.tzkppda.base.BaseActivity;
import com.kcwl.kht.tzkppda.base.BaseView;
import com.kcwl.kht.tzkppda.bean.ResponseMsgBean;
import com.kcwl.kht.tzkppda.bean.ScanResultBean;
import com.kcwl.kht.tzkppda.presenter.SaveScanPoundPresenter;
import com.kcwl.kht.tzkppda.presenter.ScanPresenter;
import com.kcwl.kht.tzkppda.uhf.UM7UHFUtil;
import com.kcwl.kht.tzkppda.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ClassName: ActivityScanResult
 * @Description: 扫描结果页面
 * @Author: baijie
 * @Date: 2019/11/26 15:49
 */
public class ActivityScanResult extends BaseActivity
{
    @BindView(R.id.activity_scanresult_rclv)
    RecyclerView rclv;
    private AdapterActivityScanResult adapterActivityScanResult;
    private ScanPresenter scanPresenter;
    private SaveScanPoundPresenter saveScanPoundPresenter;
    //页面传参携带的电子车牌参数
    private String ePlate;
    //页面传来的业务id
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
        adapterActivityScanResult = new AdapterActivityScanResult(R.layout.adapter_activityscanresult_item, null,
                ActivityScanResult.this);
        rclv.setLayoutManager(new LinearLayoutManager(ActivityScanResult.this));
        rclv.setAdapter(adapterActivityScanResult);
        adapterActivityScanResult.setOnItemChildClickListener(onItemChildClickListener);
    }

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_scanresult;
    }

    @Override
    protected void initView()
    {
        setPageBackVisible(true);
        setPageTitle(Constant.PAGE_TITLE_SCANRESULT);
        ePlate = getIntent().getStringExtra(Constant.KEY_PLATE);
        businessCode = getIntent().getStringExtra(Constant.KEY_BUSINESSCODE);
    }


    private BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener = new BaseQuickAdapter.OnItemChildClickListener()
    {
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position)
        {
            if (view.getId() == R.id.adapter_activityscanresult_item_btn_confirm)
            {
                dealSavePound((ScanResultBean.BodyBean.PoundBean) adapter.getItem(position));
            }
        }
    };

    private void dealSavePound(ScanResultBean.BodyBean.PoundBean item)
    {
        if (ObjectUtils.isEmpty(item))
        {
            showLongToast("无磅单信息无法确认！");
            return;
        }

        reqSaveScanPound(item);

    }

    @Override
    protected void initData()
    {
        scanPresenter = new ScanPresenter();
        scanPresenter.attached(baseView);

        saveScanPoundPresenter = new SaveScanPoundPresenter();
        saveScanPoundPresenter.attached(baseView);

        reqSearch(ScanPresenter.TYPE_SCAN, ePlate);
    }

    private BaseView baseView = new BaseView()
    {
        @Override
        public void showSuccessData(String reqType, Object object)
        {
            if (reqType.equals(scanPresenter.TAG))
            {
                ScanResultBean.BodyBean.PoundBean poundBean = (ScanResultBean.BodyBean.PoundBean) object;
                adapterActivityScanResult.addData(poundBean);
            }

            if (reqType.equals(saveScanPoundPresenter.TAG))
            {
                ResponseMsgBean responseMsgBean = (ResponseMsgBean) object;
                showShortToast(responseMsgBean.getMsg());
                ActivityScanResult.this.finish();
            }
        }

        @Override
        public void showFailMsg(String reqType, String msg)
        {
            if (reqType.equals(scanPresenter.TAG))
            {
                showShortToast(msg);
            }

            if (reqType.equals(saveScanPoundPresenter.TAG))
            {
                showShortToast(msg);
            }
        }

        @Override
        public void showErrorMsg(String reqType, String msg)
        {
            if (reqType.equals(scanPresenter.TAG))
            {
                showShortToast(msg);
            }

            if (reqType.equals(saveScanPoundPresenter.TAG))
            {
                showShortToast(msg);
            }
        }

        @Override
        public void showToast(String reqType, String msg)
        {
            if (reqType.equals(scanPresenter.TAG))
            {
                showShortToast(msg);
            }

            if (reqType.equals(saveScanPoundPresenter.TAG))
            {
                showShortToast(msg);
            }
        }
    };

    private void reqSearch(String type, String data)
    {
        scanPresenter.getScanResult(ActivityScanResult.this, data, businessCode, type, 1, 1);
    }


    private void reqSaveScanPound(ScanResultBean.BodyBean.PoundBean poundBean)
    {
        saveScanPoundPresenter.saveScanPound(ActivityScanResult.this, poundBean);
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
            //根据扫描到的电子车牌请求接口
            reqSearch(ScanPresenter.TYPE_SCAN, data);
        }
    };

    /**
     * 初始化扫描枪
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

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (scanPresenter != null)
        {
            scanPresenter.detachView();
        }
    }
}