package com.easygo.framework.view.activity.EasyDrawer;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.easygo.framework.ui.widget.EasyGoListView;
import com.easygo.framework.view.activity.base.EasyBaseActivity;
import com.example.framework.R;

import java.util.List;

/**
 * @author by lyh on 2016/10/1 13:04.
 *         version 1.0
 * @description 带抽屉的activity
 */

public abstract class EasyDrawerActivity extends EasyBaseActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(R.layout.easy_drawer_layout);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_drawer_layout);
        initializationMenuList();
    }

    //初始化list
    private void initializationMenuList() {
        EasyGoListView menuList = (EasyGoListView) findViewById(R.id.common_drawer_menu);
        List<EasyMenu> menu = getMenuContent();
        if (null == menu) throw new IllegalArgumentException("need import menu");
    }

    //自定义菜单
    public abstract List<EasyMenu> getMenuContent();
}
