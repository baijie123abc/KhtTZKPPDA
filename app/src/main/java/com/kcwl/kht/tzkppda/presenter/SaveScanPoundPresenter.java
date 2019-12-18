/**
 * FileName: SaveScanPoundPresenter
 * Author:baijie
 * Date: 2019/11/26 17:52
 * Description: 保存扫描磅单的presenter
 */
package com.kcwl.kht.tzkppda.presenter;

import android.content.Context;

import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.Gson;
import com.kcwl.kht.tzkppda.base.BasePresenter;
import com.kcwl.kht.tzkppda.base.BaseView;
import com.kcwl.kht.tzkppda.bean.ResponseMsgBean;
import com.kcwl.kht.tzkppda.bean.ScanResultBean;
import com.kcwl.kht.tzkppda.callback.MVPCallBack;
import com.kcwl.kht.tzkppda.model.SaveScanPoundModel;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.kcwl.kht.tzkppda.utils.ToastUtil;

/**
 * @ClassName: SaveScanPoundPresenter
 * @Description: 保存扫描磅单的presenter
 * @Author: baijie
 * @Date: 2019/11/26 17:52
 */
public class SaveScanPoundPresenter extends BasePresenter<BaseView>
{

    public final String TAG = SaveScanPoundPresenter.class.getSimpleName();

    public void saveScanPound(Context context, ScanResultBean.BodyBean.PoundBean poundBean)
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

        new SaveScanPoundModel().saveScanPound(poundBean, new MVPCallBack()
        {
            @Override
            public void onSuccess(String data)
            {
                if (isViewAttached())
                {
                    ResponseMsgBean responseMsgBean = new Gson().fromJson(data, ResponseMsgBean.class);
                    if (responseMsgBean.isSuccess())
                    {
                        getView().showSuccessData(TAG, responseMsgBean);
                    } else
                    {
                        getView().showFailMsg(TAG, responseMsgBean.getMsg());
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