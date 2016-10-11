package com.easygo.framework.view.activity.easybase;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author by lyh on 2016/10/1 10:22.
 * description: activity 基类
 */

public class EasyBaseActivity extends AppCompatActivity {

    public static final String TRANSITION_TEXT_VIEW = "TRANSITION_TEXT_VIEW";

    /**
     * 跳转activity并携带view平移动画
     * 目标activity要调用ViewCompat.setTransitionName(View sharedElement, String sharedElementName);
     * 才能产生平移动画
     *
     * @param clazz 目标activity
     * @param pairs The names of the shared elements to transfer to the called
     *              Activity and their associated Views.
     *              The Views must each have a unique shared element name.
     */
    @SuppressWarnings("unchecked")
    protected void startActivityWithTransition(Class<Activity> clazz, Pair<View, String>... pairs) {
        Intent intent = new Intent(this, clazz);
        ActivityOptionsCompat optionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
    }

}
