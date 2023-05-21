package shs.mobile01.mealmate_version11.Model.dao;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.Model.entity.Meal;


public class Repository_Meal {
    //testing data
    ArrayList<Meal> meals = new ArrayList<>(Arrays.asList(new Meal(),new Meal(),new Meal()));

    MutableLiveData mutableLiveData = new MutableLiveData();
    //end data

    private LiveData<ArrayList<Meal>> listLiveData;


    private DataBase dataBase;


    public Repository_Meal(Application application){
        mutableLiveData.setValue(meals);

        listLiveData = mutableLiveData;
    }

    public LiveData<ArrayList<Meal>> getListLiveData() {
        return listLiveData;
    }

    public void testDeleteMeal(Meal meal){
        meals.remove(meal);
    }

}











// 더미 데이터
//    public void meal_Configuration(int meal_num){
//        for(int i=0;i<dataModel_meals.size();i++)
//            if(dataModel_meals.get(i).getMealTime()==meal_num)
//                dataModel_meals.get(i).onCheckedChange();
//
//        dataBase.process_to_DB(DataBase.TABLE_MEAL, DataBase.DATABASE_MODE_UPDATE,null);
//        }




//    private ArrayList<String> make_DB_Data(){
//        ArrayList<String> data = new ArrayList<>();
////        for(int i=0;i<dataModel_meals.size();i++){
////            data.addAll(dataModel_meals.get(i).getDBString());// note!!
////        }
//       return data;
//    }

//    private void loadMealList(int datetime){ //test
//        // 날짜를 입력받아서 해당 날짜의 식단정보를 로딩
////        dataModel_meals = new ArrayList<>();
////        for(int i=0;i<3;i++){
////            dataModel_meals.add(new DataModel_Meal(0,20,1,2,3,false));
////            dataModel_meals.add(new DataModel_Meal(1,20,2,5,2,false));
////            dataModel_meals.add(new DataModel_Meal(2,20,3,6,2,false));
////        }
//    }