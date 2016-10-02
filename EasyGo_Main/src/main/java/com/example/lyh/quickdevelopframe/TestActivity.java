package com.example.lyh.quickdevelopframe;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.easygo.framework.view.activity.easydrawer.EasyDrawerActivity;
import com.easygo.framework.view.activity.easydrawer.EasyMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * description :
 *
 * @author by lyh on 2016/10/1 21:38.
 */

public class TestActivity extends EasyDrawerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    public List<EasyMenu> getMenuContent() {
        return initMenu();
    }

    private List<EasyMenu> initMenu() {
        List<EasyMenu> menuList = new ArrayList<>();
        EasyMenu menu = new EasyMenu("test", "", null);
        menuList.add(menu);
        return menuList;
    }

}
