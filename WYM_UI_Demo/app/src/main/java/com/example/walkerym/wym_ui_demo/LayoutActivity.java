package com.example.walkerym.wym_ui_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LayoutActivity extends AppCompatActivity {

    private List<String> dataList = new ArrayList<>();
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        initData();

        ListView layoutListView = (ListView) findViewById(R.id.layout_list_view);
        layoutListView.setAdapter(adapter);
        layoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){}

            }
        });
    }


    private void initData(){

        dataList.add("LinearLayout");
        dataList.add("RelativeLayout");
        dataList.add("FrameLayout");
        dataList.add("百分比布局");

        adapter = new ArrayAdapter(LayoutActivity.this, android.R.layout.simple_list_item_1, dataList);
    }

}
