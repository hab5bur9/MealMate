package shs.mobile01.mealmate_version11.Model.repository;


import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.concurrent.Executors;

import shs.mobile01.mealmate_version11.Model.dao.UserDao;
import shs.mobile01.mealmate_version11.Model.database.AppDatabase;
import shs.mobile01.mealmate_version11.Model.entity.User;

public class UserRepository {
    private static UserRepository instance = null;
    private final UserDao userDao;
    private final AppDatabase db;

    public UserRepository(Context context) {
        db = Room.databaseBuilder(context, AppDatabase.class, "app-database").build();
        userDao = db.userDao();
    }

    public static UserRepository getInstance(Context context){
        if(instance == null){
            synchronized (FoodRepository.class){
                if(instance==null){
                    instance= new UserRepository(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    public void insertUser(User user) {
        Executors.newSingleThreadExecutor().execute(() -> {
            userDao.insertUser(user);
        });
    }

    public void updateUser(User user) {
        Executors.newSingleThreadExecutor().execute(() -> {
            userDao.updateUser(user);
        });
    }

    public void deleteUser(User user) {
        Executors.newSingleThreadExecutor().execute(() -> {
            userDao.deleteUser(user);
        });
    }

    public LiveData<User> getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }
}