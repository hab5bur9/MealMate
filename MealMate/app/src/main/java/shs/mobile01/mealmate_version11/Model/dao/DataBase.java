package shs.mobile01.mealmate_version11.Model.dao;

import java.util.ArrayList;

import android.content.Context;
import android.database.sqlite.*;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper{
    private static ArrayList<String> DBInstance;

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void DownloadDB(String sql){

    }
    public void UploadDB(String sql){

    }
}
