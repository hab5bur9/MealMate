package shs.mobile01.mealmate_version11.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import shs.mobile01.mealmate_version11.Model.entity.Meal;
import shs.mobile01.mealmate_version11.Model.repository.MealRepository;

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
