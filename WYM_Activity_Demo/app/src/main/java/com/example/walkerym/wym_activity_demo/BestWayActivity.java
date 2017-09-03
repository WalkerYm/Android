package com.example.walkerym.wym_activity_demo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BestWayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_way);


        String dataString = getIntent().getStringExtra("sendData");

        Toast.makeText(this, dataString, Toast.LENGTH_SHORT).show();

    }


    public static void openActivity(Context context, String dataString){

        Intent intent = new Intent(context, BestWayActivity.class);
        intent.putExtra("sendData", dataString);
        context.startActivity(intent);

    }
}
