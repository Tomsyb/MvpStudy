package com.example.daqi.myapplication.presenter.loginpresenter;

import android.os.Handler;

import com.example.daqi.myapplication.model.bean.User;
import com.example.daqi.myapplication.model.biz.loginbiz.ILognBiz;
import com.example.daqi.myapplication.model.biz.loginbiz.LoginBiz;
import com.example.daqi.myapplication.model.biz.loginbiz.OnLoginListener;
import com.example.daqi.myapplication.view.loginview.ILoginView;



/**
 * Created by yanbo on 2016/12/3.
 * Presenter是用作Model和View之间交互的桥梁
 * 一切逻辑都在这里做
 */
public class LoginPresenter {
    private ILognBiz lognBiz;
    private ILoginView loginView;
    private Handler mHandler = new Handler();

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.lognBiz = new LoginBiz();
    }

    public void login(){
        loginView.showLoading();
        lognBiz.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程中执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActivity(user);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                //需要在UI线程中执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFaileError();
                        loginView.hideLoading();
                    }
                });

            }
        });
    }
    public void clear(){
        loginView.clearUserName();
        loginView.clearPassword();
    }
}
