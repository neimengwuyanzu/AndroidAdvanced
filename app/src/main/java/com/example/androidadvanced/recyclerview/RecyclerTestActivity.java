package com.example.androidadvanced.recyclerview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidadvanced.R;
import com.example.androidadvanced.recyclerview.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTestActivity extends AppCompatActivity {

    private Context context;
    private HomeAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_test);
        context = this;
        recyclerView = findViewById(R.id.recyclerview);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(String.valueOf(i));
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new HomeAdapter(this, list);
        //纵向列表
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(RecyclerTestActivity.this, DividerItemDecoration.VERTICAL_LIST));
        //格子列表
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
//        recyclerView.addItemDecoration(new DividerItemDecoration(RecyclerTestActivity.this,DividerItemDecoration.HORIZONTAL_LIST));
        //瀑布流
//        adapter.setWaterfallFlow();
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
//        recyclerView.addItemDecoration(new DividerItemDecoration(RecyclerTestActivity.this, DividerItemDecoration.VERTICAL_LIST));


        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, "点击第 " + position + "条", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, final int position) {
                new AlertDialog.Builder(context)
                        .setTitle("确定删除？")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                adapter.removeData(position);
                            }
                        }).show();

            }
        });

    }
}