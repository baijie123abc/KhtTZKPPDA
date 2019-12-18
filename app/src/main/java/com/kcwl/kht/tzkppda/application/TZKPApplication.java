/**
 * FileName: TZKPApplication
 * Author:baijie
 * Date: 2019/11/26 9:04
 * Description: Application
 */
package com.kcwl.kht.tzkppda.application;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;

import com.blankj.utilcode.util.Utils;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.uhf.UM7UHFUtil;
import com.kcwl.kht.tzkppda.utils.DynamicTimeFormat;
import com.kcwl.kht.tzkppda.utils.UmengUtil;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshInitializer;

/**
 * @ClassName: TZKPApplication
 * @Description: Application
 * @Author: baijie
 * @Date: 2019/11/26 9:04
 */
public class TZKPApplication extends Application
{
    /**
     * 新版本扫码枪工具类
     */
    private static UM7UHFUtil um7UHFUtil;

    static
    {
        //启用矢量图兼容
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        //设置全局默认配置（优先级最低，会被其他设置覆盖）
        SmartRefreshLayout.setDefaultRefreshInitializer(new DefaultRefreshInitializer()
        {
            @Override
            public void initialize(@NonNull Context context, @NonNull RefreshLayout layout)
            {
                //全局设置（优先级最低）
                layout.setEnableAutoLoadMore(true);
                layout.setEnableOverScrollDrag(false);
                layout.setEnableOverScrollBounce(true);
                layout.setEnableLoadMoreWhenContentNotFull(true);
                layout.setEnableScrollContentWhenRefreshed(true);
                layout.setPrimaryColorsId(R.color.Theme_Color, android.R.color.white);
            }
        });
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator()
        {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout)
            {
                //全局设置主题颜色（优先级第二低，可以覆盖 DefaultRefreshInitializer 的配置，与下面的ClassicsHeader绑定）
                layout.setEnableHeaderTranslationContent(true);
                return new ClassicsHeader(context).setTimeFormat(new DynamicTimeFormat("更新于 %s"));
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator()
        {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout)
            {
                return new ClassicsFooter(context);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context base)
    {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        Utils.init(this);
        UmengUtil.init(this);
        um7UHFUtil = new UM7UHFUtil(this);
    }

    public static UM7UHFUtil getUm7UHFUtil()
    {
        return um7UHFUtil;
    }
}