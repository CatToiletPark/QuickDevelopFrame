package com.example.lyh.quickdevelopframe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.easygo.framework.ui.widget.recylcerview.EasyGoRecyclerView;
import com.easygo.framework.view.activity.easybase.EasyBaseActivity;

import java.util.ArrayList;

/**
 * Created by lynn on 2016/10/13.
 */

public class TestBottomActivity extends EasyBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        EasyGoRecyclerView recyclerView = (EasyGoRecyclerView) findViewById(R.id.recycler_view);
        CustomAdapter adapter = new CustomAdapter(this, getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("TEXT" + i);
        }
        return data;
    }

}
