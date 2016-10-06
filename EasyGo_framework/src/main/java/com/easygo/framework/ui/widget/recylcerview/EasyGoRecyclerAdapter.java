package com.easygo.framework.ui.widget.recylcerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * description :
 *
 * @author by lyh on 2016/10/6 14:36.
 */

public abstract class EasyGoRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected Context context;

    protected List<T> mData = Collections.synchronizedList(new LinkedList<T>());

    private onItemClickListener listener;

    public EasyGoRecyclerAdapter(Context context, List<T> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public void onBindViewHolder(final VH holder, int position) {
        if (listener != null && holder.itemView != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(holder.getAdapterPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        if (null != listener) this.listener = listener;
    }

    //刷新新增的数据
    public void notifyInsertDataChanged(List<T> data) {
        int currCount=getItemCount()-1;
        this.mData.addAll(data);
        notifyItemRangeInserted(currCount, data.size());
    }

}
