package com.easygo.framework.view.activity.EasyDrawer;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * description : 抽屉专用listAdapter
 *
 * @author by lyh on 2016/10/1 14:11.
 */

class EasyDrawerMenuAdapter extends ArrayAdapter<EasyMenu> {

    public EasyDrawerMenuAdapter(Context context, int resource) {
        super(context, resource);
    }
}
