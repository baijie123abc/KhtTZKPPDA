/**
 * FileName: BasePresenter
 * Author:baijie
 * Date: 2019/11/13 15:58
 * Description: BasePresenter
 */
package com.kcwl.kht.tzkppda.base;

import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.kcwl.kht.tzkppda.utils.Constant;

/**
 * @ClassName: BasePresenter
 * @Description: BasePresenter
 * @Author: baijie
 * @Date: 2019/11/13 15:58
 */
public class BasePresenter<V extends BaseView>
{
    /**
     * view
     */
    private V mView;

    /**
     * 绑定view
     */
    public void attached(V v)
    {
        mView = v;
    }

    /***
     * 断开绑定的View
     * */
    public void detachView()
    {
        this.mView = null;
    }

    /**
     * 是否绑定
     */
    public boolean isViewAttached()
    {
        return mView != null;
    }

    /**
     * 获取正在连接的View
     */
    public V getView()
    {
        return mView;
    }

    /**
     * 判断请求网地址是否存在
     *
     * @return
     */
    public boolean isNetUrlEmpty()
    {
        return TextUtils.isEmpty(SPUtils.getInstance().getString(Constant.KEY_IP));
    }
}