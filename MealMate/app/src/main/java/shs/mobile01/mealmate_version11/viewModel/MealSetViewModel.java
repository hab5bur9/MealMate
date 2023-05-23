package shs.mobile01.mealmate_version11.viewModel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import java.util.List;

import shs.mobile01.mealmate_version11.Model.entity.Meal;
import shs.mobile01.mealmate_version11.Model.repository.FoodRepository;
import shs.mobile01.mealmate_version11.Model.repository.MealRepository;


public class MealSetViewModel extends AndroidViewModel {
    private final MealRepository mealRepository;
    private final FoodRepository foodRepository;
    private final LiveData<List<Meal>> allMeals;

    public MealSetViewModel(Application application) {
        super(application);
        mealRepository = MealRepository.getInstance(application);
        foodRepository = FoodRepository.getInstance(application);
        /*repository = new MealRepository(application);*/
        allMeals = mealRepository.getAllMeals();
    }

    public LiveData<List<Meal>> getAllMeals() { return allMeals; }

    public void insert(Meal meal) { mealRepository.insertMeal(meal); }

    public void update(Meal meal) { mealRepository.updateMeal(meal); }

    public void delete(Meal meal) { mealRepository.deleteMeal(meal); }
}
