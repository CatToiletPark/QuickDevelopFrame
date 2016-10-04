package com.easygo.framework.view.activity.easytab;

import android.app.Fragment;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easygo.framework.ui.widget.EasyGoTabLayout;
import com.easygo.framework.ui.widget.EasyGoViewPager;
import com.easygo.framework.utils.EasyGoCommonUtils;
import com.easygo.framework.view.activity.easybase.EasyBaseActivity;
import com.easygo.framework.view.activity.easytab.adpter.EasyGoTabFragmentAdapter;
import com.example.framework.R;

import java.util.List;

/**
 * description : 带Tab + viewPager的activity
 *
 * @author by lyh on 2016/10/2 12:07.
 */

public abstract class EasyGoTabActivity extends EasyBaseActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        this.setContentView(View.inflate(this, layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        this.setContentView(view, null);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        View contentView = LayoutInflater.from(this).inflate(R.layout.easy_tab_layout, null);
        //tab
        EasyGoTabLayout tab = EasyGoCommonUtils.$(contentView, R.id.common_tab);
        //viewPager
        EasyGoViewPager viewPager = EasyGoCommonUtils.$(contentView, R.id.common_viewpager);
        tab.setupWithViewPager(viewPager, true);
        setupViewPager(viewPager);
        super.setContentView(contentView);
    }

    private void setupViewPager(EasyGoViewPager viewPager) {
        List<String> title = setTab();
        List<Fragment> fragments = setFragments();
        if (null == title || null == fragments) throw
                new IllegalArgumentException("title&fragment need initialized");
        viewPager.setAdapter(setupAdapter(title, fragments));
    }

    private EasyGoTabFragmentAdapter setupAdapter(List<String> title, List<Fragment> fragments) {
        return new EasyGoTabFragmentAdapter(getFragmentManager(), title, fragments);
    }

    //设置自定义tab
    public abstract List<String> setTab();

    //设置viewpager内容
    public abstract List<Fragment> setFragments();

}
