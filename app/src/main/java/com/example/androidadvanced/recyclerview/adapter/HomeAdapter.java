package com.example.androidadvanced.recyclerview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidadvanced.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{

    private List<String> mList;
    private Context context;
    private OnItemClickListener onItemClickListener;
    private List<Integer> mHeight;
    private boolean isWF;

    public HomeAdapter(Context context,List<String> mList){
        this.context = context;
        this.mList = mList;

    }

    public void removeData(int position){
        mList.remove(position);
        notifyItemRemoved(position);
        //按照书里那个写法 删除了item以后 会导致item位置错乱 需要加下面这段代码 重新计算item的位置
        if (position != mList.size()) {
            notifyItemRangeChanged(position, mList.size() - position);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,int position) {
        if (isWF) {
            //给每一个item设置高度
            ViewGroup.LayoutParams lp = holder.tv.getLayoutParams();
            lp.height = mHeight.get(position);
            holder.tv.setLayoutParams(lp);
        }
        holder.tv.setText(mList.get(position));
        holder.position =position;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 设置是否使用瀑布流
     * 得后续搞一下
     */
    public void setWaterfallFlow() {
        isWF = true;
        mHeight = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            mHeight.add((int) (100+Math.random() * 300));
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView tv;
        int position;
        public MyViewHolder(View view){
            super(view);
            tv = view.findViewById(R.id.tv_item);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null){
                onItemClickListener.onItemClick(view, position);
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if (onItemClickListener != null){
                onItemClickListener.onItemLongClick(view, position);
            }
            return true;
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

}
