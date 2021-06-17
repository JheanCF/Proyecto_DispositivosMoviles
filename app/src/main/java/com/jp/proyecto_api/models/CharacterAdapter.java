package com.jp.proyecto_api.models;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jp.proyecto_api.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Character> myCharacter;

    public CharacterAdapter(Activity activity, List<Character> bookList) {
        this.activity=activity;
        this.myCharacter=bookList;
    }

    @Override
    public int getCount() {
        return myCharacter.size();
    }

    @Override
    public Object getItem(int position) {
        return myCharacter.get(position);
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
            v=inf.inflate(R.layout.character_item,null);
        }
        Character character=myCharacter.get(position);

        TextView nameChara =v.findViewById(R.id.tvNameChara);
        nameChara.setText(character.getNameCharacter());
        ImageView ivChara=v.findViewById(R.id.ivCharacter);
        Picasso.get()
                .load("https://cdn.arstechnica.net/wp-content/uploads/2016/07/scytheicons.jpg")
                .into(ivChara);

        TextView cultureChara =v.findViewById(R.id.tvCultureChara);
        cultureChara.setText(character.getCultureCharacter());

        TextView asChara =v.findViewById(R.id.tvAsChara);
        asChara.setText(character.getAliasCharacter().toString());

        return v;
    }

}
