package shs.mobile01.mealmate_version11.viewModel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.Model.dao.Repository_Food;
import shs.mobile01.mealmate_version11.Model.dao.Repository_Meal;
import shs.mobile01.mealmate_version11.Model.dto.DataModel_Food;
import shs.mobile01.mealmate_version11.Model.dto.DataModel_Meal;

public class ViewModel_SetMeal extends ViewModel {
    private ArrayList<DataModel_Meal> dataModel_meals = new ArrayList<>();
    private Repository_Meal repository_meal;
    private Repository_Food repository_food;


    private MutableLiveData<ArrayList<DataModel_Food>> foodLiveData;


    // open test data
    DataModel_Food dm;
    ArrayList<DataModel_Food>testData1,testData2,testData3;
    ArrayList<ArrayList<DataModel_Food>> testData;

    public void loadPreset(){
        dm = new DataModel_Food(1,1,"food",100,100,100,300,0);
        testData1 = new ArrayList<>(Arrays.asList(dm,dm,dm,dm));
        testData2 = new ArrayList<>(Arrays.asList(dm,dm,dm,dm));
        testData3 = new ArrayList<>(Arrays.asList(dm,dm,dm,dm));
        testData= new ArrayList<>(Arrays.asList(testData1,testData2,testData3)); ;

    }
    // close test data

    public ViewModel_SetMeal(Repository_Meal repository_meal, Repository_Food repository_food ){
        this.repository_meal = repository_meal;
        this.repository_food = repository_food;
    }

    // activity_SetMeal binding method
    public void addMealTime(View view){

    }
    public void savePreset(View view){

    }
    public void loadPreset(View view){

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
