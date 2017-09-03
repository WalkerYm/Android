package com.example.walkerym.wym_ui_demo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BasicUIControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_uicontrol);

        Button alertDialogBtn = (Button) findViewById(R.id.alert_dialog_btn);
        alertDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(BasicUIControlActivity.this);
                alertDialog.setTitle("我是 Title");
                alertDialog.setCancelable(false);
                alertDialog.setMessage("我是 AlertDialog 内容");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(BasicUIControlActivity.this, "点击了 Ok 按钮", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(BasicUIControlActivity.this, "点击了 Cancle 按钮", Toast.LENGTH_SHORT).show();
                    }
                });

               alertDialog.show();

            }
        });



        Button progressDialogBtn = (Button) findViewById(R.id.progress_dialog_btn);
        progressDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BasicUIControlActivity.this, "现在 已经弃用 ProgressDialog", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
