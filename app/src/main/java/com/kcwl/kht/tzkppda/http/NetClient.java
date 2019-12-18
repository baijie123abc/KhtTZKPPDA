/**
 * FileName: NetClient
 * Author:baijie
 * Date: 2019/11/13 16:32
 * Description: NetClient
 */
package com.kcwl.kht.tzkppda.http;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.SPUtils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName: NetClient
 * @Description: NetClient
 * @Author: baijie
 * @Date: 2019/11/13 16:32
 */
public class NetClient
{
    private static NetClient netClient;
    private Retrofit mRetrofit;
    private Map<String, String> mHeaders;
    private OkHttpClient mClient;
    /**
     * 默认连接超时时间
     */
    private static final long DEFAULT_CONNECT_TIMEOUT_MILLS = 10 * 1000L;
    /**
     * 默认读取超时时间
     */
    private static final long DEFAULT_READ_TIMEOUT_MILLS = 10 * 1000L;


    public NetClient()
    {
        init();
    }

    public static NetClient getClient()
    {
        if (null == netClient)
            netClient = new NetClient();
        return netClient;
    }

    private void init()
    {
        //初始化header.
        mHeaders = new HashMap<>();
        mHeaders.put("Content-Type", "application/json");

        getHttpClient();

        String url = SPUtils.getInstance().getString(Constant.KEY_IP);
        if (!TextUtils.isEmpty(url))
        {
            getRetrofit(url);
        }
    }

    /**
     * 获取httpclient
     *
     * @return OkHttpClient
     */
    private OkHttpClient getHttpClient()
    {
        if (mClient == null)
        {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //自动重连
            builder.retryOnConnectionFailure(true);
            // 连接超时时间
            builder.connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLS, TimeUnit.MILLISECONDS);
            // 读取超时时间
            builder.readTimeout(DEFAULT_READ_TIMEOUT_MILLS, TimeUnit.MILLISECONDS);
            // 拦截器
            builder.addInterceptor(mInterceptor);
            builder.addInterceptor(logInterceptor);
            builder.addInterceptor(sLoggingInterceptor);

            mClient = builder.build();
        }
        return mClient;
    }


    /**
     * 获取Retrofit
     *
     * @return 获取Retrofit
     */
    public Retrofit getRetrofit(String url)
    {
        if (mRetrofit == null)
        {
            Retrofit.Builder builder = new Retrofit.Builder().baseUrl(url)//配置BaseUrl
                    .client(getHttpClient())// 设置client
                    .addConverterFactory(GsonConverterFactory.create());//gson转换器
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            mRetrofit = builder.build();
        }
        return mRetrofit;
    }

    //配置打印
    private HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC);


    private Interceptor mInterceptor = new Interceptor()
    {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException
        {
            Request oldRequest = chain.request();
            Request.Builder build = oldRequest.newBuilder().method(oldRequest.method(), oldRequest.body()).url(oldRequest.url());
            for (String k : mHeaders.keySet())
            {
                build.addHeader(k, mHeaders.get(k));
            }
            //所有接口请求头添加token,登录token为空
            build.header("token", Constant.USER_TOKEN);
            return chain.proceed(build.build());
        }
    };

    /**
     * 打印返回的json数据拦截器
     */
    private static final Interceptor sLoggingInterceptor = new Interceptor()
    {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException
        {
            final Request request = chain.request();
            Buffer requestBuffer = new Buffer();
            if (request.body() != null)
            {
                request.body().writeTo(requestBuffer);
            } else
            {
                Logger.d("LogTAG", "request.body() == null");
            }
            //打印url信息
            Logger.w(request.url() + (request.body() != null ? "?" + _parseParams(request.body(), requestBuffer) : ""));
            final Response response = chain.proceed(request);
            return response;
        }
    };

    @NonNull
    private static String _parseParams(RequestBody body, Buffer requestBuffer) throws UnsupportedEncodingException
    {
        if (body.contentType() != null && !body.contentType().toString().contains("multipart"))
        {
            return URLDecoder.decode(requestBuffer.readUtf8(), "UTF-8");
        }
        return "null";
    }

    private boolean isInit()
    {
        return null != mRetrofit;
    }

    /**
     * 得到代理后的service
     *
     * @param service ...
     * @param <T>     ...
     * @return 代理后的service
     */
    public <T> T create(final Class<T> service)
    {
        if (!isInit())
            throw new NullPointerException("RestClient没有被初始化,需执行init()");
        return mRetrofit.create(service);
    }

    /**
     * 重新设置访问地址
     *
     * @param url
     */
    public void resetUrl(String url)
    {
        mRetrofit = null;
        getRetrofit(url);
    }
}