package com.example.walkerym.wym_broadcastreceiver_demo.Tools;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by walkerym on 2017/9/5.
 */

public class ActivityManager {

    static private List<Activity> activityList = new ArrayList<>();

    static public void addActivity(Activity activity){

        activityList.add(activity);
    }

    static public void  removeActivity(Activity activity){

        activityList.remove(activity);
    }


    static public void removeAllActivity(){

        for (Activity activity :
                activityList) {
            activity.finish();
        }
    }

}
