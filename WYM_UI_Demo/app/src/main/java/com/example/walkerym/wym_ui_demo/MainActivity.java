package com.example.walkerym.wym_ui_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/** Git 使用教程
 * 1. 我是第一次修改的
 * 2. 我是第三次提交
 *
 * */

public class MainActivity extends AppCompatActivity {

    private List<String> dataList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        ListView mainListView = (ListView) findViewById(R.id.main_list_view);
        mainListView.setAdapter(adapter);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent basciIntent = new Intent(MainActivity.this, BasicUIControlActivity.class);
                        startActivity(basciIntent);
                        break;
                    case 1:
                        Intent layoutIntent = new Intent(MainActivity.this, LayoutActivity.class);
                        startActivity(layoutIntent);
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                    case 4:
                        Intent customListViewIntent = new Intent(MainActivity.this, CustomListViewActivity.class);
                        startActivity(customListViewIntent);
                        break;
                }
            }
        });
    }


    private void initData(){

        dataList.add("常用 UI 控件");
        dataList.add("四种 Layout");
        dataList.add("自定义 控件");
        dataList.add("ListView 基本用法");
        dataList.add("定制 ListView 界面");
        dataList.add("RecyclerView 的使用");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
    }
}
