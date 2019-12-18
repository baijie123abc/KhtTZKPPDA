package com.kcwl.kht.tzkppda.base;

public interface BaseView
{
    /**
     * 数据请求成功后，显示数据
     */
    void showSuccessData(String reqType, Object object);

    /**
     * 当数据请求失败后，调用此接口提示
     */
    void showFailMsg(String reqType, String msg);

    /**
     * 数据请求异常，回调此方法。
     */
    void showErrorMsg(String reqType, String msg);

    /**
     * 显示toast
     */
    void showToast(String reqType, String msg);
}
