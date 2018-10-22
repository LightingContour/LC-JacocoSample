package com.lightingcontour.lc_jacocosample.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lightingcontour.lc_jacocosample.R;
import com.lightingcontour.lc_jacocosample.Utils.PermissionUtils;

import com.lightingcontour.lc_jacocosample.test.JacocoInstrumentation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //定义layout中所用组件
    public TextView A,B;

    private int AClickedTime = 0;
    private boolean easterEgg = false;

    public JacocoInstrumentation jacocoInstrumentation = new JacocoInstrumentation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //赋值、绑定layout组件
        A = (TextView) findViewById(R.id.Test1);
        B = (TextView) findViewById(R.id.Test2);

        findViewById(R.id.Btn1).setOnClickListener(this);
        findViewById(R.id.Btn2).setOnClickListener(this);
        findViewById(R.id.Btn3).setOnClickListener(this);

        //动态申请SD卡读取权限
        PermissionUtils.verifyStoragePermissions(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.Btn1:
                Toast.makeText(this,"点击了第一个按钮",Toast.LENGTH_SHORT).show();
                A.setText("点击了第一个按钮");

                //设定彩蛋：点击了第一个按钮三次，flag为true
                if (AClickedTime < 3)
                {
                    AClickedTime++;
                }else {
                    easterEgg = true;
                }
                break;
            case R.id.Btn2:
                Toast.makeText(this, "点击了第二个按钮", Toast.LENGTH_SHORT).show();
                B.setText("点击了第二个按钮");

                //设定彩蛋：flag为true时，执行以下操作
                if (easterEgg == true)
                {
                    A.setText("恭喜进入彩蛋");
                    B.setText("恭喜进入彩蛋");
                }
                break;
            case R.id.Btn3:
                Toast.makeText(this,"点击了第三个按钮",Toast.LENGTH_SHORT).show();
                jacocoInstrumentation.UsegenerateCoverageReport();
                break;
        }
    }
}
