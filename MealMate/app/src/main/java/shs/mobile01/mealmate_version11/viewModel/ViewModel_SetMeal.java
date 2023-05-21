package shs.mobile01.mealmate_version11.viewModel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.Model.dao.Repository_Food;
import shs.mobile01.mealmate_version11.Model.dao.Repository_Meal;


public class ViewModel_SetMeal extends AndroidViewModel {

    private Repository_Meal repository_meal;
    private Repository_Food repository_food;

    //public final LiveData<ArrayList<DataModel_Food>> foodLiveData = Transformations.switchMap();


    public ViewModel_SetMeal(@NonNull Application application) {
        super(application);

        repository_meal = new Repository_Meal(application);
    }

    public ViewModel_SetMeal(@NonNull Application application, Repository_Meal repository_meal, Repository_Food repository_food) {
        super(application);
        this.repository_meal = repository_meal;
        this.repository_food = repository_food;

        //if(dataModel_meals.get(i).getMealTime() == 1 )
    }

    // meal confirmed

    public void foodToMeal(View view){
        //change food to meal and upload to DB
    }

    // activity_SetMeal binding method
    public void addMealTime(View view){
        //push list and notify to adapter
    }
    public void savePreset(View view){
        //insert database
    }
    public void loadPreset(View view){
        // select database
    }
    //end

    //adapter_setMeal binding method
    public void deleteMealTime(View view){

    }
    public void addFood(View view){

    }
    //end

    //adapter_setFood binding method
    public void deleteFood(View view){

    }
    //end
}
