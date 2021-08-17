package com.bytedance.day20210817_demo5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.my_recyclerview);
        List<String> list=new ArrayList<>();
        for(int i=0;i<30;i++){
            list.add("hello "+i);
        }
        MyAdapter myAdapter=new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //1. 自定义的ItemTouchHelper.Callback
        MyItemTouchHelper myItemTouchHelper=new MyItemTouchHelper(myAdapter);
        //2. 利用这个Callback构造ItemTouchHelper
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(myItemTouchHelper);
        //3. 把ItemTouchHelper和RecyclerView关联起来
        itemTouchHelper.attachToRecyclerView(recyclerView);


    }
}