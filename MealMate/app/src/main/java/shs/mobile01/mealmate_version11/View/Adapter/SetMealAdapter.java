package shs.mobile01.mealmate_version11.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import shs.mobile01.mealmate_version11.Model.dto.DataModel_Food;
import shs.mobile01.mealmate_version11.Model.dto.DataModel_Meal;
import shs.mobile01.mealmate_version11.R;

public class SetMealAdapter extends RecyclerView.Adapter<SetMealAdapter.ViewHolder> {
    // 호출 순서 1. 생성자로 데이터 입력받기 2. getItemCount()로 생성할 뷰의 개수 파악 3. onCreateViewHolder()로 뷰를 count 수 만큼 생성
    public static ArrayList<ArrayList<DataModel_Food>> list ; // 테스트 list 추후에 변경

    public static class ViewHolder extends RecyclerView.ViewHolder{
        // 이벤트 리스너 할당등 코드를 모아놓음
        private RecyclerView rv;
        private Button btnCreate;
        private Button btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv =  itemView.findViewById(R.id.recyclerView_setFood);
            btnCreate = itemView.findViewById(R.id.btn_create);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            rv.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            rv.scrollToPosition(((LinearLayoutManager)rv.getLayoutManager()).findFirstCompletelyVisibleItemPosition());

        }
        public RecyclerView getRv() {
            return rv;
        }
        public Button getBtnCreate(){
            return btnCreate;
        }
    }

    public SetMealAdapter( ArrayList<ArrayList<DataModel_Food>> list ){//constructor 생성자, 데이터 리스트 받음
        this.list = list;
    }


    @NonNull
    @Override
    public SetMealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_setmeal,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SetMealAdapter.ViewHolder holder, int position) {
        SetFoodAdapter sfa = new SetFoodAdapter(list.get(position));
        holder.getRv().setAdapter(sfa);


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        // 리사이클러 뷰의 인덱스 개수 만큼 생성받기 위한 리턴
        //return list.size();
        return list.size();
    }

}
//public class SetMealAdapter extends ArrayAdapter {
//    private View ex;
//    private ArrayList<SetFoodAdapter> view_list;
//    ArrayList<String> sampleFood1 = new ArrayList<>(Arrays.asList("닭가슴살","20","80","20","100"));
//
//    ArrayList<DataModel_Meal> mealList;
//
//
//
//    public SetMealAdapter(@NonNull Context context, int resource, ArrayList<SetFoodAdapter> view_list) {
//        super(context, resource);
//        this.view_list = view_list;
//    }
//
//
//    @Override
//    public int getCount() {
//        return view_list.size();
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
//        ex = View.inflate(parent.getContext(), R.layout.adapter_setmeal,null);
//
//        SetFoodAdapter sfa = view_list.get(position);
//
//        ((ListView)ex.findViewById(R.id.listView_setFood)).setAdapter(sfa);
//
//        ((Button)ex.findViewById(R.id.btn_create)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) { //음식정보 받아와서 리스트에 넣어주는 이벤트
//                sfa.list.add(sampleFood1);
//                notifyDataSetChanged();
//            }
//        });
//        ((Button)ex.findViewById(R.id.btn_delete)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                view_list.remove(position);
//                notifyDataSetChanged();
//            }
//        });
//        return ex;
//    }
//
//}