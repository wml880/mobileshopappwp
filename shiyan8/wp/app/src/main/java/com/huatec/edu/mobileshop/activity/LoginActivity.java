package com.huatec.edu.mobileshop.activity;

import android.text.TextUtils;
import android.widget.EditText;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.common.BaseActivity;
import com.huatec.edu.mobileshop.http.ProgressDialogSubscriber;
import com.huatec.edu.mobileshop.http.entity.MemberEntity;
import com.huatec.edu.mobileshop.http.presenter.MemberPresenter;
import com.huatec.edu.mobileshop.utils.SystemCofig;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity{
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_pwd)
    EditText etPwd;

    @Override
    public int getContentViewId() { return R.layout.activity_login;}

    @OnClick(R.id.iv_back)
    void close(){ finish(); }

    @OnClick(R.id.bt_login)
    void login(){
        String userName = etUsername.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        if (TextUtils.isEmpty(userName)){
            toastshort("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            toastshort("请输入密码");
            return;
        }
        MemberPresenter.login2(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {

                SystemCofig.setLogin(true);

                toastshort("登录成功");

                SystemCofig.setLoginUserName(memberEntity.uname);
                SystemCofig.setLoginUserEmail(memberEntity.email);
                SystemCofig.setLoginUserHead(memberEntity.image);

                setResult(RESULT_OK);
                finish();
            }
        },userName,pwd);

    }
}




    /*private void initView(){
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.bt_login).setOnClickListener(this);

        et_username=findViewById(R.id.et_username);
        et_pwd  = findViewById(R.id.et_pwd);
        String user_name=getIntent().getStringExtra("user_name");
        Log.d(TAG,"user_name = "+user_name);
        et_username.setText(user_name);
    }


    public void onClick(View v){
        switch(v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_login:
                String user_name=et_username.getText().toString();
                String pwd = et_pwd.getText().toString();

                if(TextUtils.isEmpty(user_name)){
                    Toast.makeText(LoginActivity.this,"用户名不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(pwd)){
                    Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_LONG).show();
                    return;
                }

                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("账号"+user_name+"密码"+pwd)
                        .show();
                break;
        }
    }
}
*/