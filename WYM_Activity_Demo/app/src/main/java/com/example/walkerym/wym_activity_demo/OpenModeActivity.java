package com.example.walkerym.wym_activity_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OpenModeActivity extends AppCompatActivity {

    private List<String> dataList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_mode);

        initData();

        ListView listView = (ListView) findViewById(R.id.open_mode_list_view);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){

                    case 0:
                        Intent standardIntent = new Intent(OpenModeActivity.this, StandardActivity.class);
                        startActivity(standardIntent);
                        break;
                    case 1:
                        Intent singleTopIntent = new Intent(OpenModeActivity.this, SingleTopActivity.class);
                        startActivity(singleTopIntent);
                        break;
                    case 2:
                        Intent singleTaskIntent = new Intent(OpenModeActivity.this, SingleTaskAcitvity.class);
                        startActivity(singleTaskIntent);
                        break;
                    case 3:
                        Intent singleInstance = new Intent(OpenModeActivity.this, SingleInstanceActivity.class);
                        startActivity(singleInstance);
                        break;

                }
            }
        });


    }


    private void initData(){

        dataList.add("Standard");
        dataList.add("SingleTop");
        dataList.add("SingleTask");
        dataList.add("SingleInstance");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);


    }
}
