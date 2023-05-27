package com.anonymous.mealmate.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.anonymous.mealmate.model.entity.Meal;
import com.anonymous.mealmate.model.repository.MealRepository;

import java.util.List;

public class MealCheckViewModel extends AndroidViewModel {
    private final MealRepository mealRepository;
    private final LiveData<List<Meal>> allMeals;

    public MealCheckViewModel (Application application) {
        super(application);
        mealRepository = MealRepository.getInstance(application);

        /*repository = new MealRepository(application);*/
        allMeals = mealRepository.getAllMeals();
    }

    public LiveData<List<Meal>> getAllMeals() { return allMeals; }

    public void insert(Meal meal) { mealRepository.insertMeal(meal); }

    public void update(Meal meal) { mealRepository.updateMeal(meal); }

    public void delete(Meal meal) { mealRepository.deleteMeal(meal); }

}
