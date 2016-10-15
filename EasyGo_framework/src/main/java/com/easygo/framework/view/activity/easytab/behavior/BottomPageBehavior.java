package com.easygo.framework.view.activity.easytab.behavior;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

/**
 * Created by lynn on 2016/10/13.
 */

public class BottomPageBehavior extends CoordinatorLayout.Behavior<View> {

    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();

    private int sinceDirectionChange;


    public BottomPageBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll
            (CoordinatorLayout coordinatorLayout,
             View child,
             View directTargetChild,
             View target,
             int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedPreScroll
            (CoordinatorLayout coordinatorLayout,
             View child,
             View target,
             int dx,
             int dy,
             int[] consumed) {
        if (dy > 0 && sinceDirectionChange < 0 || dy < 0 && sinceDirectionChange > 0) {
            child.animate().cancel();
            sinceDirectionChange = 0;
        }
        sinceDirectionChange += dy;
        if (sinceDirectionChange > child.getHeight() && child.getVisibility() == View.VISIBLE) {
            hideTools(child);
        } else if (sinceDirectionChange < 0 && child.getVisibility() == View.GONE) {
            showTools(child);
        }
//        if (sinceDirectionChange > child.getHeight() && child.getVisibility() == View.VISIBLE) {
//            hide(child);
//        }
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);
        //show(child);
    }

    private void showTools(View view) {

        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotation", 0f, 180f);
        anim.setDuration(200);
        anim.start();

        //   isToolsHide = false;
    }

    private void hideTools(View view) {

        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "rotation", 180f, 0f);
        anim.setDuration(200);
        anim.start();

        //isToolsHide = true;

    }

}
