/**
 * FileName: ScanPresenter
 * Author:baijie
 * Date: 2019/11/26 16:21
 * Description: 扫描的presenter
 */
package com.kcwl.kht.tzkppda.presenter;

import android.content.Context;

import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.Gson;
import com.kcwl.kht.tzkppda.base.BasePresenter;
import com.kcwl.kht.tzkppda.base.BaseView;
import com.kcwl.kht.tzkppda.bean.ScanListBean;
import com.kcwl.kht.tzkppda.bean.ScanResultBean;
import com.kcwl.kht.tzkppda.callback.MVPCallBack;
import com.kcwl.kht.tzkppda.model.ScanModel;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.kcwl.kht.tzkppda.utils.ToastUtil;

/**
 * @ClassName: ScanPresenter
 * @Description: 扫描的presenter
 * @Author: baijie
 * @Date: 2019/11/26 16:21
 */
public class ScanPresenter extends BasePresenter<BaseView>
{
    public final String TAG = ScanPresenter.class.getSimpleName();
    //1表示扫描
    public static final String TYPE_SCAN = "1";
    //0表示搜索
    public static final String TYPE_SEARCH = "0";

    public void getScanResult(Context context, String data, String ywId, String type, int pageNo, int pageSize)
    {
        if (!NetworkUtils.isConnected())
        {
            ToastUtil.showLongToast(context, Constant.NET_IS_NOT_AVAILABLE);
            return;
        }

        if (isNetUrlEmpty())
        {
            ToastUtil.showLongToast(context, Constant.NO_URL_WORD);
            return;
        }

        new ScanModel().getScanResult(data, ywId, type, pageNo, pageSize, new MVPCallBack()
        {
            @Override
            public void onSuccess(String data)
            {
                if (isViewAttached())
                {
                    ScanResultBean scanResultBean = new Gson().fromJson(data, ScanResultBean.class);
                    if (scanResultBean.isSuccess())
                    {
                        getView().showSuccessData(TAG, scanResultBean.getBody().getPound());
                    } else
                    {
                        getView().showFailMsg(TAG, scanResultBean.getMsg());
                    }
                }
            }

            @Override
            public void onFail(String msg)
            {
                if (isViewAttached())
                {
                    getView().showFailMsg(TAG, msg);
                }
            }

            @Override
            public void onError(String msg)
            {
                if (isViewAttached())
                {
                    getView().showErrorMsg(TAG, msg);
                }
            }

            @Override
            public void onComplete()
            {

            }
        });
    }

    public void getScanList(Context context, String plateNumber, String ywId, String type, int pageNo, int pageSize)
    {
        if (!NetworkUtils.isConnected())
        {
            ToastUtil.showLongToast(context, Constant.NET_IS_NOT_AVAILABLE);
            return;
        }

        if (isNetUrlEmpty())
        {
            ToastUtil.showLongToast(context, Constant.NO_URL_WORD);
            return;
        }

        new ScanModel().getScanList(plateNumber, ywId, type, pageNo, pageSize, new MVPCallBack()
        {
            @Override
            public void onSuccess(String data)
            {
                if (isViewAttached())
                {
                    ScanListBean scanListBean = new Gson().fromJson(data, ScanListBean.class);
                    if (scanListBean.isSuccess())
                    {
                        getView().showSuccessData(TAG, scanListBean.getBody());
                    } else
                    {
                        getView().showFailMsg(TAG, scanListBean.getMsg());
                    }
                }
            }

            @Override
            public void onFail(String msg)
            {
                if (isViewAttached())
                {
                    getView().showFailMsg(TAG, msg);
                }
            }

            @Override
            public void onError(String msg)
            {
                if (isViewAttached())
                {
                    getView().showErrorMsg(TAG, msg);
                }
            }

            @Override
            public void onComplete()
            {

            }
        });
    }
}