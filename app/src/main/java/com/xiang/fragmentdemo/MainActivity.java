package com.xiang.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.xiang.fragmentdemo.Fragment.FriendFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFriend;
    private ContentFragment mWeixin;
    private FriendFragment mFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_bottom_weixin);
        mTabFriend = (LinearLayout) findViewById(R.id.id_tab_bottom_friend);
        mTabWeixin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        //设置默认的fragment
        setDefaultFragment();
    }

    /**
    * 设置默认的Fragment
    */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mWeixin = new ContentFragment();
        transaction.replace(R.id.id_content,mWeixin);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentManager fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.id_tab_bottom_weixin:
                if (mWeixin == null) {
                    mWeixin = new ContentFragment();
                }
                //使用当前Fragment的布局替换id_content的控件
                transaction.replace(R.id.id_content,mWeixin);
                break;
            case R.id.btn_tab_bottom_friend:
                if (mFriend == null) {
                    mFriend = new FriendFragment();
                }
                //使用当前Fragment的布局替换id_content的控件
                transaction.replace(R.id.id_content,mFriend);
                break;
        }
        //提交事务
        transaction.commit();
    }
}
