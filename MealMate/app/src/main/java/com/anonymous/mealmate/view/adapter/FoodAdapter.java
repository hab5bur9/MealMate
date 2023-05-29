package com.anonymous.mealmate.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.anonymous.mealmate.R;
import com.anonymous.mealmate.databinding.AdapterFoodBinding;
import com.anonymous.mealmate.databinding.AdapterMealitemBinding;
import com.anonymous.mealmate.databinding.FragmentFoodBinding;
import com.anonymous.mealmate.model.entity.Food;
import com.anonymous.mealmate.viewmodel.FoodViewModel;

import java.util.List;


public class FoodAdapter extends ListAdapter<Food,FoodAdapter.FoodViewHolder>{
    //lifecycle 순서 - > 생성자 실행후 -> onCreateViewHolder  -> FoodViewHolder 생성자 실행후 hold 메모리에 유지
    // -> item list 갱신 받고  onBindViewHolder 하여 item별로 기능 차이 설정 position 값을 이용해 item구분
    private FoodViewModel foodViewModel;
    private LifecycleOwner lifecycleOwner;




    public FoodAdapter(@NonNull DiffUtil.ItemCallback<Food> diffCallback, FoodViewModel foodViewModel, LifecycleOwner lifecycleOwner) {
        super(diffCallback);
        this.foodViewModel = foodViewModel;
        this.lifecycleOwner = lifecycleOwner;
    }

    public void setFoods(List<Food> foods) {
        submitList(foods);
    }

    public static class FoodDiff extends DiffUtil.ItemCallback<Food> {

        @Override
        public boolean areItemsTheSame(@NonNull Food oldItem, @NonNull Food newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Food oldItem, @NonNull Food newItem) {
            return oldItem.equals(newItem);
        }
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder{

        private AdapterFoodBinding binding;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

        }
        public FoodViewHolder(@NonNull AdapterFoodBinding binding){
            super(binding.getRoot());
            this.binding=binding;

        }
        public void bind(Food food){


            binding.setFood(food);
        }
        private AdapterFoodBinding getBinding(){
            return binding;
        }

    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //binding에 viewModel 연결하고, lifecycleOwner 설정해주고 리턴, ViewHolder 생성
        AdapterFoodBinding binding = AdapterFoodBinding.inflate(LayoutInflater.from(parent.getContext()));
        binding.setLifecycleOwner(lifecycleOwner);
        binding.setFoodViewModel(foodViewModel);

        return new FoodViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food currentFood = getItem(position);
        //holder.bind(currentFood);
        holder.binding.setFood(currentFood);    //
        holder.binding.executePendingBindings();

        //테스트 시에 여기다 item view 의 eventListener 생성 이후 databinding 후에 view model 로 mothod 옮겨 작성
    }
}