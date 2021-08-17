package com.bytedance.day20210817_demo5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements ItemTouchAdapter{
    private List<String> list=new ArrayList<>();

    public MyAdapter(List<String> list){
        this.list=list;
    }





    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view=null;
        switch (viewType){
            case 0:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item1,parent,false);
                break;
            case 1:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item2,parent,false);
                break;
            case 2:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item3,parent,false);
                break;
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull MyAdapter.MyViewHolder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }



    @Override
    public void onItemSwiped(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemDragged(int from, int to) {
        Collections.swap(list,from,to);
        notifyItemMoved(from,to);
    }





    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.my_textview);
        }

        public void bindData(String str){
            textView.setText(str);
        }
    }
}
