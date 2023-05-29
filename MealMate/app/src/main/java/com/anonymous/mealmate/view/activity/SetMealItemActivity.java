package com.anonymous.mealmate.view.activity;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< Updated upstream
import android.widget.Button;
=======
import android.view.LayoutInflater;
>>>>>>> Stashed changes

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anonymous.mealmate.R;
import com.anonymous.mealmate.model.entity.Food;
import com.anonymous.mealmate.view.adapter.MealItemAdapter;
import com.anonymous.mealmate.viewmodel.MealCheckViewModel;
import com.anonymous.mealmate.viewmodel.MealSetViewModel;

import java.util.ArrayList;
import java.util.List;

public class SetMealItemActivity extends AppCompatActivity {

    private MealSetViewModel mealSetViewModel;
    private MealCheckViewModel mealCheckViewModel;
    private Button btnMealAdd;

    private MutableLiveData<List<List>> liveData = new MutableLiveData<>();
    private List<List> setMealItems = new ArrayList<>();
    private List<Food> testList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setmealitem);

        setMealItems.add(testList);
        liveData.postValue(setMealItems);

        //Get ViewModel
        mealSetViewModel = new ViewModelProvider(this).get(MealSetViewModel.class);
        mealCheckViewModel = new ViewModelProvider(this).get(MealCheckViewModel.class);

        Intent it = getIntent();

        MealItemAdapter mAdapter = new MealItemAdapter(new MealItemAdapter.MealItemDiff(),setMealItems);

        RecyclerView mRecyclerView = findViewById(R.id.rv_meal_setting);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.scrollToPosition(((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());


        liveData.observe(this, new Observer<List<List>>() {
            @Override
            public void onChanged(List<List> lists) {
                //data 갱신
                mAdapter.submitList(lists);
            }
        });

        //event

        btnMealAdd = findViewById(R.id.btn_meal_add);
        btnMealAdd.setOnClickListener(view ->{
                setMealItems.add(testList);
                liveData.setValue(setMealItems);
        });

<<<<<<< Updated upstream
=======
        //intent state observer
        ControlViewState.getInstance().getStateSignalLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer signal) {
                Intent intent = new Intent();
                switch(signal){
                    case ControlViewState.INTENT_SETMEAL_TO_FOOD :
                        intent = new Intent(SetMealItemActivity.this,FoodActivity.class);
                        startActivity(intent);
                }
            }
        });
>>>>>>> Stashed changes
    }

}
