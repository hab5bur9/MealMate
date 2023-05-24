package shs.mobile01.mealmate_version11.viewModel;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBinderMapperImpl;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import shs.mobile01.mealmate_version11.Model.dao.Repository_Meal;
import shs.mobile01.mealmate_version11.Model.entity.Meal;

public  class ViewModel_CheckMeal extends AndroidViewModel { // extends AndroidViewModel ??
    private Repository_Meal repository_meal;

    private LiveData<ArrayList<Meal>> mealListLiveData;


    public ViewModel_CheckMeal(@NonNull Application application) {
        super(application);
        repository_meal = new Repository_Meal(application);

        mealListLiveData = repository_meal.getListLiveData();
    }
    public LiveData<ArrayList<Meal>> getMealListLiveData(){
        return mealListLiveData;
    }


//    @BindingAdapter("app:onChecked")
    public void onChecked(Meal meal){
        repository_meal.testDeleteMeal(meal);

    }



}
