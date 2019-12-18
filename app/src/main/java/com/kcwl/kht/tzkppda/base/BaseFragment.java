/**
 * FileName: BaseFragment
 * Author:baijie
 * Date: 2019/11/13 16:12
 * Description: BaseFragment
 */
package com.kcwl.kht.tzkppda.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kcwl.kht.tzkppda.utils.ToastUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ClassName: BaseFragment
 * @Description: BaseFragment
 * @Author: baijie
 * @Date: 2019/11/13 16:12
 */
public abstract class BaseFragment extends Fragment
{
    private Unbinder unBinder;
    private View mContentView;
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        mContentView = inflater.inflate(getLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, mContentView);
        mContext = getContext();
        initData();
        initView(mContentView);
        return mContentView;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        if (unBinder != null)
        {
            unBinder.unbind();
        }
    }


    protected abstract void initView(View view);

    protected abstract int getLayoutId();

    protected abstract void initData();

    public void showShortToast(int msg)
    {
        if (this.isAdded())
        {
            ToastUtil.showShortToast(mContext, msg);
        }
    }

    public void showShortToast(String msg)
    {
        if (this.isAdded())
        {
            ToastUtil.showShortToast(mContext, msg);
        }
    }

    public void showLongToast(String msg)
    {
        if (this.isAdded())
        {
            ToastUtil.showLongToast(mContext, msg);
        }
    }

    public void showLongToast(int msg)
    {
        if (this.isAdded())
        {
            ToastUtil.showLongToast(mContext, msg);
        }
    }
}