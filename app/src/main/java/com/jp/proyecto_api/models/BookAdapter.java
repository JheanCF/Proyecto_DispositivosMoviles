package com.jp.proyecto_api.models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.jp.proyecto_api.R;

import java.util.List;

public class BookAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Book> myBook;

    public BookAdapter(Activity activity, List<Book> bookList) {
        this.activity=activity;
        this.myBook=bookList;
    }

    @Override
    public int getCount() {
        return myBook.size();
    }

    @Override
    public Object getItem(int position) {
        return myBook.get(position);
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
            v=inf.inflate(R.layout.book_item,null);
        }
        Book book=myBook.get(position);

        TextView idBook =v.findViewById(R.id.tvId);
        idBook.setText(book.getIdBook());

        TextView nameBook =v.findViewById(R.id.tvNameBook);
        nameBook.setText(book.getNameBook());

        TextView editorialBook =v.findViewById(R.id.tvEditorial);
        editorialBook.setText("Publisher: "+book.getPublisherBook());

        return v;
    }
}
