package com.surajghadge.assetstorage.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AssetDatabase {
    private Context context;
    private static AssetDatabase assetDatabase;
    private String dbName;

    private AssetDatabase(Context context,String dbName) {
        this.context = context;
        this.dbName = dbName;
    }

    public static AssetDatabase getAssetDatabaseInstance(Context context,String dbName) {
        if(assetDatabase == null){
            assetDatabase = new AssetDatabase(context,dbName);
        }
        return assetDatabase;
    }

    public SQLiteDatabase copyDatabase() {
        File dbFile = context.getDatabasePath(dbName);

        if (!dbFile.exists()) {
            copyAssetDatabase(dbFile);
        }

        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READONLY);
    }

    private void copyAssetDatabase(File dbFile){
        copyDatabase(dbFile);
    }

    private void copyDatabase(File dbFile) {
        InputStream is = null;
        try {
            is = context.getAssets().open(dbName);
            OutputStream os = new FileOutputStream(dbFile);

            byte[] buffer = new byte[is.available()];
            while (is.read(buffer) > 0) {
                os.write(buffer);
            }

            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}