/**
 * FileName: UHFConnectFailedDialogActivity
 * Author:baijie
 * Date: 2019/8/8 10:57
 * Description: 扫描枪连接失败的弹框
 */
package com.kcwl.kht.tzkppda.uhf;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ScreenUtils;
import com.kcwl.kht.tzkppda.R;

/**
 * @ClassName: UHFConnectFailedDialogActivity
 * @Description: 扫描枪连接失败的弹框
 * @Author: baijie
 * @Date: 2019/8/8 10:57
 */
public class UHFConnectFailedDialogActivity extends AppCompatActivity
{
    /**
     * 高度比
     */
    public static final double SMALL_WIN_H_SCALE = 0.7;
    /**
     * 宽度比
     */
    public static final double SMALL_WIN_W_SCALE = 0.8;

    @Override
    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        overridePendingTransition(R.anim.activity_dialog_close_enter, R.anim.activity_dialog_close_exit);
        resizeActivity();
    }

    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.activity_dialog_close_enter, R.anim.activity_dialog_close_exit);
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uhfdilog);
    }

    private void resizeActivity()
    {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        setFinishOnTouchOutside(false);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        layoutParams.copyFrom(getWindow().getAttributes());
        layoutParams.gravity = Gravity.CENTER;

        layoutParams.width = (int) (ScreenUtils.getScreenWidth() * SMALL_WIN_W_SCALE);
        layoutParams.height = (int) (ScreenUtils.getScreenHeight() * SMALL_WIN_H_SCALE);

        layoutParams.dimAmount = 0.7f;
        layoutParams.alpha = 1.0f;
        getWindow().setAttributes(layoutParams);

        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        View view = getWindow().getDecorView();
        view.setBackgroundResource(R.drawable.dialog_activity_bg);
    }
}