package shs.mobile01.mealmate_version11.Model.dao;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Context;
import android.database.sqlite.*;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper{

    private SQLiteDatabase sqlDB = getWritableDatabase();
    private static ArrayList<String> DBInstance;


    public static final int DATABASE_MODE_SELECT = 1;
    public static final int DATABASE_MODE_UPDATE = 2;
    public static final int DATABASE_MODE_INSERT = 3;

    public static final String DATABASE_NAME = "meal_mate";
    public static final String TABLE_MEAL = "MEAL_TABLE";
    public static final String TABLE_FOOD = "FOOD_TABLE";
    public static final String TABLE_USER = "USER_TABLE";

//    private static final String COLUMN_MEAL_INDEX = "meal_index";
//    private static final String COLUMN_MEAL_DATE = "meal_date";
//    private static final String COLUMN_MEAL_CNT = "meal_cnt";
//    private static final String COLUMN_MEAL_FOOD_AMOUNT="meal_food_amount";
//    private static final String COLUMN_FOOD_INDEX ="food_index";



    private static final int DATABASE_VERSION = 1;

//    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
    public DataBase(@Nullable Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // 테이블 생성 및 초기 데이터 삽입 등 초기화 작업 수행

        //유저 테이블을 만드는 쿼리문
        String createUserTableQuery="CREATE TABLE user(user_name TEXT PRIMARY KEY, user_kcal FLOAT,user_height FLOAT,user_purpose INTEGER,user_pwd INTEGER,user_work INTEGER )";
        db.execSQL(createUserTableQuery);
        //음식 정보 테이블 쿼리문
        String createFoodTableQuery="CREATE TABLE food_info(food_index INTEGER PRIMARY KEY, food_name TEXT, food_kcal FLOAT," +
                " food_carbohydrates FLOAT, food_protein FLOAT,food_fat FLOAT,food_favorite INTEGER ,food_API_code TEXT)";
        db.execSQL(createFoodTableQuery);
        //식단 기록 테이블 쿼리문
        String createMealLogQuery="CREATE TABLE meal_Log(meal_index INTEGER PRIMARY KEY,meal_date DATE,meal_cnt INTEGER,meal_food_amount INTEGER,food_index INTEGER )";
        db.execSQL(createMealLogQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_NAME);
        onCreate(db);
    }


    public void process_to_DB(String table,int mode,@Nullable String condition){
        String sql = makeSQLString(table,mode,condition);
    }

    private String makeSQLString(String table, int mode, @Nullable  String condition){
        String sql = "";
        switch (mode){
            case DATABASE_MODE_SELECT: sql+="SELECT * FROM "+table; break;
            case DATABASE_MODE_UPDATE: sql+="UPDATE "+table+" SET "; break;
            case DATABASE_MODE_INSERT: sql+="INSERT INTO "+table; break;
        }
        if( condition!=null)
            sql+="WHERE "+condition;

        return sql;
    }
}
