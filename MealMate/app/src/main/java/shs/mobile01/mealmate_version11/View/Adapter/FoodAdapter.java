package shs.mobile01.mealmate_version11.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import shs.mobile01.mealmate_version11.Model.entity.Food;
import shs.mobile01.mealmate_version11.R;
import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{
    // ViewModel의 liveData를 출력하기 위한 어댑터
    private final int LayoutName = R.layout.adapter_food;

    private List<Food> list = new ArrayList<>();

    public FoodAdapter(){
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(LayoutName,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList list){
        // liveData observe listener 호출될 때 마다 호출되어 adapter의 list를 업데이트 해주는 method
        this.list=list;
        // notifyDataSetChanged 메서드는 어댑터를 초기화하고 다시생성하는 것이라 효율이 안좋으므로 추후에 수정 필요
        notifyDataSetChanged();
    }
}





// 더미 데이터
//public class FoodAdapter extends BaseAdapter {
//    private View ex;
//    private ArrayList<ArrayList> list;
//    public FoodAdapter(ArrayList<ArrayList> _list) {
//        list = _list;
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ex = View.inflate(parent.getContext(), R.layout.adapter_food,null);
//        return ex;
//    }
//}
