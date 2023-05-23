package shs.mobile01.mealmate_version11.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


import shs.mobile01.mealmate_version11.Model.entity.Food;
import shs.mobile01.mealmate_version11.R;

public class MealItemAdapter extends RecyclerView.Adapter<MealItemAdapter.ViewHolder> {
    // 호출 순서 1. 생성자로 데이터 입력받기 2. getItemCount()로 생성할 뷰의 개수 파악 3. onCreateViewHolder()로 뷰를 count 수 만큼 생성
    public List<List<Food>> list  = new ArrayList<>(); // 테스트 list 추후에 변경



    public static class ViewHolder extends RecyclerView.ViewHolder{
        // 이벤트 리스너 할당등 코드를 모아놓음
        private RecyclerView rv;
        private Button btnCreate;
        private Button btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv =  itemView.findViewById(R.id.rv_meal_subItem);
            rv.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            rv.scrollToPosition(((LinearLayoutManager)rv.getLayoutManager()).findFirstCompletelyVisibleItemPosition());

            btnCreate = itemView.findViewById(R.id.btn_meal_subItem_add);
            btnDelete = itemView.findViewById(R.id.btn_meal_item_delete);

        }
        public RecyclerView getRv() {
            return rv;
        }
        public Button getBtnCreate(){
            return btnCreate;
        }

        public Button getBtnDelete() {
            return btnDelete;
        }
    }

    public MealItemAdapter( ){//constructor 생성자, 데이터 리스트 받음

    }


    @NonNull
    @Override
    public MealItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mealitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealItemAdapter.ViewHolder holder, int position) {
        MealSubItemAdapter sfa = new MealSubItemAdapter();
        holder.getRv().setAdapter(sfa);

        holder.getBtnDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });

        holder.getBtnCreate().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //test
                //sfa.list.add(new DataModel_Food(1,1,"food",100,100,100,300,0));
                sfa.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        // 리사이클러 뷰의 인덱스 개수 만큼 생성받기 위한 리턴
        return list.size();
    }
    public void setList(List<List<Food>> list){
        this.list = list;
    }
}
