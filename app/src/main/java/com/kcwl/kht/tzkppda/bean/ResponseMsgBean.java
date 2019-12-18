/**
 * FileName: ResponseMsgBean
 * Author:baijie
 * Date: 2019/11/24 15:09
 * Description: 只有响应信息的实体，例如确认这类接口
 */
package com.kcwl.kht.tzkppda.bean;

/**
 * @ClassName: ResponseMsgBean
 * @Description: 只有响应信息的实体，例如确认这类接口
 * @Author: baijie
 * @Date: 2019/11/24 15:09
 */
public class ResponseMsgBean extends BaseBean
{

    /**
     * success : true
     * msg : 请求成功
     * body : {}
     */

    /**
     * 是否成功的标志
     */
    private boolean success;
    /**
     * 错误描述信息
     */
    private String msg;
    private BodyBean body;

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }


    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public BodyBean getBody()
    {
        return body;
    }

    public void setBody(BodyBean body)
    {
        this.body = body;
    }

    public static class BodyBean
    {
    }
}