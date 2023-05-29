package com.anonymous.mealmate.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.anonymous.mealmate.R;
import com.anonymous.mealmate.databinding.FragmentFoodBinding;
import com.anonymous.mealmate.feature.ControlViewState;
import com.anonymous.mealmate.model.entity.Food;
import com.anonymous.mealmate.view.adapter.FoodAdapter;
import com.anonymous.mealmate.viewmodel.FoodViewModel;

import java.util.List;

public class FoodActivity extends AppCompatActivity {
    private FragmentFoodBinding binding;

    private FoodViewModel foodViewModel;

    RecyclerView mRecyclerView;
    FoodAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);
        binding = FragmentFoodBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);
        binding.setFoodViewModel(foodViewModel);


        //recycler view
        mRecyclerView = binding.rvFoodSearch;
        mAdapter = new FoodAdapter(new FoodAdapter.FoodDiff(),foodViewModel, this);
        mRecyclerView.setAdapter(mAdapter);
        //recycler view end


        //observer setup
        foodViewModel.getAllFoods().observe(this, new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foods) {
                //observe 함수 작성
                mAdapter.submitList(foods);
                //testing toast message
                Toast.makeText(FoodActivity.this, "foodListAcessComplete!!", Toast.LENGTH_SHORT).show();
            }
        });

        ControlViewState.getInstance().getIntentSignalLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {

            }
        });


        Intent intent = getIntent();
    }
}
