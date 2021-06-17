package com.jp.proyecto_api.models;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jp.proyecto_api.Houses_Activity;
import com.jp.proyecto_api.R;

import java.util.List;

public class AdapterHouses extends BaseAdapter {
    protected Activity activity;
    protected List<House> myHouses;

    public AdapterHouses(Houses_Activity houses_activity, List<House> myHouseList) {
        this.activity=activity;
        this.myHouses=myHouseList;
    }

    @Override
    public int getCount() {
        return myHouses.size();
    }

    @Override
    public Object getItem(int position) {
        return myHouses.get(position);
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

        House house=myHouses.get(position);

        TextView tvName =v.findViewById(R.id.tvNameHouse);
        tvName.setText(house.getNameHouse());

        TextView tvReg =v.findViewById(R.id.tvRegion);
        tvReg.setText(house.getRegionHouse());

        TextView tvCoat =v.findViewById(R.id.tvCoatArms);
        tvCoat.setText(house.getCoatOfArmsHouse());


        return v;
    }
}
