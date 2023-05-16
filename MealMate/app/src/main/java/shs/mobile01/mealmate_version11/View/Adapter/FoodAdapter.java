package shs.mobile01.mealmate_version11.View.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import shs.mobile01.mealmate_version11.R;
import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{

    ArrayList<FoodAdapter> list ;

    public FoodAdapter(ArrayList list ){
        this.list= list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

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
