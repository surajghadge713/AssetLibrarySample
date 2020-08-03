package com.surajghadge.assetstorage.sharedpreference;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class AssetSharedPrefHelper {

    private Context context;
    private String[] shared_prefs = new String[]{"global_data.xml","MachineDetails.xml","new_adult_amount_season1_ZERO.xml",
            "new_child_amount_season1_ZERO.xml","trip_info.xml"};

    private List<String> sharedPrefList;
    private static AssetSharedPrefHelper assertSharedPrefHelper;

    private AssetSharedPrefHelper(Context context, List<String> sharedPrefList) {
        this.context = context;
        this.sharedPrefList = sharedPrefList;
    }

    public static AssetSharedPrefHelper getAssertSharedPrefHelper(Context context, List<String> sharedPrefList){
        if(assertSharedPrefHelper == null){
            assertSharedPrefHelper = new AssetSharedPrefHelper(context,sharedPrefList);
        }

        return assertSharedPrefHelper;
    }

    public void storeSharedPref() {
        for (int i =0 ;i<sharedPrefList.size();i++){
            File f = context.getDatabasePath("/data/data/"+context.getPackageName()+"/shared_prefs/"+shared_prefs[i]);
            if(!f.exists()){
                try {
                    copySharedPrefFile(f,shared_prefs[i]);
                } catch (IOException e) {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(context, "File Exist", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void copySharedPrefFile(File dbFile, String fileName) throws IOException {
        InputStream is = context.getAssets().open(fileName);
        OutputStream os = new FileOutputStream(dbFile);

        byte[] buffer = new byte[is.available()];
        while (is.read(buffer) > 0) {
            os.write(buffer);
        }

        os.flush();
        os.close();
        is.close();
    }
}

