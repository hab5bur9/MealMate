package com.anonymous.mealmate.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.anonymous.mealmate.R;
import com.anonymous.mealmate.model.entity.Meal;
import com.anonymous.mealmate.viewmodel.MealCheckViewModel;


public class MealAdapter extends ListAdapter<Meal,MealAdapter.MealViewHolder>{


    public static class MealViewHolder extends RecyclerView.ViewHolder{
        private TextView tvMealInfo;
        private LinearLayout llMealMenu;
        private Button btnMealCheck;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMealInfo = itemView.findViewById(R.id.tv_meal_info);
            llMealMenu = itemView.findViewById(R.id.ll_meal_menu);
            btnMealCheck = itemView.findViewById(R.id.btn_meal_check);
        }
        public void bind(Meal meal){
            // 모두 수정 필요
            // data setting method
            tvMealInfo.setText("1번째 끼니");
            //meal 에서 음식정보를 찾아오는 로직 필요

            //테이블이 약간 이상하다
            TextView testText = new TextView(llMealMenu.getContext());
            testText.setText("1. Test Data");

            // list의 옵션 삭제시 뷰가 안사라지고 계속 add되고 있음 수정필요
            llMealMenu.addView(testText);
        }

        public static MealViewHolder onCreate(ViewGroup parent){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_meal, parent,false);
            return new MealViewHolder(view);
        }
    }
    public MealAdapter(@NonNull DiffUtil.ItemCallback<Meal> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MealViewHolder.onCreate(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal currentMeal = getItem(position);
        holder.bind(currentMeal);
        holder.btnMealCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //notifyItemRemoved(position);
            }
        });
    }
    public static class MealDiff extends DiffUtil.ItemCallback<Meal>{
        @Override
        public boolean areItemsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
            return oldItem.getMealIndex()==newItem.getMealIndex();
        }
    }

    public Meal getItemTest(int position){
        return getItem(position);
    }
}
//public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder> {
//    // ViewModel의 liveData를 출력하기 위한 어댑터
//    private final int layoutName = R.layout.adapter_meal;
//
//
//    private OnItemClickListener listener;
//
//    private List<Meal> list = new ArrayList<>();
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        Button btnCheck;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            btnCheck = itemView.findViewById(R.id.btn_meal_check);
//
//            //check event
//            btnCheck.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
////                    if (listener != null && position = RecyclerView.NO_POSITION) {
////                        listener.onItemClick(list.get(position));
////                    }
//                }
//            });
//        }
//    }
//
//    public interface OnItemClickListener {
//        void onItemClick(Meal meal);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.listener = listener;
//    }
//
//
//    @NonNull
//    @Override
//    public MealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(layoutName, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MealAdapter.ViewHolder holder, int position) {
//        holder.btnCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public void setList(List<Meal> list) {
//        this.list = list;
//        notifyDataSetChanged();
//    }
//}
