package shs.mobile01.mealmate_version11.Model.dao;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.Model.entity.Food;


public class Repository_Food {
    //testing data
    ArrayList<Food> Food = new ArrayList<>(Arrays.asList(new Food(),new Food(),new Food(),new Food(), new Food()));

    MutableLiveData mutableLiveData = new MutableLiveData();
    //end data
    private LiveData<ArrayList<Food>> listLiveData;

    private DataBase dataBase;

    public Repository_Food(Application application){
        mutableLiveData.setValue(Food);

        listLiveData = mutableLiveData;
    }

    public LiveData<ArrayList<Food>> getListLiveData(){
        return listLiveData;
    }
}
