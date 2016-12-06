package com.example.daqi.myapplication.model.biz.loginbiz;

/**
 * Created by yanbo on 2016/12/3.
 * d登录的业务类接口
 */
public interface ILognBiz {
    public void login(String username,String password,OnLoginListener loginListener);
}
