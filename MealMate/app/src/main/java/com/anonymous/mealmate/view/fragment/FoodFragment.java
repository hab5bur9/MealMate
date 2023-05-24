package com.anonymous.mealmate.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anonymous.mealmate.R;
import com.anonymous.mealmate.model.entity.Food;
import com.anonymous.mealmate.view.adapter.FoodAdapter;
import com.anonymous.mealmate.viewmodel.FoodViewModel;

import java.util.List;

public class FoodFragment extends Fragment {


    private View view;

    private FoodAdapter mAdapter;

    private RecyclerView mRecyclerView;

    private FoodViewModel viewModelFoodList;

    public FoodFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_food, container, false);

        //recycler view setup
        mRecyclerView = view.findViewById(R.id.rv_food_search);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.scrollToPosition(((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());

        mAdapter = new FoodAdapter();
        mRecyclerView.setAdapter(mAdapter);

        //recycler view end


        //observer setup
        viewModelFoodList = new ViewModelProvider(this).get(FoodViewModel.class);
        viewModelFoodList.getAllFoods().observe(getViewLifecycleOwner(), new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foods) {
                //observe 함수 작성
                mAdapter.setList(foods);

                //testing toast message
                Toast.makeText(getContext(), "foodListAcessComplete!!", Toast.LENGTH_SHORT).show();
            }
        });

        //observer end

        return view;
    }
}
