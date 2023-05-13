package shs.mobile01.mealmate_version11.View.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import shs.mobile01.mealmate_version11.R;
import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {
    private View ex;
    private ArrayList<ArrayList> list;
    public FoodAdapter(ArrayList<ArrayList> _list) {
        list = _list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        ex = View.inflate(parent.getContext(), R.layout.adapter_food,null);
        return ex;
    }
}
