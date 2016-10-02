package com.easygo.framework.utils;

import android.support.annotation.IdRes;
import android.util.SparseArray;
import android.view.View;

/**
 * description : viewHolder 帮助类
 *
 * @author by lyh on 2016/10/1 21:54.
 */

public class EasyGoViewHolderHelper {

    public static <T extends View> T getView(View view, @IdRes int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }

}
