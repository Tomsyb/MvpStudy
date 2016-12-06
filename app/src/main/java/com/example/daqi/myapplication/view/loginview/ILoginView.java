package com.example.daqi.myapplication.view.loginview;

import com.example.daqi.myapplication.model.bean.User;

/**
 * Created by yanbo on 2016/12/3.
 * Presenter与View交互是通过接口
 * 思考顺序：
 *  该操作需要什么？（getUserName, getPassword）
 *  该操作的结果，对应的反馈？(toMainActivity, showFailedError)
 *  该操作过程中对应的友好的交互？(showLoading, hideLoading)
 *
 */
public interface ILoginView {
    //有两个按钮--》登录需要密码用户名
    String getUserName();
    String getPassword();
    //login耗时操作，友好提示ProgressBar
    void showLoading();
    void hideLoading();
    //登录成功失败处理，成功跳转到Activity,失败就提醒
    void toMainActivity(User user);
    void showFaileError();
    //清除
    void clearUserName();
    void clearPassword();


}
