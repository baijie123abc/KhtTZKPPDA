/**
 * FileName: LoginPresenter
 * Author:baijie
 * Date: 2019/11/26 10:15
 * Description: 登录的presenter
 */
package com.kcwl.kht.tzkppda.presenter;

import android.content.Context;

import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.Gson;
import com.kcwl.kht.tzkppda.base.BasePresenter;
import com.kcwl.kht.tzkppda.base.BaseView;
import com.kcwl.kht.tzkppda.bean.LoginBean;
import com.kcwl.kht.tzkppda.callback.MVPCallBack;
import com.kcwl.kht.tzkppda.model.LoginModel;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.kcwl.kht.tzkppda.utils.ToastUtil;

/**
 * @ClassName: LoginPresenter
 * @Description: 登录的presenter
 * @Author: baijie
 * @Date: 2019/11/26 10:15
 */
public class LoginPresenter extends BasePresenter<BaseView>
{
    public final String TAG = LoginPresenter.class.getSimpleName();

    public void login(Context context, String userName, String passWord)
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

        new LoginModel().login(userName, passWord, new MVPCallBack()
        {
            @Override
            public void onSuccess(String data)
            {
                if (isViewAttached())
                {
                    LoginBean loginBean = new Gson().fromJson(data, LoginBean.class);
                    if (loginBean.isSuccess())
                    {
                        getView().showSuccessData(TAG, loginBean);
                    } else
                    {
                        getView().showFailMsg(TAG, loginBean.getMsg());
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