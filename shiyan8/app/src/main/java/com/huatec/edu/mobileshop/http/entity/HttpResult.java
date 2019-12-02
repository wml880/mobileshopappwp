package com.huatec.edu.mobileshop.http.entity;

import java.io.Serializable;

/**
 * Created by ASUS on 2019/11/22.
 */

public class HttpResult<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "data=" + data +
                ", status=" + status +
                ",msg='" + msg + '\'' +
                '}';
    }
    /*    private void httpRequest(final String username, final String password) {
        MemberPresenter.login2(new Subscriber<MemberEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("error", "e:" + e.getMessage().toString());
            }

            @Override
            public void onNext(MemberEntity memberEntity) {
            }
        }, username, password);
    }*/
   /* private void httpRequest(final String username,final String password){
        MemberPresenter.login2(new ProgressDialogSubscriber<MemberEntity>(this){
            @Override
            public void onNext(MemberEntity memberEntity){
                tv_result.setText(
                        String.format("用户名：%s\n邮箱：%s"
                        ,memberEntity.uname
                        ,memberEntity.email));
            }
        },username,password);

    }*/
}
