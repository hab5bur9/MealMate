package shs.mobile01.mealmate_version11.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;


import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Adapter.SetFoodAdapter;
import shs.mobile01.mealmate_version11.View.Adapter.SetMealAdapter;
import shs.mobile01.mealmate_version11.viewModel.ViewModel_SetMeal;

public class SetMealActivity extends AppCompatActivity {

    private ViewModel_SetMeal viewModelSetMeal;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setmeal);


        //Get ViewModel
        viewModelSetMeal = new ViewModelProvider(this).get(ViewModel_SetMeal.class);

        Intent it = getIntent();

        SetMealAdapter mAdapter = new SetMealAdapter();
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView_setMeal);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.scrollToPosition(((LinearLayoutManager)mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());

    }

}
