package shs.mobile01.mealmate_version11.View.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMealAdapter extends ArrayAdapter {
    private View ex;
    private ArrayList<SetFoodAdapter> view_list;
    ArrayList<String> sampleFood1 = new ArrayList<>(Arrays.asList("닭가슴살","20","80","20","100"));



    public SetMealAdapter(@NonNull Context context, int resource, ArrayList<SetFoodAdapter> view_list) {
        super(context, resource);
        this.view_list = view_list;
    }

    @Override
    public int getCount() {
        return view_list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ex = View.inflate(parent.getContext(), R.layout.adapter_setmeal,null);

        SetFoodAdapter sfa = view_list.get(position);

        ((ListView)ex.findViewById(R.id.listView_setFood)).setAdapter(sfa);

        ((Button)ex.findViewById(R.id.btn_create)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //음식정보 받아와서 리스트에 넣어주는 이벤트
                sfa.list.add(sampleFood1);
                notifyDataSetChanged();
            }
        });
        ((Button)ex.findViewById(R.id.btn_delete)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_list.remove(position);
                notifyDataSetChanged();
            }
        });
        return ex;
    }

}