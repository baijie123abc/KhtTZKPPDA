/**
 * FileName: LoginModel
 * Author:baijie
 * Date: 2019/11/26 10:14
 * Description: 登录的model
 */
package com.kcwl.kht.tzkppda.model;

import com.kcwl.kht.tzkppda.base.BaseModel;
import com.kcwl.kht.tzkppda.callback.MVPCallBack;
import com.kcwl.kht.tzkppda.http.NetObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: LoginModel
 * @Description: 登录的model
 * @Author: baijie
 * @Date: 2019/11/26 10:14
 */
public class LoginModel extends BaseModel
{

    public void login(String userName, String passWord, MVPCallBack mvpCallBack)
    {
        netApi.login(userName, passWord).subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer<Disposable>()
        {
            @Override
            public void accept(Disposable disposable) throws Exception
            {

            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new NetObserver()
        {
            @Override
            public void Subscribe(Disposable d)
            {

            }

            @Override
            public void onSuccess(String data)
            {
                mvpCallBack.onSuccess(data);
            }

            @Override
            public void onDataEror(String msg)
            {
                mvpCallBack.onFail(msg);
            }

            @Override
            public void onFailure(NetObserver.Error error)
            {
                mvpCallBack.onError(error.msg);
            }

            @Override
            public void onEnd()
            {
                mvpCallBack.onComplete();
            }
        });
    }

}