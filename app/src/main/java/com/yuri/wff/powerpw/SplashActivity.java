package com.yuri.wff.powerpw;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yuri.wff.loginlib.managers.AppLock;
import com.yuri.wff.powerpw.login.CustomPinActivity;
import com.yuri.xlog.Log;

/**
 * Created by Yuri on 2016/7/4.
 */
public class SplashActivity extends AppCompatActivity {


    public static final String EXTRA_IS_LOGIN = "extra_is_login";
    public static final int REQUEST_CODE_ENABLE_LOCK = 0;
    public static final int REQUEST_CODE_UNLOCK = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isLogin = SharedPreferencesUtil.get(this, EXTRA_IS_LOGIN, false);
        Intent intent = new Intent();
        intent.setClass(this, CustomPinActivity.class);
        if (isLogin) {
            intent.putExtra(AppLock.EXTRA_TYPE, AppLock.UNLOCK_PIN);
        } else {
            intent.putExtra(AppLock.EXTRA_TYPE, AppLock.ENABLE_PINLOCK);
        }

        int requestCode = isLogin ? REQUEST_CODE_UNLOCK : REQUEST_CODE_ENABLE_LOCK;
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d();
        if (requestCode == REQUEST_CODE_ENABLE_LOCK) {
            SharedPreferencesUtil.put(this, EXTRA_IS_LOGIN, true);
        }

        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);

        finish();
    }
}
