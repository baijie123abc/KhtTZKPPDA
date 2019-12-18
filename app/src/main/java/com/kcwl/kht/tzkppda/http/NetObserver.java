/**
 * FileName: NetObserver
 * Author:baijie
 * Date: 2019/11/13 16:37
 * Description: NetObserver
 */
package com.kcwl.kht.tzkppda.http;

import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.orhanobut.logger.Logger;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * @ClassName: NetObserver
 * @Description: NetObserver
 * @Author: baijie
 * @Date: 2019/11/13 16:37
 */
public abstract class NetObserver implements Observer<ResponseBody>
{
    private static final String TAG = NetObserver.class.getSimpleName();

    private Error responeError;

    public abstract void Subscribe(Disposable d);

    public abstract void onSuccess(String data);

    public abstract void onDataEror(String msg);

    public abstract void onFailure(Error error);

    public abstract void onEnd();


    @Override
    public void onSubscribe(Disposable d)
    {
        Subscribe(d);
    }

    @Override
    public void onNext(ResponseBody baseBeanResponse)
    {
        try
        {
            String data = baseBeanResponse.string();
            if (TextUtils.isEmpty(data))
            {
                LogUtils.dTag(TAG, "onNext:请求失败： " + Constant.NET_DATA_ERRORWORD);
                onDataEror(Constant.NET_DATA_ERRORWORD);
            } else
            {
                LogUtils.dTag(TAG, "onNext:请求成功：" + data);
                onSuccess(data);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
            onDataEror("数据异常！");
            LogUtils.dTag(TAG, "onNext:请求失败：数据解析异常！");
        }
    }

    @Override
    public void onError(Throwable e)
    {
        Error error = parseThrowable(e);
        onFailure(error);
    }

    @Override
    public void onComplete()
    {
        onEnd();
    }

    public static class Error
    {
        public String msg;
    }

    /**
     * 解析异常<br/>
     * 让异常信息更加友好
     *
     * @param throwable 从RestClient抛上来的异常信息
     * @return Error
     */
    private Error parseThrowable(Throwable throwable)
    {
        Error error = new Error();
        if (throwable instanceof HttpException || throwable instanceof ConnectException
                || throwable instanceof SocketTimeoutException || throwable instanceof JsonParseException
                || throwable instanceof JSONException)
        {
            error.msg = HttpNetException.handleException(throwable);
        }
        Logger.d(throwable.getMessage());
        return error;
    }
}