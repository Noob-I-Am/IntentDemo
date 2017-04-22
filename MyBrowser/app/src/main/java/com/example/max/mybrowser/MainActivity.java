package com.example.max.mybrowser;
import android.content.pm.PackageManager;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    public Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri uri=Uri.parse("http://www.baidu.com");
        intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("url", "http://www.baidu.com");
        PackageManager pm = getPackageManager();
        List<ResolveInfo> resolveList = pm.queryIntentActivities(intent, PackageManager.MATCH_ALL);
        Log.i("MainActivity", "resolveList size:"+resolveList.size());
        if(resolveList.size() > 0) {
            String title = "choose application";
            Intent intentChooser = Intent.createChooser(intent, title);
            startActivity(intentChooser);
        }else {
            Toast.makeText(MainActivity.this, "no match activity to start!", Toast.LENGTH_SHORT).show();
        }
    }
}
