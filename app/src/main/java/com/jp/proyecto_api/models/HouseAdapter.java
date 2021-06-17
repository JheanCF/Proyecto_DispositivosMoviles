package com.jp.proyecto_api.models;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jp.proyecto_api.R;

import java.util.List;

public class HouseAdapter extends BaseAdapter {


    protected Activity activity;
    protected List<House> myHouse;

    public HouseAdapter(Activity activity, List<House> houseList) {
        this.activity=activity;
        this.myHouse=houseList;
    }


    @Override
    public int getCount() {
        return myHouse.size();
    }

    @Override
    public Object getItem(int position) {
        return myHouse.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if (convertView==null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inf.inflate(R.layout.houses_item,null);
        }
        House house=myHouse.get(position);

        TextView tvNameHouse =v.findViewById(R.id.tvNameHouse);
        tvNameHouse.setText(house.getNameHouse());

        TextView tvRegion =v.findViewById(R.id.tvRegion);
        tvRegion.setText(house.getRegionHouse());

        TextView tvCoatArms =v.findViewById(R.id.tvCoatArms);
        tvCoatArms.setText(house.getCoatOfArmsHouse());


        return v;
    }
}
