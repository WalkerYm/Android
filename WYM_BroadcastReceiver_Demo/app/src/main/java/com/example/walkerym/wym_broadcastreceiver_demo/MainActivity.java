package com.example.walkerym.wym_broadcastreceiver_demo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.walkerym.wym_broadcastreceiver_demo.BroadcastReceiver.LocalBroadcastReceiver;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> dataList = new ArrayList();
    private ArrayAdapter<String> adapter;
    private LocalBroadcastManager manager;

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

                        //发送标准广播
                        Intent standardIntent = new Intent("com.example.walkerym.MY_Broadcast");
//                        filter.addAction("com.example.walkerym.MY_Broadcast");
                        sendBroadcast(standardIntent);

                        break;

                    case 3:
                        Intent orderIntent = new Intent("com.example.walkerym.Order_Broadcast");
                        sendOrderedBroadcast(orderIntent, null);
                        break;

                    case 4:


                       Intent localIntent = new Intent("com.example.walkerym.Local_Broadcast");
                        manager.sendBroadcast(localIntent);


                        break;
                }
            }
        });
    }

    private void initData(){

        dataList.add("2.1 动态注册接收系统广播 + 网络权限");
        dataList.add("2.2 静态注册接收系统开机广播");
        dataList.add("3.1 发送自定义广播 -> 标准广播");
        dataList.add("3.2 发送自定义广播 -> 有序广播");
        dataList.add("4. 使用本地广播");
        dataList.add("5. 广播的最佳实践 -> 强制下线功能");


        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, dataList);


        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.walkerym.Local_Broadcast");
        LocalBroadcastReceiver receiver = new LocalBroadcastReceiver();
        manager = LocalBroadcastManager.getInstance(this);
        manager.registerReceiver(receiver, filter);


    }

}
