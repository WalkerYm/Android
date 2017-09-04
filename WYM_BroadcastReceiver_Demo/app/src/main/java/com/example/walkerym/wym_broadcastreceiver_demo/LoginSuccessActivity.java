package com.example.walkerym.wym_broadcastreceiver_demo;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.walkerym.wym_broadcastreceiver_demo.Tools.BasicActivity;

public class LoginSuccessActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        Button logoutBtn = (Button) findViewById(R.id.logout_btn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                LocalBroadcastManager manager = LocalBroadcastManager.getInstance(LoginSuccessActivity.this);
                Intent logoutBroadcastIntent = new Intent("com.example.walkerym.Logout_Broadcast");
                sendBroadcast(logoutBroadcastIntent);




            }
        });
    }
}
