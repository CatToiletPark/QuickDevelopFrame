package com.easygo.framework.view.activity.easydrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.easygo.framework.ui.widget.EasyGoTextView;
import com.easygo.framework.utils.EasyGoViewHolderHelper;
import com.example.framework.R;

/**
 * description : 抽屉专用listAdapter
 *
 * @author by lyh on 2016/10/1 14:11.
 */

class EasyDrawerMenuAdapter extends ArrayAdapter<EasyMenu> {

    private Context context;

    public EasyDrawerMenuAdapter(Context context) {
        super(context, R.layout.easy_drawer_menu_item);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = LayoutInflater.from(context).inflate(R.layout.easy_drawer_menu_item, null);
        }

        EasyMenu menu = getItem(position);
        EasyGoTextView title = EasyGoViewHolderHelper.getView(convertView, R.id.menu_title);
        title.setText(menu.getEasyMenuTitle());
        return convertView;
    }
}
