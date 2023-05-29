package com.anonymous.mealmate.viewmodel;

import android.app.Application;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.anonymous.mealmate.feature.ControlViewState;
import com.anonymous.mealmate.feature.Date;
import com.anonymous.mealmate.model.entity.Food;
import com.anonymous.mealmate.model.entity.Meal;
import com.anonymous.mealmate.model.repository.MealRepository;

import java.util.List;

public class MealCheckViewModel extends AndroidViewModel {
    private final MealRepository mealRepository;
    private final LiveData<List<Meal>> allMeals;

    private final MutableLiveData<String> dateLiveData = new MutableLiveData<>();

    public LiveData<String> getDateLiveData(){
        return dateLiveData;
    }

    public MealCheckViewModel (Application application) {
        super(application);
        mealRepository = MealRepository.getInstance(application);

        /*repository = new MealRepository(application);*/
        allMeals = mealRepository.getAllMeals();

        //날짜가 바뀌면 자동으로 meal data를 날짜에 맞는 데이터로 바꿔줌
        dateLiveData.setValue(Date.getInstance().getDateToString());
    }


    public LiveData<List<Meal>> getAllMeals() { return allMeals; }

    public void insert(Meal meal) { mealRepository.insertMeal(meal); }

//    public void insert(){
//        mealRepository.insertMeal(new Meal("230524",0));
//    }

    public void update(Meal meal) { mealRepository.updateMeal(meal); }

    public void delete(Meal meal) { mealRepository.deleteMeal(meal); }


    //binding method, do not erase
    public void onLoadMeal(View view) {
        String selectedDateTime = Date.getInstance().getDateToString();
        //mealRepository.insertMeal(new Meal(selectedDateTime,0));
    }
    public void onLoadMealBySelectedDate(){
        String selectedDate = Date.getInstance().getDateToString();
        // mealRepository.getMealsByDate(selectedDate);
    }

    public String getFoodListToString(Meal meal){
        String str="";
        Food food = null;
        for(int i=0; i<meal.getFoodList().size();i++) {
            food = meal.getFoodList().get(i);
            str +=i+". "+food.getFoodName()+"\n";
        }
        return str;
    }


    //binding method
    public void onMealChecked(Meal meal){
        //체크 변경 method
        if(meal.getChecked()==Meal.CHECKED)
            meal.setChecked(Meal.UNCHECKED);
        else if(meal.getChecked()==Meal.UNCHECKED)
            meal.setChecked(Meal.CHECKED);

        //mealRepository.updateMeal(meal);
    }


    public void onDateChanged( int year, int month, int dayOfMonth){
        //날짜를 전달받아 repository에 알리는 메소드
        Toast.makeText(getApplication().getApplicationContext(), "test",Toast.LENGTH_SHORT).show();
        //Date date = Date.getInstance();
        //date.set(month,dayOfMonth,dayOfWeek);
        //repository에 날짜 전달하여 liveData 갱신하는 메소드
        //mealRepository.setMealDate(date.getDateToString());
    }

    public void onChangeMealPlan(){
        ControlViewState.getInstance().activeIntentSignal(ControlViewState.INTENT_MAIN_TO_SETMEAL);
    }


//    @BindingAdapter("app:colorChanged")
//    public static void colorChanged(View view, Boolean checked){
//        // 식사 체크 여부 확인하여 drawble바꿔주는 바인딩 어댑터
//        //view.setBackgroundResource( checked ? R.drawable.btn_back : R.drawable.btn_cancle) ;
//    }

}
