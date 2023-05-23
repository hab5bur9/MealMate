package shs.mobile01.mealmate_version11.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;


import shs.mobile01.mealmate_version11.Model.entity.Food;
import shs.mobile01.mealmate_version11.Model.repository.FoodRepository;

public class FoodViewModel extends AndroidViewModel {
    private final FoodRepository foodRepository;
    private final LiveData<List<Food>> allFoods;
    private final MutableLiveData<Food> clickedFood = new MutableLiveData<>();

    public FoodViewModel (Application application) {
        super(application);
        foodRepository = FoodRepository.getInstance(application);
        //repository = new FoodRepository(application);
        allFoods = foodRepository.getAllFoods();
    }

    public LiveData<List<Food>> getAllFoods() { return allFoods; }

    public void insert(Food food) { foodRepository.insertFood(food); }

    public void update(Food food) { foodRepository.updateFood(food); }

    public void delete(Food food) { foodRepository.deleteFood(food); }

    // 특정 음식의 좋아요 여부를 가져옵니다.
    public LiveData<List<Food>> getLikedFoods() { return foodRepository.getLikedFoods(); }


    public void setClickedFood(Food food) {clickedFood.setValue(food);}
    public LiveData<Food> getClickedFood() {return clickedFood;}
}
