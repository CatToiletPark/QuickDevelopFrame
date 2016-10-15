package com.example.lyh.quickdevelopframe;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.easygo.framework.ui.widget.EasyGoTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lynn on 2016/10/13.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text1)
    public EasyGoTextView easyGoTextView;

    public CustomViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
