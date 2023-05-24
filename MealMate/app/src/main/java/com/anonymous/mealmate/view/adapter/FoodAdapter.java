package com.anonymous.mealmate.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anonymous.mealmate.R;
import com.anonymous.mealmate.model.entity.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    // ViewModel의 liveData를 출력하기 위한 어댑터
    private final int LayoutName = R.layout.adapter_food;
    private List<Food> list = new ArrayList<>();

    public FoodAdapter() {
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(LayoutName, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List list) {
        // liveData observe listener 호출될 때 마다 호출되어 adapter의 list를 업데이트 해주는 method
        this.list = list;
        // notifyDataSetChanged 메서드는 어댑터를 초기화하고 다시생성하는 것이라 효율이 안좋으므로 추후에 수정 필요
        notifyDataSetChanged();
    }
}
