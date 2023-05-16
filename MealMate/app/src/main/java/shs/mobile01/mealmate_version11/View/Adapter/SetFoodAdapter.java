package shs.mobile01.mealmate_version11.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import shs.mobile01.mealmate_version11.Model.dto.DataModel_Food;
import shs.mobile01.mealmate_version11.Model.dto.DataModel_Meal;
import shs.mobile01.mealmate_version11.R;

public class SetFoodAdapter extends RecyclerView.Adapter<SetFoodAdapter.ViewHolder>{
    public ArrayList<DataModel_Food> list;



    public SetFoodAdapter(ArrayList<DataModel_Food> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private Button btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnDelete=itemView.findViewById(R.id.btn_delete);
        }
        public Button getBtnDelete(){
            return btnDelete;
        }
    }

    @NonNull
    @Override
    public SetFoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_setfood,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SetFoodAdapter.ViewHolder holder, int position) {
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
}
//public class SetFoodAdapter extends ArrayAdapter {
//    private View ex ;
//    ArrayList<ArrayList> list = new ArrayList<>();
//
//    public SetFoodAdapter(@NonNull Context context, int resource) {
//        super(context, resource);
//    }
//    public SetFoodAdapter(@NonNull Context context, int resource,ArrayList<ArrayList> list) { //load preset
//        super(context, resource);
//        this.list = list;
//    }
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
//        ex = View.inflate(parent.getContext(), R.layout.adapter_setfood,null);
//
//        ((TextView)ex.findViewById(R.id.selectedFood)).setText(""+(position+1)+list.get(position));
//
//        ((Button)ex.findViewById(R.id.btn_delete)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(list.size()!=0) {
//                    list.remove(position);
//                    notifyDataSetChanged();
//                }else ; // 예외처리 작성
//
//            }
//        });
//
//
//        return ex;
//    }
//
//
//}
