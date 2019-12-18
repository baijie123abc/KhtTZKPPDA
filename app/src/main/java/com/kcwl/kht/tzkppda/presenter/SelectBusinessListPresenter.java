/**
 * FileName: SelectBusinessListPresenter
 * Author:baijie
 * Date: 2019/11/26 14:19
 * Description: 选择业务列表的presenter
 */
package com.kcwl.kht.tzkppda.presenter;

import android.content.Context;

import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.Gson;
import com.kcwl.kht.tzkppda.base.BasePresenter;
import com.kcwl.kht.tzkppda.base.BaseView;
import com.kcwl.kht.tzkppda.bean.SelectBusinessListBean;
import com.kcwl.kht.tzkppda.callback.MVPCallBack;
import com.kcwl.kht.tzkppda.model.SelectBusinessListModel;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.kcwl.kht.tzkppda.utils.ToastUtil;

/**
 * @ClassName: SelectBusinessListPresenter
 * @Description: 选择业务列表的presenter
 * @Author: baijie
 * @Date: 2019/11/26 14:19
 */
public class SelectBusinessListPresenter extends BasePresenter<BaseView>
{
    public final String TAG = SelectBusinessListPresenter.class.getSimpleName();

    public void getSelectBusinessList(Context context, String goodsName, String ywCode, int pageNo, int pageSize, String userId)
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

        new SelectBusinessListModel().getSelectBusinessList(goodsName, ywCode, pageNo, pageSize, userId, new MVPCallBack()
        {
            @Override
            public void onSuccess(String data)
            {
                if (isViewAttached())
                {
                    SelectBusinessListBean selectBusinessListBean = new Gson().fromJson(data, SelectBusinessListBean.class);
                    if (selectBusinessListBean.isSuccess())
                    {
                        getView().showSuccessData(TAG, selectBusinessListBean.getBody());
                    } else
                    {
                        getView().showFailMsg(TAG, selectBusinessListBean.getMsg());
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