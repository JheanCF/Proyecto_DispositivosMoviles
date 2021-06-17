package com.jp.proyecto_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jp.proyecto_api.ApiManager.RetrofitClient;
import com.jp.proyecto_api.models.Book;
import com.jp.proyecto_api.models.BookAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listBooks;
    List<Book> myBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        listBooks=findViewById(R.id.listBooks);
        getMainBooks();
        listBooks.setOnItemClickListener(this);
    }

    private void getMainBooks() {

        Call<List<Book>> call= RetrofitClient.getInstance().getMyApi().getBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                myBook= response.body();
                BookAdapter adapter=new BookAdapter(BooksActivity.this,myBook);
                listBooks.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio Error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent in=new Intent(this,BooksDetail.class);
        in.putExtra("id",myBook.get(position).getIdBook());
        startActivity(in);

    }
}