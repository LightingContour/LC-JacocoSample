package com.lightingcontour.lc_jacocosample.lifecycle;

import android.app.Application;
import android.util.Log;

import com.lightingcontour.lc_jacocosample.test.JacocoInstrumentation;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        final JacocoInstrumentation jacocoInstrumentation = new JacocoInstrumentation();
        final String TAG = "MyApplication:";

        AppFrontBackHelper helper = new AppFrontBackHelper();
        helper.register(MyApplication.this, new AppFrontBackHelper.OnAppStatusListener() {
            @Override
            public void onFront() {
                //应用切到前台，进行覆盖率数据获取.
                jacocoInstrumentation.UsegenerateCoverageReport();
                Log.d(TAG,"通过生命周期获取覆盖率...");
            }

            @Override
            public void onBack() {

            }
        });
    }
}
