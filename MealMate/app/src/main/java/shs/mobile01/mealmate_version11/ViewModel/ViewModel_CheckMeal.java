package shs.mobile01.mealmate_version11.ViewModel;

import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.Model.dao.Repository_Meal;
import shs.mobile01.mealmate_version11.Model.dto.DataModel_Meal;

public class ViewModel_CheckMeal{
    private Repository_Meal repository_meal;
    private ArrayList<DataModel_Meal> mealList = repository_meal.getMealList(); // 동기화

    public ViewModel_CheckMeal(Repository_Meal repository_meal ){
        this.repository_meal = repository_meal;
    }

    public void checkMeal(){
        int mealTime;
        repository_meal.meal_Configuration();
    }
}
