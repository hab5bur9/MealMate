package shs.mobile01.mealmate_version11.View.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import shs.mobile01.mealmate_version11.Model.entity.Meal;
import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Adapter.MealAdapter;
import shs.mobile01.mealmate_version11.viewModel.MealSetViewModel;

public class CalendarFragment extends Fragment {

    private View view;

    private MealSetViewModel mealCheckViewModel;

    private RecyclerView mRecyclerView;

    private final MealAdapter mAdapter = new MealAdapter();

    public CalendarFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calendar, container, false);

        ((CalendarView) view.findViewById(R.id.cv_meal_info)).setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String datetime = "" + month + "월 " + dayOfMonth + "일";


            }
        });


        //recycler view set up
        mRecyclerView = view.findViewById(R.id.rv_meal_loading);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.scrollToPosition(((LinearLayoutManager)mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());

        mRecyclerView.setAdapter(mAdapter);
        //recycler view set end


        // observer setup
        mealCheckViewModel = new ViewModelProvider(this).get(MealSetViewModel.class);
        mealCheckViewModel.getAllMeals().observe(getViewLifecycleOwner(), new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> meals) {
                mAdapter.setList(meals);

                //testing toast message
                Toast.makeText(getContext(), "calendar fragment access complete", Toast.LENGTH_SHORT).show();
            }
        });

        // observer end
        return view;
    }
}
