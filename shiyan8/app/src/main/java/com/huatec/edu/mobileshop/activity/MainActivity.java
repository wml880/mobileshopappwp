package com.huatec.edu.mobileshop.activity;


import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.common.BaseActivity;
import com.huatec.edu.mobileshop.fragment.NavingationFragment;
import com.huatec.edu.mobileshop.http.ProgressDialogSubscriber;
import com.huatec.edu.mobileshop.http.entity.MemberEntity;
import com.huatec.edu.mobileshop.http.presenter.MemberPresenter;

import rx.Subscriber;

public class MainActivity extends BaseActivity {
    @Override
    public @LayoutRes
    int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        FragmentManager manager= getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        transaction.replace(R.id.fl_main,new NavingationFragment());
        transaction.commit();
    }
 /*   FragmentManager manager=getSupportFragmentManager();
    NavingationFragment navingationFragment=(NavingationFragment)manager.findFragmentById(R.id fragment_main_navigation);
*/

}
