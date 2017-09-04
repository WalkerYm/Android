package com.example.walkerym.wym_broadcastreceiver_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> dataList = new ArrayList();
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

                        Intent systemBroadcastIntent = new Intent(MainActivity.this, ReceiverSystemBroadcastAvtivity.class);
                        startActivity(systemBroadcastIntent);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });
    }

    private void initData(){

        dataList.add("动态注册接收系统广播 + 网络权限");
        dataList.add("静态注册接收系统开机广播");
        dataList.add("");
        dataList.add("");


        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, dataList);

    }

}
