package com.easygo.framework.view.activity.easytab.adpter;

import android.app.Fragment;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;

/**
 * description : tabFragment adapter
 *
 * @author by lyh on 2016/10/3 21:36.
 */

public class EasyGoTabFragmentAdapter extends FragmentPagerAdapter {
    //tab的标题
    private List<String> title;
    //viewpager的内容
    private List<Fragment> fragments;

    public EasyGoTabFragmentAdapter(android.app.FragmentManager fm,
                                    List<String> title, List<Fragment> fragments) {
        super(fm);
        this.title = title;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return null == fragments ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (null == title) throw new IllegalArgumentException("title need initialization");
        return title.get(position);
    }
}
