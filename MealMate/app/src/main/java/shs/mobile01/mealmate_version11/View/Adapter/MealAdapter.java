package shs.mobile01.mealmate_version11.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import shs.mobile01.mealmate_version11.Model.dto.DataModel_Meal;
import shs.mobile01.mealmate_version11.R;
import java.util.ArrayList;


public class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder> {

    private final int layoutName = R.layout.adapter_meal;

    private ArrayList<DataModel_Meal> list;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        Button btnCheck;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnCheck = itemView.findViewById(R.id.btnCheck);

        }
    }

    public MealAdapter(ArrayList<DataModel_Meal> list ){
        this.list=list;
    }
    @NonNull
    @Override
    public MealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutName,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealAdapter.ViewHolder holder, int position) {
        holder.btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
//public class MealAdapter extends BaseAdapter {
//    private View ex;
//    private Context context;
//    private int layoutName = R.layout.adapter_meal;
//
//
//    private ArrayList<ArrayList> list; // 리스트 비어있을시 exception 발생 코드 작성필요
//
//    public MealAdapter() {
//    }
//
//    public MealAdapter(Context _context){
//        context=_context;
//    }
//
//    public MealAdapter(ArrayList<ArrayList> _list,int _layoutName){
//        list = _list;
//        layoutName=_layoutName;
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
//        ex = View.inflate(parent.getContext(), layoutName,null);
//
//        ArrayList<String> str = list.get(position);
//        ((TextView)ex.findViewById(R.id.foodList)).setText(makeText(list.get(position)));
//        ((Button)ex.findViewById(R.id.btnCheck)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(parent.getContext(),""+ (position+1),Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        return ex;
//    }
//    private String makeText(ArrayList<String> data){
//        String str="";
//        for(int i=0;i<data.size();i++){
//            str+=data.get(i)+"\n";
//        }
//        return str;
//    }
//}
