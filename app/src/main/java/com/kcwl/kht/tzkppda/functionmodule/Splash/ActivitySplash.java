/**
 * FileName: ActivitySplash
 * Author:baijie
 * Date: 2019/11/26 9:28
 * Description: ActivitySplash
 */
package com.kcwl.kht.tzkppda.functionmodule.Splash;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BarUtils;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.functionmodule.Login.ActivityLogin;
import com.kcwl.kht.tzkppda.utils.UmengUtil;

/**
 * @ClassName: ActivitySplash
 * @Description: ActivitySplash
 * @Author: baijie
 * @Date: 2019/11/26 9:28
 */
public class ActivitySplash extends AppCompatActivity
{
    private final Handler mHideHandler = new Handler();

    @Override
    protected void onResume()
    {
        super.onResume();
        UmengUtil.umengonResume(this);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        UmengUtil.umengonPause(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //不显示标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏ActionBar
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        // 设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        BarUtils.setNotificationBarVisibility(false);
        BarUtils.setStatusBarVisibility(this, false);
        BarUtils.setNavBarVisibility(this, false);
        setContentView(R.layout.activity_splash);
        mHideHandler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                ActivityUtils.startActivity(ActivityLogin.class);
                finish();
            }
        }, 1500);
    }

}