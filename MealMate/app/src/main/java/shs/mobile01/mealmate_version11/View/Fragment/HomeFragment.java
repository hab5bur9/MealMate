package shs.mobile01.mealmate_version11.View.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.Model.entity.Meal;
import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Activity.MainActivity;
import shs.mobile01.mealmate_version11.View.Adapter.MealAdapter;
import shs.mobile01.mealmate_version11.databinding.ActivityMainBinding;
import shs.mobile01.mealmate_version11.databinding.FragmentHomeBinding;
import shs.mobile01.mealmate_version11.viewModel.ViewModel_CheckMeal;

public class HomeFragment extends Fragment {

    private View view;

    private ViewModel_CheckMeal viewModelCheckMeal;

    private MealAdapter mAdapter;

    private RecyclerView mRecyclerView;

    //test
    FragmentHomeBinding binding;

    public HomeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);



        view = inflater.inflate( R.layout.fragment_home,container,false);

        ((TextView)view.findViewById(R.id.dateTimeTextView)).setText("00월 00일 0요일");

        // 직접연결된 뷰가아니라 에러 날수도 있음 xml 안에 include 된 view 의 id를 참조하는중
        //recycler view setup
        mRecyclerView = view.findViewById(R.id.recyclerView_MealList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.scrollToPosition(((LinearLayoutManager)mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition());

        mAdapter = new MealAdapter();
        mRecyclerView.setAdapter(mAdapter);
        // recycler view set end

        //adapter check Event Override
        mAdapter.setOnItemClickListener(new MealAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Meal meal) {
                viewModelCheckMeal.onChecked(meal);
            }
        });


        // observer part
        //viewModel_checkMeal = ViewModelProviders.of(this).get(ViewModel_CheckMeal.class);
        viewModelCheckMeal = new ViewModelProvider(this).get(ViewModel_CheckMeal.class);
        viewModelCheckMeal.getMealListLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<Meal>>() {
            @Override
            public void onChanged(ArrayList<Meal> meals) {
                //test
                mAdapter.setList(meals);

                //testing toast message
                Toast.makeText(getContext(), "test success", Toast.LENGTH_SHORT).show();
            }
        });
        // observer end

        return view;
    }
}
