package com.example.walkerym.wym_broadcastreceiver_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.walkerym.wym_broadcastreceiver_demo.Tools.BasicActivity;

public class LoginActivity extends BasicActivity {

    private EditText userNameET;
    private EditText passwordET;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

    }

    private void initViews(){
        userNameET = (EditText) findViewById(R.id.user_name_edit_text);
        passwordET = (EditText) findViewById(R.id.psw_edit_text);
        loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userNameET.getText().toString().equals("123456") && passwordET.getText().toString().equals("0000")){

                    Intent loginSuccessIntent = new Intent(LoginActivity.this, LoginSuccessActivity.class);
                    startActivity(loginSuccessIntent);

                } else {

                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
