package com.easygo.framework.view.activity.easydrawer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.easygo.framework.ui.widget.EasyGoSlidingPaneLayout;
import com.easygo.framework.ui.widget.EasyGoFrameLayout;
import com.easygo.framework.ui.widget.EasyGoListView;
import com.easygo.framework.utils.EasyGoCommonUtils;
import com.easygo.framework.view.activity.easybase.EasyBaseActivity;
import com.example.framework.R;

import java.util.List;


/**
 * @author by lyh on 2016/10/1 13:04.
 *         description: 带抽屉的activity
 */

public abstract class EasyDrawerActivity extends EasyBaseActivity {

    private EasyDrawerMenuAdapter menuAdapter;

    protected EasyGoSlidingPaneLayout menuDrawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(View.inflate(this, layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        setContentView(view, null);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        //生成根布局View
        View contentView = LayoutInflater.from(this).inflate(R.layout.easy_drawer_layout, null);
        //初始化menuList
        initializationMenuList(contentView);
        //内容
        final EasyGoFrameLayout contentContainer = EasyGoCommonUtils.$(contentView, R.id.common_drawer_content);
        params = params == null ? new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT) : params;
        contentContainer.addView(view, params);
        //抽屉 TODO
        menuDrawer = EasyGoCommonUtils.$(contentView, R.id.common_drawer);
        menuDrawer.setSliderFadeColor(Color.argb(127, Color.red(Color.BLACK), Color.green(Color.BLACK), Color.blue(Color.BLACK)));
        super.setContentView(contentView);
    }

    //初始化list
    private void initializationMenuList(View contentView) {
        EasyGoListView menuList = (EasyGoListView) contentView.findViewById(R.id.common_drawer_menu);
        List<EasyMenu> menu = getMenuContent();
        if (null == menu) throw new IllegalArgumentException("need import menu");
        initializationMenuAdapter();
        menuList.setAdapter(menuAdapter);
        menuAdapter.addAll(menu);
    }

    private void initializationMenuAdapter() {
        if (null == menuAdapter) {
            menuAdapter = new EasyDrawerMenuAdapter(this);
        } else {
            menuAdapter.notifyDataSetChanged();
        }
    }

    //自定义菜单
    public abstract List<EasyMenu> getMenuContent();
}
