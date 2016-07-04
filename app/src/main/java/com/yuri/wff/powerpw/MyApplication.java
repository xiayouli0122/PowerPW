package com.yuri.wff.powerpw;

import android.app.Application;

import com.yuri.xlog.Log;
import com.yuri.xlog.Settings;

/**
 * Created by Yuri on 2016/7/4.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.initialize(Settings.getInstance());
    }
}
