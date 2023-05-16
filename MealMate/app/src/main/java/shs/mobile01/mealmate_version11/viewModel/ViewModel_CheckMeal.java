package shs.mobile01.mealmate_version11.viewModel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import shs.mobile01.mealmate_version11.Model.dao.Repository_Meal;
import shs.mobile01.mealmate_version11.Model.dto.DataModel_Meal;

public class ViewModel_CheckMeal extends ViewModel {
    private Repository_Meal repository_meal;
    private ArrayList<DataModel_Meal> mealList = repository_meal.getMealList(); // 동기화

    public ViewModel_CheckMeal(Repository_Meal repository_meal ){
        this.repository_meal = repository_meal;
    }


    public void onCheckedMeals(View view){
        int mealTime = 2;
        repository_meal.meal_Configuration(2);
    }
}
