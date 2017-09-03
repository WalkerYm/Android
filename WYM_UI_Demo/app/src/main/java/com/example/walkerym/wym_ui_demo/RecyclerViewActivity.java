package com.example.walkerym.wym_ui_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<String> dataList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initData();

        ListView listView = (ListView) findViewById(R.id.recycler_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        break;

                    case 1:
                        break;

                    case 2:
                        break;

                    case 3:
                        break;
                }
            }
        });

    }

    private void initData(){

        dataList.add("ListView 垂直分布");
        dataList.add("ListView 水平分布");
        dataList.add("网格布局");
        dataList.add("瀑布流布局");

        adapter = new ArrayAdapter<String>(RecyclerViewActivity.this, android.R.layout.simple_list_item_1, dataList);

    }
}
