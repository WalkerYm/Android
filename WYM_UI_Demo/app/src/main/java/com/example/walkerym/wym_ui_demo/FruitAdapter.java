package com.example.walkerym.wym_ui_demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by walkerym on 2017/8/28.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    class ViewHolder{
        private ImageView imageView;
        private TextView textView;


    }

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> fruits){

        super(context, textViewResourceId, fruits);
        resourceId = textViewResourceId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Fruit fruit = getItem(position);
        View view;
        ViewHolder holder;

        if (convertView == null){

            //注意：false 参数
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.image_view);
            holder.textView = (TextView) view.findViewById(R.id.text_view);
            view.setTag(holder);

        } else {

            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        holder.imageView.setImageResource(fruit.getImageId());
        holder.textView.setText(fruit.getFruitName());

        return view;

    }
}
