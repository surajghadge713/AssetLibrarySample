package com.surajghadge.assetstoragelibrarysample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.surajghadge.assetstorage.database.AssetDatabase;
import com.surajghadge.assetstorage.sharedpreference.AssetSharedPrefHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> sharedPrefList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);;

        sharedPrefList= new ArrayList<>();
        sharedPrefList.add("global_data.xml");
        sharedPrefList.add("MachineDetails.xml");
        sharedPrefList.add("new_adult_amount_season1_ZERO.xml");
        sharedPrefList.add("new_child_amount_season1_ZERO.xml");
        sharedPrefList.add("trip_info.xml");

        storeAssetsDatabase();
        storeAssetsSharedPref();
    }

    private void storeAssetsSharedPref() {
        AssetSharedPrefHelper sharedPrefHelper =  AssetSharedPrefHelper.getAssertSharedPrefHelper(this,sharedPrefList);
        sharedPrefHelper.storeSharedPref();
    }


    void storeAssetsDatabase() {
        AssetDatabase db1 = AssetDatabase.getAssetDatabaseInstance(this,"msrtc.db");
        db1.copyDatabase();
    }




}