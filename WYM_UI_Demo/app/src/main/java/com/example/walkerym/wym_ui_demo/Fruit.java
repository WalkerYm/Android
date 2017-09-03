package com.example.walkerym.wym_ui_demo;

/**
 * Created by walkerym on 2017/8/28.
 */

public class Fruit {

    private int imageId;
    private String fruitName;

    public Fruit(int imageIdInt, String fruitNameString){

        imageId = imageIdInt;
        fruitName = fruitNameString;
    }

    public int getImageId(){

        return imageId;
    }

    public String getFruitName(){

        return fruitName;
    }
}
