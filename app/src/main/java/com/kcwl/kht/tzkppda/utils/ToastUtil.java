/**
 * FileName: ToastUtil
 * Author:baijie
 * Date: 2019/11/13 16:13
 * Description: 自定义的ToastUtil
 */
package com.kcwl.kht.tzkppda.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;

import com.blankj.utilcode.util.ToastUtils;
import com.kcwl.kht.tzkppda.R;

/**
 * @ClassName: ToastUtil
 * @Description: 自定义的ToastUtil
 * @Author: baijie
 * @Date: 2019/11/13 16:13
 */
public class ToastUtil
{
    public static void showShortToast(Context context, String msg)
    {
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.setBgColor(context.getResources().getColor(R.color.Toast_Color));
        ToastUtils.setMsgColor(Color.WHITE);
        ToastUtils.showShort(msg);
    }

    public static void showShortToast(Context context, int msg)
    {
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.setBgColor(context.getResources().getColor(R.color.Toast_Color));
        ToastUtils.setMsgColor(Color.WHITE);
        ToastUtils.showShort(msg);
    }

    public static void showLongToast(Context context, String msg)
    {
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.setBgColor(context.getResources().getColor(R.color.Toast_Color));
        ToastUtils.setMsgColor(Color.WHITE);
        ToastUtils.showShort(msg);
    }

    public static void showLongToast(Context context, int msg)
    {
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.setBgColor(context.getResources().getColor(R.color.Toast_Color));
        ToastUtils.setMsgColor(Color.WHITE);
        ToastUtils.showShort(msg);
    }
}