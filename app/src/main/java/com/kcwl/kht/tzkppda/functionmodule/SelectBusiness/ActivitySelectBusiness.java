/**
 * FileName: ActivitySelectBusiness
 * Author:baijie
 * Date: 2019/11/26 10:19
 * Description: 选择业务页面
 */
package com.kcwl.kht.tzkppda.functionmodule.SelectBusiness;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.application.TZKPApplication;
import com.kcwl.kht.tzkppda.base.BaseActivity;
import com.kcwl.kht.tzkppda.base.BaseView;
import com.kcwl.kht.tzkppda.bean.SelectBusinessListBean;
import com.kcwl.kht.tzkppda.functionmodule.Homepage.ActivityHomepage;
import com.kcwl.kht.tzkppda.presenter.SelectBusinessListPresenter;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.kcwl.kht.tzkppda.utils.UmengUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ClassName: ActivitySelectBusiness
 * @Description: 选择业务页面
 * @Author: baijie
 * @Date: 2019/11/26 10:19
 */
public class ActivitySelectBusiness extends BaseActivity
{

    @BindView(R.id.activity_selectbusiness_rclv)
    RecyclerView rclv;
    @BindView(R.id.activity_selectbusiness_srlayout)
    SmartRefreshLayout srLayout;
    private AdapterActivitySelectBusiness adapterActivitySelectBusiness;
    private SelectBusinessListPresenter selectBusinessListPresenter;
    private int pageNo = 1;     //当前页
    private int pageSize = 10;  //每页几条
    private int pageNum;   //一共几页
    //是否加载更多
    private boolean isLoadMore;
    //是否下拉刷新
    private boolean isRefresh;

    //第一次返回按钮计时
    private long firstTime = 0;
    //点击返回键退出的时间
    private int cilckBackKeyTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initSmartRefreshLayout();
        showView();
    }

    private void showView()
    {
        adapterActivitySelectBusiness = new AdapterActivitySelectBusiness(
                R.layout.adapter_activityselectbusiness_item, null, ActivitySelectBusiness.this);
        rclv.setLayoutManager(new LinearLayoutManager(ActivitySelectBusiness.this));
        rclv.setAdapter(adapterActivitySelectBusiness);
        adapterActivitySelectBusiness.setOnItemClickListener(onItemClickListener);
    }

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_selectbusiness;
    }

    @Override
    protected void initView()
    {
        setPageTitle(Constant.PAGE_TITLE_SELECTBUSINESS);
    }


    private void initSmartRefreshLayout()
    {
        //下拉刷新
        srLayout.setOnRefreshListener(new OnRefreshListener()
        {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout)
            {
                srLayout.setNoMoreData(false);
                isRefresh = true;
                pageNo = 1;
                reqList();
            }
        });

        //上拉加载更多
        srLayout.setOnLoadMoreListener(new OnLoadMoreListener()
        {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout)
            {
                if (pageNo < pageNum)
                {
                    pageNo++;
                    isLoadMore = true;
                    reqList();
                } else
                {
                    srLayout.finishLoadMoreWithNoMoreData();
                }
            }
        });
    }

    private BaseQuickAdapter.OnItemClickListener onItemClickListener = new BaseQuickAdapter.OnItemClickListener()
    {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position)
        {
            jumpActivityHomepage((SelectBusinessListBean.BodyBean.RowsBean) adapter.getItem(position));
        }
    };

    private void jumpActivityHomepage(SelectBusinessListBean.BodyBean.RowsBean item)
    {
        if (ObjectUtils.isEmpty(item))
        {
            showShortToast("当前无业务信息无法选择！");
            return;
        }

        Intent intent = new Intent(ActivitySelectBusiness.this, ActivityHomepage.class);
        intent.putExtra(Constant.KEY_BUSINESSCODE, item.getId());
        ActivityUtils.startActivity(intent);
    }

    @Override
    protected void initData()
    {
        selectBusinessListPresenter = new SelectBusinessListPresenter();
        selectBusinessListPresenter.attached(baseView);
        reqList();
    }

    private void reqList()
    {
        selectBusinessListPresenter.getSelectBusinessList(ActivitySelectBusiness.this,
                "", "", pageNo, pageSize, SPUtils.getInstance().getString(Constant.KEY_USERID));
    }


    private void setData(List<SelectBusinessListBean.BodyBean.RowsBean> rows)
    {
        if (rows == null)
        {
            return;
        }

        if (isRefresh)
        {//下拉刷新
            if (adapterActivitySelectBusiness.getData().size() > 0)
            {
                adapterActivitySelectBusiness.getData().clear();
            }
            adapterActivitySelectBusiness.setNewData(rows);
            srLayout.finishRefresh(1000);
            isRefresh = false;
        } else if (isLoadMore)
        {//上拉加载
            adapterActivitySelectBusiness.addData(rows);
            srLayout.finishLoadMore(1000);
            isLoadMore = false;
        } else
        {//进入页面
            if (adapterActivitySelectBusiness.getData().size() > 0)
            {
                adapterActivitySelectBusiness.getData().clear();
            }
            adapterActivitySelectBusiness.addData(rows);
        }
    }

    private BaseView baseView = new BaseView()
    {
        @Override
        public void showSuccessData(String reqType, Object object)
        {
            if (reqType.equals(selectBusinessListPresenter.TAG))
            {
                SelectBusinessListBean.BodyBean bodyBean = (SelectBusinessListBean.BodyBean) object;
                pageNum = bodyBean.getPageNum();
                setData(bodyBean.getRows());
            }
        }

        @Override
        public void showFailMsg(String reqType, String msg)
        {
            if (reqType.equals(selectBusinessListPresenter.TAG))
            {
                showShortToast(msg);
                setRefreshAndLoadMoreViewIsShow();
            }
        }

        @Override
        public void showErrorMsg(String reqType, String msg)
        {
            if (reqType.equals(selectBusinessListPresenter.TAG))
            {
                showShortToast(msg);
                setRefreshAndLoadMoreViewIsShow();
            }
        }

        @Override
        public void showToast(String reqType, String msg)
        {
            if (reqType.equals(selectBusinessListPresenter.TAG))
            {
                showShortToast(msg);
                setRefreshAndLoadMoreViewIsShow();
            }
        }
    };

    /**
     * 设置下拉刷新和加载更多页面是否显示
     */
    private void setRefreshAndLoadMoreViewIsShow()
    {
        if (srLayout != null)
        {
            srLayout.finishRefresh();
            srLayout.finishLoadMore();
        }

        isLoadMore = false;
        isRefresh = false;
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (selectBusinessListPresenter != null)
        {
            selectBusinessListPresenter.detachView();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        switch (keyCode)
        {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > cilckBackKeyTime)
                {
                    showShortToast(Constant.EXIT_WORD);
                    firstTime = secondTime;
                } else
                {//完全退出
                    exit();
                }
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit()
    {
        UmengUtil.onKillProcess(this);
        TZKPApplication.getUm7UHFUtil().recyleResoure();
        AppUtils.exitApp();
        killApp();
    }


    /**
     * 彻底退出应用
     */
    private void killApp()
    {
        android.os.Process.killProcess(android.os.Process.myPid());
        ActivityManager manager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        if (manager != null)
        {
            manager.killBackgroundProcesses(AppUtils.getAppPackageName());
        }
    }
}