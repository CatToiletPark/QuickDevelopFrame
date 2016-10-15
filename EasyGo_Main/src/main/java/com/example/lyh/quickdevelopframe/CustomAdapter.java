package com.example.lyh.quickdevelopframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.easygo.framework.ui.widget.recylcerview.EasyGoRecyclerAdapter;

import java.util.List;

/**
 * Created by lynn on 2016/10/13.
 */

public class CustomAdapter extends EasyGoRecyclerAdapter<String, CustomViewHolder> {
    public CustomAdapter(Context context, List<String> mData) {
        super(context, mData);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.easyGoTextView.setText(mData.get(position));
    }
}
