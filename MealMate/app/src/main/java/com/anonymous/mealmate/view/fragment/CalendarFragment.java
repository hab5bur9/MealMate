package com.anonymous.mealmate.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< Updated upstream
import com.anonymous.mealmate.R;
=======
import com.anonymous.mealmate.databinding.FragmentCalendarBinding;
import com.anonymous.mealmate.feature.ControlViewState;
import com.anonymous.mealmate.feature.Date;
>>>>>>> Stashed changes
import com.anonymous.mealmate.model.entity.Meal;
import com.anonymous.mealmate.view.adapter.MealAdapter;
import com.anonymous.mealmate.viewmodel.MealCheckViewModel;
import com.anonymous.mealmate.viewmodel.MealSetViewModel;

import java.util.List;

public class CalendarFragment extends Fragment {

    private MealCheckViewModel mealCheckViewModel;
    private RecyclerView mRecyclerView;
    private MealAdapter mAdapter;

    public CalendarFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_calendar, container, false);

<<<<<<< Updated upstream
        // calendar view click event
        ((CalendarView) view.findViewById(R.id.cv_meal_info)).setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String datetime = "" + month + "월 " + dayOfMonth + "일";


            }
        });
=======
>>>>>>> Stashed changes

        mAdapter = new MealAdapter(new MealAdapter.MealDiff());
        //recycler view set up
        mRecyclerView = view.findViewById(R.id.rv_meal_loading);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.scrollToPosition(((LinearLayoutManager)mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());
        mRecyclerView.setAdapter(mAdapter);
        //recycler view set end

        // observer setup

        mealCheckViewModel = new ViewModelProvider(this).get(MealCheckViewModel.class);
        mealCheckViewModel.getAllMeals().observe(getViewLifecycleOwner(), new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> meals) {
                mAdapter.submitList(meals);

                //testing toast message
                //Toast.makeText(getContext(), "calendar fragment access complete", Toast.LENGTH_SHORT).show();
            }
        });

        ControlViewState.getInstance().getStateSignalLiveData().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                switch(integer){
                    case ControlViewState.DATE_CHANGED:
                        binding.includeMealList.includeDatetimeInfo.setDate(Date.getInstance());
                }
            }
        });

        // observer end


        return view;
    }
}
