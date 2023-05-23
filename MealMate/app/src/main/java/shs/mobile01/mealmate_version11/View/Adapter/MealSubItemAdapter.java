package shs.mobile01.mealmate_version11.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import shs.mobile01.mealmate_version11.Model.entity.Food;
import shs.mobile01.mealmate_version11.R;

public class MealSubItemAdapter extends RecyclerView.Adapter<MealSubItemAdapter.ViewHolder>{
    // DB에 업로드 하기위한 메서드

    private final int LayoutName = R.layout.adapter_mealsubitem;
    public List<Food> list = new ArrayList<>();


    public MealSubItemAdapter(){
        //empty constructor
    }
    public MealSubItemAdapter(ArrayList<Food> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private Button btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnDelete=itemView.findViewById(R.id.btn_meal_subItem_delete);
        }
        public Button getBtnDelete(){
            return btnDelete;
        }
    }

    @NonNull
    @Override
    public MealSubItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(LayoutName,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealSubItemAdapter.ViewHolder holder, int position) {
        holder.getBtnDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(list.size()!=0) {
                    list.remove(holder.getAdapterPosition());
                    notifyDataSetChanged();
                }else ; // 예외처리 작성
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List list){
        this.list=list;
    }
}

