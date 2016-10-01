package com.easygo.framework.ui.widget;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;

/**
 * @author by lyh on 2016/10/1 13:15.
 *         description： 抽屉布局
 */

public class EasyGoDrawerLayout extends DrawerLayout {

    public EasyGoDrawerLayout(Context context) {
        super(context, null);
    }

    public EasyGoDrawerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EasyGoDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
