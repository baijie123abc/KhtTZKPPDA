/**
 * FileName: ActivityQuery
 * Author:baijie
 * Date: 2019/11/26 15:53
 * Description: 查询页面
 */
package com.kcwl.kht.tzkppda.functionmodule.Query;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.KeyboardUtils;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.base.BaseActivity;
import com.kcwl.kht.tzkppda.base.BaseView;
import com.kcwl.kht.tzkppda.bean.ScanListBean;
import com.kcwl.kht.tzkppda.customview.ViewControllerSearch;
import com.kcwl.kht.tzkppda.presenter.ScanPresenter;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ClassName: ActivityQuery
 * @Description: 查询页面
 * @Author: baijie
 * @Date: 2019/11/26 15:53
 */
public class ActivityQuery extends BaseActivity
{

    @BindView(R.id.activity_query_vcsearch)
    ViewControllerSearch vcSearch;
    @BindView(R.id.activity_query_rclv)
    RecyclerView rclv;
    @BindView(R.id.activity_selectbusiness_srlayout)
    SmartRefreshLayout srLayout;
    private AdapterActivityQuery adapterActivityQuery;
    private ScanPresenter scanPresenter;
    private int pageNo = 1;     //当前页
    private int pageSize = 10;  //每页几条
    private int pageNum;   //一共几页
    //是否加载更多
    private boolean isLoadMore;
    //是否下拉刷新
    private boolean isRefresh;
    //页面传来的业务id
    private String businessCode = "";
    //当前搜索的车牌号
    private String curSearchPlateNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        showView();
        initSmartRefreshLayout();
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
                reqSearch(ScanPresenter.TYPE_SEARCH, curSearchPlateNumber);
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
                    reqSearch(ScanPresenter.TYPE_SEARCH, curSearchPlateNumber);
                } else
                {
                    srLayout.finishLoadMoreWithNoMoreData();
                }
            }
        });
    }

    private void showView()
    {
        adapterActivityQuery = new AdapterActivityQuery(R.layout.adapter_activityquery_item, null,
                ActivityQuery.this);
        rclv.setLayoutManager(new LinearLayoutManager(ActivityQuery.this));
        rclv.setAdapter(adapterActivityQuery);

        vcSearch.setSearchViewControllerOnClickListener(searchViewControllerOnClickListener);
    }


    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_query;
    }

    @Override
    protected void initView()
    {
        setPageBackVisible(true);
        setPageTitle(Constant.PAGE_TITLE_QUERY);
        businessCode = getIntent().getStringExtra(Constant.KEY_BUSINESSCODE);
    }

    private ViewControllerSearch.SearchViewControllerOnClickListener searchViewControllerOnClickListener = new ViewControllerSearch.SearchViewControllerOnClickListener()
    {
        @Override
        public void onClickSearchInputBox(String searchContent)
        {
            curSearchPlateNumber = searchContent;
            reqSearch(ScanPresenter.TYPE_SEARCH, searchContent);
        }
    };

    @Override
    protected void initData()
    {
        scanPresenter = new ScanPresenter();
        scanPresenter.attached(baseView);
        //进入页面时请求全部数据
        reqSearch(ScanPresenter.TYPE_SEARCH, "");
    }

    private void setData(List<ScanListBean.BodyBean.RowsBean> rows)
    {
        if (rows == null)
        {
            return;
        }

        if (isRefresh)
        {//下拉刷新
            if (adapterActivityQuery.getData().size() > 0)
            {
                adapterActivityQuery.getData().clear();
            }
            adapterActivityQuery.setNewData(rows);
            srLayout.finishRefresh(1000);
            isRefresh = false;
        } else if (isLoadMore)
        {//上拉加载
            adapterActivityQuery.addData(rows);
            srLayout.finishLoadMore(1000);
            isLoadMore = false;
        } else
        {//进入页面
            if (adapterActivityQuery.getData().size() > 0)
            {
                adapterActivityQuery.getData().clear();
            }
            adapterActivityQuery.addData(rows);
        }
    }

    private BaseView baseView = new BaseView()
    {
        @Override
        public void showSuccessData(String reqType, Object object)
        {
            if (reqType.equals(scanPresenter.TAG))
            {
                ScanListBean.BodyBean bodyBean = (ScanListBean.BodyBean) object;
                pageNum = bodyBean.getPageNum();
                setData(bodyBean.getRows());
            }
        }

        @Override
        public void showFailMsg(String reqType, String msg)
        {
            if (reqType.equals(scanPresenter.TAG))
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
        }

        @Override
        public void showToast(String reqType, String msg)
        {
            if (reqType.equals(scanPresenter.TAG))
            {
                showShortToast(msg);
            }
        }
    };

    private void reqSearch(String type, String plateNumber)
    {
        scanPresenter.getScanList(ActivityQuery.this, plateNumber, businessCode, type, pageNo, pageSize);
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