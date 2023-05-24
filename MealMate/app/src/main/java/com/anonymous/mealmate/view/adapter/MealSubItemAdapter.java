package com.anonymous.mealmate.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.anonymous.mealmate.R;
import com.anonymous.mealmate.model.entity.Food;

import java.util.ArrayList;
import java.util.List;

public class MealSubItemAdapter extends ListAdapter<Food,MealSubItemAdapter.MealSubItemViewHolder> {

    public static class MealSubItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMealSubItemInfo;
        private Button btnMealSubItemDelete;

        public MealSubItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMealSubItemInfo = itemView.findViewById(R.id.tv_meal_subItem_info);
            btnMealSubItemDelete = itemView.findViewById(R.id.btn_meal_subItem_delete);
        }

        public static MealSubItemViewHolder onCreate(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mealsubitem, parent, false);
            return new MealSubItemViewHolder(view);
        }

        public void bind(Food food) {
            tvMealSubItemInfo.setText(food.getFoodName());
        }
    }

    public MealSubItemAdapter() {
        super(new DiffUtil.ItemCallback<Food>() {
            @Override
            public boolean areItemsTheSame(@NonNull Food oldItem, @NonNull Food newItem) {
                //정확한 비교 수정필요
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Food oldItem, @NonNull Food newItem) {
                // 정확한 비교 수정필요
                return false;
            }
        });
    }

    @NonNull
    @Override
    public MealSubItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MealSubItemViewHolder.onCreate(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MealSubItemViewHolder holder, int position) {
        Food currentFood = getItem(position);
        holder.bind(currentFood);
        holder.btnMealSubItemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete Food
                //notifyItemRemoved(position);
            }
        });

    }


}
//public class MealSubItemAdapter extends RecyclerView.Adapter<MealSubItemAdapter.ViewHolder> {
//    // DB에 업로드 하기위한 메서드
//
//    private final int LayoutName = R.layout.adapter_mealsubitem;
//    public List<Food> list = new ArrayList<>();
//
//
//    public MealSubItemAdapter() {
//        //empty constructor
//    }
//
//    public MealSubItemAdapter(ArrayList<Food> list) {
//        this.list = list;
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private Button btnDelete;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            btnDelete = itemView.findViewById(R.id.btn_meal_subItem_delete);
//        }
//
//        public Button getBtnDelete() {
//            return btnDelete;
//        }
//    }
//
//    @NonNull
//    @Override
//    public MealSubItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(LayoutName, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MealSubItemAdapter.ViewHolder holder, int position) {
//        holder.getBtnDelete().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (list.size() != 0) {
//                    list.remove(holder.getAdapterPosition());
//                    notifyDataSetChanged();
//                } else ; // 예외처리 작성
//            }
//        });
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public void setList(List list) {
//        this.list = list;
//    }
//}