package shs.mobile01.mealmate_version11.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import shs.mobile01.mealmate_version11.Model.dao.Repository_Food;
import shs.mobile01.mealmate_version11.Model.entity.Food;

public class ViewModel_FoodList extends AndroidViewModel {
    private Repository_Food repository_food;

    private LiveData<ArrayList<Food>> foodListLiveData;


    public ViewModel_FoodList(@NonNull Application application) {
        super(application);
        repository_food = new Repository_Food(application);
        foodListLiveData = repository_food.getListLiveData();
    }

    public LiveData<ArrayList<Food>> getFoodListLiveData() {
        return foodListLiveData;
    }
}
