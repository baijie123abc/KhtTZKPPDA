/**
 * FileName: BaseActivity
 * Author:baijie
 * Date: 2019/11/13 16:06
 * Description: BaseActivity
 */
package com.kcwl.kht.tzkppda.base;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.blankj.utilcode.util.StringUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.utils.ToastUtil;
import com.kcwl.kht.tzkppda.utils.UmengUtil;

/**
 * @ClassName: BaseActivity
 * @Description: BaseActivity
 * @Author: baijie
 * @Date: 2019/11/13 16:06
 */
public abstract class BaseActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //不显示标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏ActionBar
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.Theme_Color).init();
        setContentView(this.getLayoutId());
        initView();
        initData();
    }


    /**
     * 设置布局
     *
     * @return
     */
    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();


    /**
     * 设置页面标题
     *
     * @param title 标题
     */
    public void setPageTitle(String title)
    {
        if (StringUtils.isEmpty(title))
        {
            return;
        }
        TextView tvCenterTitle = findViewById(R.id.layout_common_title_tv_centertitle);
        tvCenterTitle.setText(title);
    }

    /**
     * 设置页面右侧标题
     *
     * @param title 标题
     */
    public void setPageRightTitle(String title)
    {
        TextView tvRightTitle = findViewById(R.id.layout_common_title_tv_righttitle);
        tvRightTitle.setVisibility(View.VISIBLE);
        tvRightTitle.setText(title);
        tvRightTitle.setOnClickListener(onClickListener);
    }

    /**
     * 设置返回按钮是否显示
     *
     * @param visible 是否显示标识
     */
    public void setPageBackVisible(boolean visible)
    {
        if (visible)
        {
            ConstraintLayout clBack = findViewById(R.id.layout_common_title_cl_back);
            clBack.setVisibility(View.VISIBLE);
            clBack.setOnClickListener(onClickListener);
        }
    }


    private View.OnClickListener onClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.layout_common_title_cl_back:
                    finish();
                    break;

                case R.id.layout_common_title_tv_righttitle:
                    clickRightTitle();
                    break;
            }
        }
    };

    public void clickRightTitle()
    {

    }

    public void showShortToast(int msg)
    {
        ToastUtil.showShortToast(this, msg);
    }

    public void showShortToast(String msg)
    {
        ToastUtil.showShortToast(this, msg);
    }

    public void showLongToast(String msg)
    {
        ToastUtil.showLongToast(this, msg);
    }

    public void showLongToast(int msg)
    {
        ToastUtil.showLongToast(this, msg);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        UmengUtil.umengonPause(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        UmengUtil.umengonResume(this);
    }

}