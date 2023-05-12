package shs.mobile01.mealmate_version11.Model.dao;

import java.util.ArrayList;

import shs.mobile01.mealmate_version11.Model.dto.DataModel_Meal;

public class Repository_Meal extends DataBase{

    private ArrayList<DataModel_Meal> dm ;

    public void setMealList(int datetime){

    }

    public Repository_Meal getCurrentData(){
        return this;
    }

    public ArrayList<DataModel_Meal> getMealList(){
        return dm;
    }

    public void updateMealList(int datetime){

    }

    public String loadDBString(int datetime){
        return "select * from meal where datetime = "+datetime;
    }
}
