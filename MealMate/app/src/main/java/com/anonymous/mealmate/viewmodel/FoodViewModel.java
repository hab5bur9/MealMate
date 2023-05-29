package com.anonymous.mealmate.viewmodel;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.anonymous.mealmate.feature.ControlViewState;
import com.anonymous.mealmate.model.entity.Food;
import com.anonymous.mealmate.model.repository.FoodApiRepository;
import com.anonymous.mealmate.model.repository.FoodRepository;

import java.util.List;

public class FoodViewModel extends AndroidViewModel {
    private final FoodRepository foodRepository;
    private final FoodApiRepository foodApiRepository;

    private final LiveData<List<Food>> allFoods;
    private final MutableLiveData<Food> clickedFood = new MutableLiveData<>();

    public FoodViewModel (Application application) {
        super(application);
        foodRepository = FoodRepository.getInstance(application);
        foodApiRepository = FoodApiRepository.getInstance(application);

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



    //xml binding method, do not erase
    //binding Text complete, enable to user
    public void onSearchFood(View view, String inputFoodName){
        //Food Name 전달 받아 repository에 데이터 요청하는 메소드
        //db search logic
        //TODO 레파지토리에 food 검색 기능 연결
        //foodRepository.searchFood(foodName);


        //test
        Toast.makeText(view.getContext(), inputFoodName, Toast.LENGTH_SHORT).show();
        foodRepository.insertFood(new Food(inputFoodName));
        //String foodName = ((EditText)view).getText().toString();
    }


    //xml binding method, do not erase
    public void onLikeStateChange(Food food){
        //Food Adapter에 하트 버튼을 눌렀을때 Food db를 업데이트 해주는 메서드
        if(food.getFoodLike() == Food.FOOD_NOT_LIKE)
            food.setFoodLike(Food.FOOD_LIKE);
        else if(food.getFoodLike() == Food.FOOD_LIKE) {
            food.setFoodLike(Food.FOOD_NOT_LIKE);
        }
        //db upload
        //foodRepository.updateFood(food);

        //test
    }
    public void onDeleteFood(Food food){
        foodRepository.deleteFood(food);
    }

    public void onAddFood(Food food){
        ControlViewState.getInstance().activeIntentSignal(ControlViewState.INTENT_FINISH);
        Toast.makeText(getApplication().getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
    }
}
