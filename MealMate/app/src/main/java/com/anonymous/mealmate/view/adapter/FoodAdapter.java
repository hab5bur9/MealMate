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



public class FoodAdapter extends ListAdapter<Food,FoodAdapter.FoodViewHolder>{

    public FoodAdapter(@NonNull DiffUtil.ItemCallback diffCallback) {
        super(diffCallback);
    }
    public static class FoodDiff extends DiffUtil.ItemCallback<Food> {

        @Override
        public boolean areItemsTheSame(@NonNull Food oldItem, @NonNull Food newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Food oldItem, @NonNull Food newItem) {
            return oldItem.getFoodName().equals(newItem.getFoodName());
        }
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder{

        private TextView tvFoodName;
        private Button btnFoodLike;
        private TextView tvFoodNutritionCarbohydrate;
        private TextView tvFoodNutritionProtein;
        private TextView tvFoodNutritionFat;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            //view 할당, 초기 1회 실행
            tvFoodName=itemView.findViewById(R.id.tv_food_name);
            btnFoodLike=itemView.findViewById(R.id.btn_food_like);
            tvFoodNutritionCarbohydrate=itemView.findViewById(R.id.tv_food_nutrition_carbohydrate);
            tvFoodNutritionProtein=itemView.findViewById(R.id.tv_food_nutrition_protein);
            tvFoodNutritionFat =itemView.findViewById(R.id.tv_food_nutrition_fat);
        }
        public void bind(Food food){
            // view data 갱신
            tvFoodName.setText(food.getFoodName());
            tvFoodNutritionCarbohydrate.setText(""+food.getFoodCarbohydrates());
            tvFoodNutritionProtein.setText(""+food.getFoodProtein());
            tvFoodNutritionFat.setText(""+food.getFoodFat());
        }

        public static FoodViewHolder onCreate(ViewGroup parent){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_food, parent,false);
            return new FoodViewHolder(view);
        }

    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return FoodViewHolder.onCreate(parent);
    }


    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food currentFood = getItem(position);
        holder.bind(currentFood);

        //테스트 시에 여기다 item view 의 eventListener 생성 이후 databinding 후에 view model 로 mothod 옮겨 작성
    }
}
//public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
//    // ViewModel의 liveData를 출력하기 위한 어댑터
//    private final int LayoutName = R.layout.adapter_food;
//    private List<Food> list = new ArrayList<>();
//
//    public FoodAdapter() {
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }
//    }
//
//    @NonNull
//    @Override
//    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(LayoutName, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public void setList(List list) {
//        // liveData observe listener 호출될 때 마다 호출되어 adapter의 list를 업데이트 해주는 method
//        this.list = list;
//        // notifyDataSetChanged 메서드는 어댑터를 초기화하고 다시생성하는 것이라 효율이 안좋으므로 추후에 수정 필요
//        notifyDataSetChanged();
//    }
//}
