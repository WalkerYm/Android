package com.example.walkerym.wym_activity_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ImplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);




    }


    //Back 健


    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("implicitData", "我是反向传递回来的");
        setResult(RESULT_OK, intent);

        super.onBackPressed();
    }
}
