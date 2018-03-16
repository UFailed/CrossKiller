package com.example.administrator.myapplication;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void deleteClick(View v){
        deleteMark();
    }
    public void deleteMark(){
        int sdk_num = Build.VERSION.SDK_INT;
        //判断是否取得root权限
        if(RootCmd.checkGetRootAuth()){
            //小于安卓7.0版本
            if(sdk_num < 24){
                RootCmd.execRootCmdSilent("settings put global captive_portal_server captive.lineageos.org.cn");
            }
            //大于安卓7.0版本
            else{
                RootCmd.execRootCmdSilent("settings put global captive_portal_http_url http://captive.lineageos.org.cn/generate_204");
                RootCmd.execRootCmdSilent("settings put global captive_portal_https_url https://captive.lineageos.org.cn/generate_204");
            }
        }
        else{
            Toast.makeText(this,"请获得root权限！", Toast.LENGTH_LONG).show();
        }
    }
}
