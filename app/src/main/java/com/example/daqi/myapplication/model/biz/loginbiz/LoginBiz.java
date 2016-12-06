package com.example.daqi.myapplication.model.biz.loginbiz;

import com.example.daqi.myapplication.model.bean.User;

/**
 * Created by yanbo on 2016/12/3.
 * 登录的业务实现类
 */
public class LoginBiz implements ILognBiz{
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线层耗时操作
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("yanbo".equals(username) && "123456".equals(password)){
                    User user = new User();
                    user.setUserName(username);
                    user.setPaseWord(password);
                    loginListener.loginSuccess(user);//回调通知状态
                }else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
