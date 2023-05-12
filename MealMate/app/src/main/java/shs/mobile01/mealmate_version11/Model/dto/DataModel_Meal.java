package shs.mobile01.mealmate_version11.Model.dto;

import androidx.annotation.Nullable;

public class DataModel_Meal {

    private int index;
    private int datetime; // check needed
    private int mealTime;
    private int food_index;
    private int meal_amount;

    public int getIndex(){return index;}
    public int getDatetime(){return datetime;}
    public int getMealTime(){return mealTime;}
    public int getFood_index(){return food_index;}
    public int getMeal_amount(){return meal_amount;}

    public void setIndex(int index){this.index = index;}
    public void setDatetime(int datetime){this.datetime=datetime;}
    public void setMealTime(int mealTime){this.mealTime=mealTime;}
    public void setFood_index(int food_index){this.food_index=food_index;}
    public void setMeal_amount(int meal_amount){this.meal_amount=meal_amount;}

    // 안녕하세요 존잘남입니다.
    public DataModel_Meal(int index,int datetime, int mealTime, int food_index,int meal_amount ){
        this.index=index;
        this.datetime=datetime;
        this.food_index=food_index;
        this.meal_amount=meal_amount;
    }
}
