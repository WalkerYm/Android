package com.example.walkerym.wym_ui_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {


    private List<Fruit> fruits = new ArrayList<Fruit>();
    private FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        initData();

        ListView listView = (ListView) findViewById(R.id.custom_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Fruit fruit = fruits.get(i);
                Toast.makeText(CustomListViewActivity.this, fruit.getFruitName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData(){

        for (int i = 0; i < 50; i++){
//            String name = "Fruit" + i;
            Fruit apple = new Fruit(R.drawable.rotation, "apple1");
            fruits.add(apple);
        }

        adapter = new FruitAdapter(CustomListViewActivity.this, R.layout.fruit_item, fruits);
    }
}
