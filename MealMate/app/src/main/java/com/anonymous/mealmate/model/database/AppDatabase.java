package com.anonymous.mealmate.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.anonymous.mealmate.model.dao.FoodDao;
import com.anonymous.mealmate.model.dao.MealDao;
import com.anonymous.mealmate.model.dao.UserDao;
import com.anonymous.mealmate.model.entity.Food;
import com.anonymous.mealmate.model.entity.Meal;
import com.anonymous.mealmate.model.entity.User;

// version = 1 : 처음 생성할 때 버전 1로 생성. 이후에 업데이트할 때마다 버전을 올려줘야 함.
@Database(entities = {Meal.class, Food.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "app_database";
    private static AppDatabase instance;

    public abstract MealDao mealDao();      // MealDao를 사용하기 위한 메소드.
    public abstract FoodDao foodDao();
    public abstract UserDao userDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME)
                    .build();
        }
        return instance;
    }
}
