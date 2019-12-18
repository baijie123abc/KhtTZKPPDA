/**
 * FileName: HttpNetException
 * Author:baijie
 * Date: 2019/11/13 16:40
 * Description: 自定义的网络异常解析
 */
package com.kcwl.kht.tzkppda.http;

import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

/**
 * @ClassName: HttpNetException
 * @Description: 自定义的网络异常解析
 * @Author: baijie
 * @Date: 2019/11/13 16:40
 */
public class HttpNetException
{
    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static String handleException(Throwable e)
    {
        String exception = "";
        if (e instanceof HttpException)
        {//HTTP错误
            HttpException httpException = (HttpException) e;
            switch (httpException.code())
            {
                case UNAUTHORIZED:
                    exception = httpException.code() + " 未授权的错误";
                    break;
                case FORBIDDEN:
                    exception = httpException.code() + " 禁止访问";
                    break;
                case NOT_FOUND:
                    exception = httpException.code() + " 未找到";
                    break;
                case REQUEST_TIMEOUT:
                    exception = httpException.code() + " 请求超时";
                    break;
                case GATEWAY_TIMEOUT:
                    exception = httpException.code() + " 网关超时";
                    break;
                case INTERNAL_SERVER_ERROR:
                    exception = httpException.code() + " 内部服务器错误";
                    break;
                case BAD_GATEWAY:
                    exception = httpException.code() + " 网关错误";
                    break;
                case SERVICE_UNAVAILABLE:
                    exception = httpException.code() + " 服务不可用";
                    break;
                default:
                    exception = httpException.code() + " 网络错误";
                    break;
            }
            return exception;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException)
        {
            exception = "解析错误";            //均视为解析错误
            return exception;
        } else if (e instanceof ConnectException)
        {
            exception = "网络连接失败";  //均视为网络错误
            return exception;
        } else if (e instanceof SocketTimeoutException)
        {
            exception = "请求超时";          //未知错误
            return exception;
        } else
        {
            exception = "未知错误";          //未知错误
            return exception;
        }
    }
}

/**
 * 约定异常
 */

class ERROR
{
    /**
     * 未知错误
     */
    public static final int UNKNOWN = 1000;
    /**
     * 解析错误
     */
    public static final int PARSE_ERROR = 1001;
    /**
     * 网络错误
     */
    public static final int NETWORD_ERROR = 1002;
    /**
     * 协议出错
     */
    public static final int HTTP_ERROR = 1003;

}