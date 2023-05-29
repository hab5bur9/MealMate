package com.anonymous.mealmate.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.anonymous.mealmate.R;
import com.anonymous.mealmate.model.entity.Food;
import com.anonymous.mealmate.model.entity.Meal;

import java.util.ArrayList;
import java.util.List;


public class MealItemAdapter extends ListAdapter<List,MealItemAdapter.MealItemViewHolder>{
    //test용 2차원 리스트
    private List<List> setMealItems;

    public static class MealItemViewHolder extends RecyclerView.ViewHolder{


        // 이후 변수 변경이 없으므로 final 설정
        private final RecyclerView rvMealSubItem;
        private final MealSubItemAdapter mealSubItemAdapter;
        private final Button btnMealSubItemAdd;
        private final Button btnMealItemDelete;

        public MealItemViewHolder(@NonNull View itemView) {
            super(itemView);
            // inner adapter base setting : View hold
            mealSubItemAdapter = new MealSubItemAdapter();
            rvMealSubItem = itemView.findViewById(R.id.rv_meal_subItem);
            rvMealSubItem.setAdapter(mealSubItemAdapter);
            rvMealSubItem.setLayoutManager( new LinearLayoutManager(itemView.getContext()));

            btnMealSubItemAdd  = itemView.findViewById(R.id.btn_meal_subItem_add);
            btnMealItemDelete = itemView.findViewById(R.id.btn_meal_item_delete);
        }
        public void bind(List list,int position){
            //list 내부 자료형이 Food 가맞는지 확인해주는 검사 메소드 작성필요
            try {
                mealSubItemAdapter.submitList((List) list.get(position));
            }catch(Exception e ){
                Log.d("bind Error","take care of the value of lists type");
            }
        }

        public static MealItemViewHolder onCreate(ViewGroup parent){
            //view inflate : just one time , recycle at View holder
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mealitem, parent,false);
            return new MealItemViewHolder(view);
        }
    }
    public MealItemAdapter(@NonNull DiffUtil.ItemCallback<List> diffCallback,List<List> list) {
        super(diffCallback);
        setMealItems = list;
    }

    @NonNull
    @Override
    public MealItemAdapter.MealItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //초기 1회만 실행되서 ViewHolder 세팅시작하는 메서드
        return MealItemViewHolder.onCreate(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MealItemAdapter.MealItemViewHolder holder, int position) {
        //item 별 구분되는 기능 list item 개수만큼 호출됨
        List currentList = getItem(position);
        holder.bind(currentList,position);
        holder.btnMealSubItemAdd.setOnClickListener(v ->{
            currentList.add(new Food("사과",100,100,100,100, 100, "안녕"));
            //변경 필요 좀더 효율적인 notify
            holder.mealSubItemAdapter.submitList(currentList);
            //notifyItemRangeInserted(, 1);
        });
        holder.btnMealItemDelete.setOnClickListener(v ->{
            //이후 리스트 변경 안좋은코드 수정필요  임시 삭제이벤트
            setMealItems.remove(position);

            notifyItemRemoved(position);
        });
    }

//    public static class MealItemDiff extends DiffUtil.ItemCallback<Food>{
//        @Override
//        public boolean areItemsTheSame(@NonNull Food oldItem, @NonNull Food newItem) {
//            return oldItem==newItem;
//        }
//
//        @Override
//        public boolean areContentsTheSame(@NonNull Food oldItem, @NonNull Food newItem) {
//            return oldItem.getFoodIndex() == newItem.getFoodIndex();
//        }
//    }
    public static class MealItemDiff extends DiffUtil.ItemCallback<List>{
        @Override
        public boolean areItemsTheSame(@NonNull List oldItem, @NonNull List newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull List oldItem, @NonNull List newItem) {
            return false;
        }
    }


}
//public class MealItemAdapter extends RecyclerView.Adapter<MealItemAdapter.ViewHolder> {
//    // 호출 순서 1. 생성자로 데이터 입력받기 2. getItemCount()로 생성할 뷰의 개수 파악 3. onCreateViewHolder()로 뷰를 count 수 만큼 생성
//    public List<List<Food>> list = new ArrayList<>(); // 테스트 list 추후에 변경
//
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        // 이벤트 리스너 할당등 코드를 모아놓음
//        private RecyclerView rv;
//        private Button btnCreate;
//        private Button btnDelete;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            rv = itemView.findViewById(R.id.rv_meal_subItem);
//            rv.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
//            rv.scrollToPosition(((LinearLayoutManager) rv.getLayoutManager()).findFirstCompletelyVisibleItemPosition());
//
//            btnCreate = itemView.findViewById(R.id.btn_meal_subItem_add);
//            btnDelete = itemView.findViewById(R.id.btn_meal_item_delete);
//
//        }
//
//        public RecyclerView getRv() {
//            return rv;
//        }
//
//        public Button getBtnCreate() {
//            return btnCreate;
//        }
//
//        public Button getBtnDelete() {
//            return btnDelete;
//        }
//    }
//
//    public MealItemAdapter() {//constructor 생성자, 데이터 리스트 받음
//
//    }
//
//
//    @NonNull
//    @Override
//    public MealItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mealitem, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MealItemAdapter.ViewHolder holder, int position) {
//        MealSubItemAdapter sfa = new MealSubItemAdapter();
//        holder.getRv().setAdapter(sfa);
//
//        holder.getBtnDelete().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                list.remove(holder.getAdapterPosition());
//                notifyDataSetChanged();
//            }
//        });
//
//        holder.getBtnCreate().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //test
//                //sfa.list.add(new DataModel_Food(1,1,"food",100,100,100,300,0));
//                sfa.notifyDataSetChanged();
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        // 리사이클러 뷰의 인덱스 개수 만큼 생성받기 위한 리턴
//        return list.size();
//    }
//
//    public void setList(List<List<Food>> list) {
//        this.list = list;
//    }
//}
