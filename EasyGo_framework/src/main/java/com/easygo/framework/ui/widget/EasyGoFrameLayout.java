package com.easygo.framework.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * description :
 *
 * @author by lyh on 2016/10/1 13:20.
 */

public class EasyGoFrameLayout extends FrameLayout {
    public EasyGoFrameLayout(Context context) {
        this(context, null);
    }

    public EasyGoFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EasyGoFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
