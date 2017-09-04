package com.example.walkerym.wym_broadcastreceiver_demo.Tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.walkerym.wym_broadcastreceiver_demo.BroadcastReceiver.LocalBroadcastReceiver;
import com.example.walkerym.wym_broadcastreceiver_demo.R;

public class BasicActivity extends AppCompatActivity {

    private LogoutBroacastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        ActivityManager.addActivity(this);

         receiver = new LogoutBroacastReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.walkerym.Logout_Broadcast");

//        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(BasicActivity.this);
        registerReceiver(receiver, filter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.removeActivity(this);
        unregisterReceiver(receiver);
    }

    class LogoutBroacastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            ActivityManager.removeAllActivity();
        }
    }


}
