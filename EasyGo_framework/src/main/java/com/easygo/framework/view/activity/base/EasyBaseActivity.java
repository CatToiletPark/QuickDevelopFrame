package com.easygo.framework.view.activity.base;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.ButterKnife;

/**
 * @author by lyh on 2016/10/1 10:22.
 * @description activity 基类
 */

public class EasyBaseActivity extends AppCompatActivity {


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(View.inflate(this, layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        setContentView(view, null);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        params =
                params == null ? new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT) : params;

        super.setContentView(view, params);
        ButterKnife.bind(this);
    }
}
