package shs.mobile01.mealmate_version11.View.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.Model.entity.Meal;
import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Adapter.MealAdapter;
import shs.mobile01.mealmate_version11.viewModel.ViewModel_CheckMeal;

public class CalendarFragment extends Fragment {

    private View view;

    private ViewModel_CheckMeal viewModelCheckMeal;

    private RecyclerView mRecyclerView;

    private MealAdapter mAdapter;

    public CalendarFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calendar, container, false);

        ((CalendarView) view.findViewById(R.id.calendarView)).setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String datetime = "" + month + "월 " + dayOfMonth + "일";


            }
        });


        //recycler view set up
        mRecyclerView = view.findViewById(R.id.recyclerView_MealList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.scrollToPosition(((LinearLayoutManager)mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());

        mAdapter = new MealAdapter();
        mRecyclerView.setAdapter(mAdapter);
        //recycler view set end


        // observer setup
        viewModelCheckMeal = new ViewModelProvider(this).get(ViewModel_CheckMeal.class);
        viewModelCheckMeal.getMealListLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Meal>>() {
            @Override
            public void onChanged(ArrayList<Meal> meals) {
                mAdapter.setList(meals);

                //testing toast message
                Toast.makeText(getContext(), "calendar fragment access complete", Toast.LENGTH_SHORT).show();
            }
        });

        // observer end
        return view;
    }
}
