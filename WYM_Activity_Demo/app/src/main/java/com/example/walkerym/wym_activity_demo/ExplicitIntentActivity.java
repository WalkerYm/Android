package com.example.walkerym.wym_activity_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ExplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        String explicitString = getIntent().getStringExtra("explicitData");

        Toast.makeText(this, explicitString, Toast.LENGTH_SHORT).show();
    }
}
