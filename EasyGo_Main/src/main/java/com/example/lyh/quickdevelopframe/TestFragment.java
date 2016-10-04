package com.example.lyh.quickdevelopframe;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * description :
 *
 * @author by lyh on 2016/10/3 22:48.
 */

public class TestFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.test_fragment, null);
        return contentView;
    }
}
