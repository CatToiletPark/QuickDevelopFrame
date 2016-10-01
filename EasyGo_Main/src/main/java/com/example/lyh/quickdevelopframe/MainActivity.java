package com.example.lyh.quickdevelopframe;

import android.os.Bundle;
import android.widget.TextView;

import com.easygo.framework.view.activity.base.EasyBaseActivity;

import butterknife.BindView;

public class MainActivity extends EasyBaseActivity {

    @BindView(R.id.inform)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView.setText("hello ha");
    }
}
