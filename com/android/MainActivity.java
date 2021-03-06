package com.android;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import com.mindorks.placeholderview.PlaceHolderView;

public class MainActivity extends AppCompatActivity {

    private static final int MY_CAMERA_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.e("BuildVerion","Inside build version check");
            if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                Log.e("ActivityCompat","Inside ActivityCompat check");
                requestPermissions(new String[]{android.Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
            }
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        Log.e("onRequestPermissions","onRequestPermissionsResult Called");
        if (requestCode == MY_CAMERA_REQUEST_CODE) {
            Log.e("in if requestcode","MY_CAMERA_REQUEST_CODE --"+MY_CAMERA_REQUEST_CODE);
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.e("onRequestPermissions","onRequestPermissionsResult - Permission granted");
                Toast.makeText(this, "Camera permission granted", Toast.LENGTH_LONG).show();
                //onResume();
            } else {
                Log.e("onRequestPermissions","onRequestPermissionsResult - Permission denied");
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_LONG).show();
            }

        }
    }
}
