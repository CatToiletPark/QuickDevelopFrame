package com.example.lyh.quickdevelopframe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.easygo.framework.view.activity.easybase.EasyBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends EasyBaseActivity {

    @BindView(R.id.inform)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView.setText("hello ha");
    }

    @OnClick(R.id.test)
    public void toTest() {
        Intent intent = new Intent(MainActivity.this, TestActivity.class);
        startActivity(intent);
    }

}
