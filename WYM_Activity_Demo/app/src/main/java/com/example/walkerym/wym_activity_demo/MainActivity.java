package com.example.walkerym.wym_activity_demo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /** Demo 内容：
     * 1. Activity 生命周期;
     * 2. 显式 Intent + 正向传值；
     * 3. 隐式 Intent + 反向传值;
     * 4. 活动的启动模式；
     * 5. 最佳的活动跳转方式；
     * 6. Toast 的使用
     * 7. Menu 的使用；
     * 8. Log 的 5 种打印方式
     *
     * */

    private List<String> dataList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("第一创建时", "onCreate");

        initData();
        ListView mainListView = (ListView) findViewById(R.id.main_list_view);
        mainListView.setAdapter(adapter);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){

                    case 0:
                        Intent explicitIntent = new Intent(MainActivity.this, ExplicitIntentActivity.class);
                        explicitIntent.putExtra("explicitData", "我是正向传递过来的");
                        startActivity(explicitIntent);
                        break;

                    case 1:
                        Intent implicitIntent = new Intent(MainActivity.this, ImplicitIntentActivity.class);
                        startActivityForResult(implicitIntent, 1);
                        break;

                    case 2:
                        Intent openModeIntent = new Intent(MainActivity.this, OpenModeActivity.class);
                        startActivity(openModeIntent);
                        break;

                    case 3:
                        BestWayActivity.openActivity(MainActivity.this, "我是传递过来的指");
                        break;

                }
            }
        });

    }


    private void initData(){

        dataList.add("显式 Intent + 正向传值");
        dataList.add("隐式 Intent + 反向传值");
        dataList.add("Activity 的4种启动模式");
        dataList.add("Activity 最佳的跳转");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case 1:
                if (resultCode == RESULT_OK){
                    String implicitString = data.getStringExtra("implicitData");
                    Toast.makeText(this, implicitString, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "点击 Add Item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "点击 Remove Item", Toast.LENGTH_SHORT).show();
                break;

        }

        return true;
    }

    //生命周期

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("有不可见 -> 可见", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("准备好与用户交互", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("恢复或启动另外一个活动", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("活动完全不可见", "onStop()");
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("销毁", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("重新启动", "onDestroy");
    }
}
