package com.example.lyh.quickdevelopframe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.easygo.framework.view.activity.easybase.EasyBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends EasyBaseActivity {

    @BindView(R.id.inform)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        textView.setText("hello ha");
    }

    @OnClick(R.id.test)
    public void toTest() {
        Intent intent = new Intent(MainActivity.this, TestActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_tab)
    public void toTab() {
        Intent intent = new Intent(MainActivity.this, TestTabFragmentAct.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_bottom)
    public void toBottom() {
        Intent intent = new Intent(MainActivity.this, TestBottomActivity.class);
        startActivity(intent);
    }

}
