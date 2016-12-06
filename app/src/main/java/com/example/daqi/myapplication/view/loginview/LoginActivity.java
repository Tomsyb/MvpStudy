package com.example.daqi.myapplication.view.loginview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.daqi.myapplication.R;
import com.example.daqi.myapplication.model.bean.User;
import com.example.daqi.myapplication.presenter.loginpresenter.LoginPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends ActionBarActivity implements ILoginView {


    @Bind(R.id.login_user_name)
    EditText loginUserName;
    @Bind(R.id.login_user_password)
    EditText loginUserPassword;
    @Bind(R.id.login_btn_login)
    Button loginBtnLogin;
    @Bind(R.id.login_btn_clear)
    Button loginBtnClear;
    @Bind(R.id.login_pbar)
    ProgressBar loginPbar;
    private LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public String getUserName() {
        return loginUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return loginUserPassword.getText().toString();
    }

    @Override
    public void showLoading() {
        loginPbar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        loginPbar.setVisibility(View.GONE);

    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, "登录成功跳转至主页面", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFaileError() {
        Toast.makeText(this, "登录失败跳转至主页面", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void clearUserName() {
        loginUserName.setText("");

    }

    @Override
    public void clearPassword() {
        loginUserPassword.setText("");

    }


    @OnClick({R.id.login_btn_login, R.id.login_btn_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn_login:
                loginPresenter.login();
                break;
            case R.id.login_btn_clear:
                loginPresenter.clear();
                break;
        }
    }
}
