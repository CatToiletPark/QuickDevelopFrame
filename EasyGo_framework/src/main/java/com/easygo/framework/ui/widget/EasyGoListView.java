package com.easygo.framework.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * description :
 *
 * @author by lyh on 2016/10/1 13:43.
 */

public class EasyGoListView extends ListView {
    public EasyGoListView(Context context) {
        this(context, null);
    }

    public EasyGoListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EasyGoListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
