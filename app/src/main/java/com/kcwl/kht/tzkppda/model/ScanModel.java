/**
 * FileName: ScanModel
 * Author:baijie
 * Date: 2019/11/26 16:18
 * Description: 扫描页面的model
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
 * @ClassName: ScanModel
 * @Description: 扫描页面的model
 * @Author: baijie
 * @Date: 2019/11/26 16:18
 */
public class ScanModel extends BaseModel
{

    public void getScanResult(String data, String ywId, String type, int pageNo, int pageSize, MVPCallBack mvpCallBack)
    {
        netApi.getScanResult(data, ywId, type, pageNo, pageSize).subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer<Disposable>()
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


    public void getScanList(String plateNumber, String ywId, String type, int pageNo, int pageSize, MVPCallBack mvpCallBack)
    {
        netApi.getScanList(plateNumber, ywId, type, pageNo, pageSize).subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer<Disposable>()
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