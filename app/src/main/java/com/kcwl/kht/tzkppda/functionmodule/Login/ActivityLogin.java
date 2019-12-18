/**
 * FileName: ActivityLogin
 * Author:baijie
 * Date: 2019/11/26 9:34
 * Description: 登录页面
 */
package com.kcwl.kht.tzkppda.functionmodule.Login;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.SPUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.base.BaseActivity;
import com.kcwl.kht.tzkppda.base.BaseView;
import com.kcwl.kht.tzkppda.bean.LoginBean;
import com.kcwl.kht.tzkppda.functionmodule.SelectBusiness.ActivitySelectBusiness;
import com.kcwl.kht.tzkppda.functionmodule.Setting.ActivitySetting;
import com.kcwl.kht.tzkppda.presenter.LoginPresenter;
import com.kcwl.kht.tzkppda.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ClassName: ActivityLogin
 * @Description: 登录页面
 * @Author: baijie
 * @Date: 2019/11/26 9:34
 */
public class ActivityLogin extends BaseActivity
{
    @BindView(R.id.activity_login_btn_login)
    Button btnLogin;
    @BindView(R.id.activity_login_password_btn_delete)
    Button btnPasswordDelete;
    @BindView(R.id.activity_login_password_btn_see)
    Button btnPasswordSee;
    @BindView(R.id.activity_login_account_btn_delete)
    Button btnAccountDelete;
    @BindView(R.id.activity_login_actv_account)
    AutoCompleteTextView actvAccount;
    @BindView(R.id.activity_login_password_tl_et_password)
    EditText etPassword;
    private LoginPresenter loginPresenter;
    /**
     * 密码查看标识
     */
    private boolean isShowPwd = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ImmersionBar.with(this).navigationBarColor(R.color.black).barColor(R.color.black).init();
        setViewShowHistoryData();
    }

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_login;
    }

    @Override
    protected void initView()
    {
        setPageTitle(Constant.PAGE_TITLE_LOGIN);
        setPageRightTitle(Constant.PAGE_TITLE_SETTING);
    }

    private void setViewShowHistoryData()
    {
        etPassword.setOnEditorActionListener(onEditorActionListener);
        //显示上一次登录的账号
        actvAccount.setText(SPUtils.getInstance().getString(Constant.KEY_LOGINNAME, ""));
        //显示上一次登录的密码
        etPassword.setText(SPUtils.getInstance().getString(Constant.KEY_PASSWORD, ""));
        //每次都要求登录，所以未登录前状态都为未登录
        Constant.isLogin = false;
        SPUtils.getInstance().put(Constant.KEY_USERID, "");
        SPUtils.getInstance().put(Constant.KEY_USERNAME, "");
    }

    /**
     * 输入法监听，点击输入法的完成按钮时请求接口
     */
    private TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener()
    {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
        {
            if (actionId == EditorInfo.IME_ACTION_DONE)
            {
                //隐藏软键盘
                KeyboardUtils.hideSoftInput(ActivityLogin.this);
                // 按下软键盘的完成按钮时请求接口
                dealLogin();
                return true;
            }
            return false;
        }
    };

    @Override
    protected void initData()
    {
        loginPresenter = new LoginPresenter();
        loginPresenter.attached(baseView);
    }


    @OnClick({R.id.activity_login_btn_login, R.id.activity_login_password_btn_delete,
            R.id.activity_login_password_btn_see, R.id.activity_login_account_btn_delete})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.activity_login_btn_login:
                //登录按钮
                dealLogin();
                break;
            case R.id.activity_login_password_btn_delete:
                //密码删除按钮
                dealPasswordDelete();
                break;
            case R.id.activity_login_password_btn_see:
                //密码查看按钮
                dealPasswordSee();
                break;
            case R.id.activity_login_account_btn_delete:
                //账号删除按钮
                dealAccountDelete();
                break;
        }
    }

    /**
     * 处理密码显示与隐藏，
     */
    private void dealPasswordSee()
    {
        if (isShowPwd)
        {//隐藏密码
            etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            isShowPwd = false;
        } else
        {//显示密码
            etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            isShowPwd = true;
        }
    }

    /**
     * 删除密码
     */
    private void dealPasswordDelete()
    {
        etPassword.setText("");
    }

    /**
     * 删除账号
     */
    private void dealAccountDelete()
    {
        actvAccount.setText("");
    }

    /**
     * 请求登录
     */
    private void dealLogin()
    {
        String account = actvAccount.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(account))
        {
            showShortToast(Constant.ACCOUNT_NOTEMPTY);
            return;
        }

        if (TextUtils.isEmpty(password))
        {
            showShortToast(Constant.PASSWORD_NOTEMPTY);
            return;
        }

        if (password.length() < 6)
        {
            showShortToast(Constant.PASSWORD_LENGTH_NOTENOUGHLONG);
            return;
        }

        //将登录账号存到SP用于下次显示
        SPUtils.getInstance().put(Constant.KEY_LOGINNAME, account);

        reqLogin(account, password);
    }

    /**
     * 请求接口
     *
     * @param account  账号
     * @param password 密码
     */
    private void reqLogin(String account, String password)
    {
        SPUtils.getInstance().put(Constant.KEY_PASSWORD, password);
        loginPresenter.login(ActivityLogin.this, account, password);
    }


    private BaseView baseView = new BaseView()
    {
        @Override
        public void showSuccessData(String reqType, Object object)
        {
            if (reqType.equals(loginPresenter.TAG))
            {
                LoginBean loginBean = (LoginBean) object;
                SPUtils.getInstance().put(Constant.KEY_LOGINNAME, loginBean.getBody().getData().getLoginName());
                SPUtils.getInstance().put(Constant.KEY_USERNAME, loginBean.getBody().getData().getName());
                SPUtils.getInstance().put(Constant.KEY_USERID, loginBean.getBody().getData().getUserId());
                showShortToast(loginBean.getMsg());
                ActivityUtils.startActivity(ActivitySelectBusiness.class);
            }
        }

        @Override
        public void showFailMsg(String reqType, String msg)
        {
            if (reqType.equals(loginPresenter.TAG))
            {
                showShortToast(msg);
            }
        }

        @Override
        public void showErrorMsg(String reqType, String msg)
        {
            if (reqType.equals(loginPresenter.TAG))
            {
                showShortToast(msg);
            }
        }

        @Override
        public void showToast(String reqType, String msg)
        {
            if (reqType.equals(loginPresenter.TAG))
            {
                showShortToast(msg);
            }
        }
    };

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (loginPresenter != null)
        {
            loginPresenter.detachView();
        }
    }

    @Override
    public void clickRightTitle()
    {
        super.clickRightTitle();
        ActivityUtils.startActivity(ActivitySetting.class);
    }
}