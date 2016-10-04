package com.easygo.framework.ui.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/**
 * description : 抽屉布局
 *
 * @author by lyh on 2016/10/2 11:17.
 */

public class EasyGoSlidingPaneLayout extends SlidingPaneLayout {
    private float mInitialMotionX;
    private float mEdgeSlop;

    public EasyGoSlidingPaneLayout(Context context) {
        this(context, null);
    }

    public EasyGoSlidingPaneLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EasyGoSlidingPaneLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        ViewConfiguration config = ViewConfiguration.get(context);
        mEdgeSlop = config.getScaledEdgeSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (MotionEventCompat.getActionMasked(ev)) {
            case MotionEvent.ACTION_DOWN:
                mInitialMotionX = ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                final float x = ev.getX();
                final float y = ev.getY();
                // The user should always be able to "close" the pane, so we only
                // check
                // for child scrollability if the pane is currently closed.
                if ((mInitialMotionX > mEdgeSlop && !isOpen()
                        && canScroll(this, false, Math.round(x - mInitialMotionX), Math.round(x), Math.round(y)))||!mCanSlide) {

                    // How do we set super.mIsUnableToDrag = true?

                    // send the parent a cancel event
                    MotionEvent cancelEvent = MotionEvent.obtain(ev);
                    cancelEvent.setAction(MotionEvent.ACTION_CANCEL);
                    return super.onInterceptTouchEvent(cancelEvent);
                }
        }
        return super.onInterceptTouchEvent(ev);
    }

    private boolean mCanSlide = false;

    public boolean isSlideable() {
        return mCanSlide;
    }

    public void setCanSlide(boolean mCanSlide) {
        this.mCanSlide = mCanSlide;
    }

}