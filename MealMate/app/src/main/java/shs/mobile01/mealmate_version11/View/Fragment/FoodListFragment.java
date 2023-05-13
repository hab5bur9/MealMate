package shs.mobile01.mealmate_version11.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

import shs.mobile01.mealmate_version11.R;
import shs.mobile01.mealmate_version11.View.Adapter.FoodAdapter;

public class FoodListFragment extends Fragment {


    private View foodListFragment;


    ArrayList<String> sampleFood1 = new ArrayList<>(Arrays.asList("닭가슴살","20","80","20","100"));
    ArrayList<String> sampleFood2 = new ArrayList<>(Arrays.asList("삼겹살", "20","30","50","200"));
    ArrayList<String> sampleFood3 = new ArrayList<>(Arrays.asList("흰쌀밥","60","10","30","150"));
    ArrayList<ArrayList> food = new ArrayList<>(Arrays.asList(sampleFood1,sampleFood2,sampleFood3));

    public FoodListFragment(){

    }
    public FoodListFragment(Context context){
        // 어디서 생성된 프래그먼트인지 검사
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        foodListFragment = inflater.inflate(R.layout.fragment_foodlist,container,false);

        FoodAdapter fa = new FoodAdapter(food);
        ((ListView)foodListFragment.findViewById(R.id.listView_food)).setAdapter(fa);


        return foodListFragment;
    }
}