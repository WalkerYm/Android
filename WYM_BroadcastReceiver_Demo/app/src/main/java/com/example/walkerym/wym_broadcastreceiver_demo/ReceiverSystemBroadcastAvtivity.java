package com.example.walkerym.wym_broadcastreceiver_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ReceiverSystemBroadcastAvtivity extends AppCompatActivity {

    private NetworkReceiver networkReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_system_broadcast_avtivity);


        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        networkReceiver = new NetworkReceiver();
        registerReceiver(networkReceiver, filter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(networkReceiver);
    }

    class NetworkReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {



            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null && info.isAvailable()){
                Toast.makeText(context, "网络可用", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "网络不可用", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
