package shs.mobile01.mealmate_version11.ViewModel;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;

import shs.mobile01.mealmate_version11.Model.dao.Repository_Food;
import shs.mobile01.mealmate_version11.Model.dao.Repository_Meal;
import shs.mobile01.mealmate_version11.Model.dto.DataModel_Meal;

public class ViewModel_SetMeal {
    ArrayList<DataModel_Meal> dataModel_meals = new ArrayList<>();
    Repository_Meal repository_meal;
    Repository_Food repository_food;


    public ViewModel_SetMeal(Repository_Meal repository_meal, Repository_Food repository_food ){
        this.repository_meal = repository_meal;
        this.repository_food = repository_food;
    }
}
