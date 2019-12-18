/**
 * FileName: SelectBusinessListModel
 * Author:baijie
 * Date: 2019/11/26 14:13
 * Description: 选择业务列表的model
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
 * @ClassName: SelectBusinessListModel
 * @Description: 选择业务列表的model
 * @Author: baijie
 * @Date: 2019/11/26 14:13
 */
public class SelectBusinessListModel extends BaseModel
{
    public void getSelectBusinessList(String goodsName, String ywCode, int pageNo, int pageSize, String userId, MVPCallBack mvpCallBack)
    {
        netApi.getSelectBusinessList(goodsName, ywCode, pageNo, pageSize, userId).subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer<Disposable>()
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