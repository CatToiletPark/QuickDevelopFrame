package com.easygo.framework.utils;

import android.support.annotation.IdRes;
import android.view.View;

/**
 * description :
 *
 * @author by lyh on 2016/10/1 22:09.
 */

public class EasyGoCommonUtils {

    public static <T extends View> T $(View view, @IdRes int resId) {
        return (T) view.findViewById(resId);
    }

}
