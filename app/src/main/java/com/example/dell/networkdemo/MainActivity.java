package com.example.dell.networkdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=new Button(this);
        button.setText("TextNet");
        setContentView(button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // TODO Auto-generated method stub
        boolean flag=false;
        ConnectivityManager cwjManager=(ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        if(cwjManager.getActiveNetworkInfo()!=null)
            flag=cwjManager.getActiveNetworkInfo().isAvailable();
        if(!flag){
            AlertDialog.Builder b=new AlertDialog.Builder(this).setTitle("没有可用的网络").setMessage("请开启GPRS或WIFI网路连接");
            b.setPositiveButton("确定",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent mIntent=new Intent("android.settings.WIRELESS_SETTINGS");
                    startActivity(mIntent);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub dialog.cancel();
                }
            }).create(); b.show();
        }
    }

    /*@Override
    public void onClick(View v) {
        boolean flag = false;
        ConnectivityManager manager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo()!= null){
            flag = manager.getActiveNetworkInfo().isAvailable();
            if (!flag){
                AlertDialog.Builder b =  new AlertDialog.Builder(this).setTitle("没有网络可用").setMessage("请开启WIFI或移动网络");
                b.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
                        startActivity(intent);
                    }
                })
                 .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                     }
                 }).create().show();
            }
        }
    }*/
}
