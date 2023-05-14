package shs.mobile01.mealmate_version11.Model.dao;

import java.util.ArrayList;

import android.content.Context;
import android.database.sqlite.*;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper{
    private static ArrayList<String> DBInstance;

    public final int DATABASE_MODE_SELECT = 1;
    public final int DATABASE_MODE_UPDATE = 2;
    public final int DATABASE_MODE_INSERT = 3;

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void downloadDB(String sql){

    }
    public void uploadDB(String table,int mode, @Nullable String condition) {

        String sql = makeSQLString(table,mode,condition);
    }
    private String makeSQLString(String table, int mode, @Nullable  String condition){
        String sql = "";
        switch (mode){
            case DATABASE_MODE_SELECT: sql+="SELECT * FROM table "; break;
            case DATABASE_MODE_UPDATE: sql+="UPDATE table SET "; break;
            case DATABASE_MODE_INSERT: sql+="INSERT INTO table "; break;
        }
        if( condition!=null)
            sql+="WHERE "+condition;

        return sql;
    }
}
