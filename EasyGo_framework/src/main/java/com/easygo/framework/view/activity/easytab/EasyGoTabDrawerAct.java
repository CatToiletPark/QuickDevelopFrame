package com.easygo.framework.view.activity.easytab;

import android.app.Fragment;
import android.support.annotation.LayoutRes;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.easygo.framework.ui.widget.EasyGoTabLayout;
import com.easygo.framework.ui.widget.EasyGoViewPager;
import com.easygo.framework.utils.EasyGoCommonUtils;
import com.easygo.framework.view.activity.easydrawer.EasyDrawerActivity;
import com.easygo.framework.view.activity.easytab.adpter.EasyGoTabFragmentAdapter;
import com.example.framework.R;

import java.util.List;

/**
 * description : 带抽屉和tab的界面
 *
 * @author by lyh on 2016/10/4 09:54.
 *         tips:setContentView(@LayoutRes int layoutResID) layoutResID = 0 则为默认布局
 */

public abstract class EasyGoTabDrawerAct extends EasyDrawerActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //解决viewpager 和 menu 滑动冲突
                if (position == 0) {
                    menuDrawer.setCanSlide(true);
                } else {
                    menuDrawer.setCanSlide(false);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private EasyGoTabFragmentAdapter setupAdapter(List<String> title, List<Fragment> fragments) {
        return new EasyGoTabFragmentAdapter(getFragmentManager(), title, fragments);
    }

    //设置自定义tab
    public abstract List<String> setTab();

    //设置viewpager内容
    public abstract List<Fragment> setFragments();

}
