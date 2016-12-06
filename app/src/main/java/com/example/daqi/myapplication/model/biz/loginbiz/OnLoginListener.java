package com.example.daqi.myapplication.model.biz.loginbiz;

import com.example.daqi.myapplication.model.bean.User;

/**
 * Created by yanbo on 2016/12/3.
 * 登录的接口
 */
public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();

}
