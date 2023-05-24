package com.anonymous.mealmate.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anonymous.mealmate.R;
import com.anonymous.mealmate.view.adapter.MealItemAdapter;
import com.anonymous.mealmate.viewmodel.MealSetViewModel;

public class SetMealItemActivity extends AppCompatActivity {

    private MealSetViewModel viewModelSetMeal;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setmealitem);


        //Get ViewModel
        viewModelSetMeal = new ViewModelProvider(this).get(MealSetViewModel.class);

        Intent it = getIntent();

        MealItemAdapter mAdapter = new MealItemAdapter();
        RecyclerView mRecyclerView = findViewById(R.id.rv_meal_setting);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.scrollToPosition(((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());

    }

}
