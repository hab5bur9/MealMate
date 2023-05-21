package shs.mobile01.mealmate_version11.Model.dao;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import shs.mobile01.mealmate_version11.Model.entity.User;

public class Repository_User {

    private DataBase dataBase;
    private LiveData<ArrayList<User>> listLiveData = new MutableLiveData<>();

    public Repository_User(Application application){

    }


    public LiveData<ArrayList<User>> getListLiveData() {
        return listLiveData;
    }
}
