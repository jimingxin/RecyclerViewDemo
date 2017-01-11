package com.jimingxin.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimingxin on 2017/1/10.
 */

public class MyNewsDataAdapter extends RecyclerView.Adapter<MyNewsDataAdapter.CellViewHolder> {

    private List<String> mData;
    private Context mContext;

    private OnRecyclerViewItemClickLisetener mLisetener = null;

    public MyNewsDataAdapter(Context mContext) {

        this.mContext = mContext;
        mData = new ArrayList<>();
        mData.add("毛泽东");mData.add("邓小平");mData.add("周恩来");mData.add("刘伯承");mData.add("林彪");
        mData.add("鲁迅");mData.add("朱德");mData.add("彭德华");mData.add("朱镕基");mData.add("习近平");
        mData.add("江泽民");

    }

    //主要是自定义ViewHolder的初始化并返回出去
    @Override
    public CellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_activity_two,parent,false);
        CellViewHolder holder = new CellViewHolder(view);
        return holder;
    }

    //给控件赋值
    @Override
    public void onBindViewHolder(CellViewHolder holder, final int position) {

        holder.mTitle.setText(mData.get(position).toString());

        /*
        holder.mTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLisetener.onItemClick(view,position);
            }
        });

        holder.mTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mLisetener.onItemLongClick(view,position);
                return true;
            }
        });
        */
    }

    //返回数据的数量
    @Override
    public int getItemCount() {
        return mData.size();
    }


    //接口，用于点击 回调机制
    public interface OnRecyclerViewItemClickLisetener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    //暴露一个方法，给使用者设置监听
    public void setOnClickListener(OnRecyclerViewItemClickLisetener listener){

        mLisetener = listener;
    }

    public class CellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {


        public TextView mTitle;
        public CellViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.tv);
            mTitle.setOnClickListener(this);
            mTitle.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (mLisetener != null) {
                mLisetener.onItemClick(view,getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View view) {
            mLisetener.onItemLongClick(view,getAdapterPosition());
            return true;
        }
    }

}
