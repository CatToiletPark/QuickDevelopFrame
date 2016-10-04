package com.example.lyh.quickdevelopframe;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.easygo.framework.view.activity.easydrawer.EasyMenu;
import com.easygo.framework.view.activity.easytab.EasyGoTabActivity;
import com.easygo.framework.view.activity.easytab.EasyGoTabDrawerAct;

import java.util.ArrayList;
import java.util.List;

/**
 * description :
 *
 * @author by lyh on 2016/10/3 22:44.
 */

public class TestTabFragmentAct extends EasyGoTabDrawerAct {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(0);
    }

    @Override
    public List<EasyMenu> getMenuContent() {
        return initMenu();
    }

    @Override
    public List<String> setTab() {
        return getTitleList();
    }

    @Override
    public List<Fragment> setFragments() {
        return getFragmentList();
    }

    private List<String> getTitleList() {
        ArrayList<String> titleList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            titleList.add("Title" + i);
        }
        return titleList;
    }

    private List<Fragment> getFragmentList() {
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragmentList.add(new TestFragment());
        }
        return fragmentList;
    }

    private List<EasyMenu> initMenu() {
        List<EasyMenu> menuList = new ArrayList<>();
        EasyMenu menu = new EasyMenu("test", "", null);
        menuList.add(menu);
        return menuList;
    }

}
