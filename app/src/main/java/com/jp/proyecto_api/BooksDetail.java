package com.jp.proyecto_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jp.proyecto_api.ApiManager.RetrofitClient;
import com.jp.proyecto_api.models.Book;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class BooksDetail extends AppCompatActivity {
   String id ;

    private ImageView ivTitleName;
    private TextView tvTitleBook;
    private TextView tvAuthors;
    private TextView tvPages;
    private TextView tvPublisher;
    Book myBook;
    ImageView imgTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_detail);

        Bundle in =getIntent().getExtras();
        id =in.getString("id");
        //Log.d(TAG, "tgggg: "+id);
        imgTitle=findViewById(R.id.ivBookDetail2);
        switch (id){
            case "1":
                Picasso.get()
                        .load("https://www.syfy.com/sites/syfy/files/styles/1200x680/public/wire/legacy/game-of-thrones-season-4-title-show-logo-101539.jpg")
                        .into(imgTitle);
                break;
                case "2":
                Picasso.get()
                        .load("https://winteriscoming.net/files/2019/11/Screen-Shot-2019-11-13-at-2.09.51-PM.jpg")
                        .into(imgTitle);
                    break;
                case "3":
                Picasso.get()
                        .load("https://fifteenthousandpages.files.wordpress.com/2016/08/o-storm-of-swords-facebook.jpg?w=1200")
                        .into(imgTitle);
                    break;
                case "4":
                Picasso.get()
                        .load("https://s24195.pcdn.co/wp-content/uploads/2015/06/dunkegg.png")
                        .into(imgTitle);
                    break;
                case "5":
                Picasso.get()
                        .load("https://www.spirit-of-metal.com/les%20goupes/A/A%20Feast%20For%20Crows/pics/logo.jpg")
                        .into(imgTitle);
                    break;
                case "6":
                Picasso.get()
                        .load("https://lastfm.freetls.fastly.net/i/u/500x500/bd7fcbe4b3ba4718c72a0ac676cc6804.jpg")
                        .into(imgTitle);
                    break;
                case "7":
                Picasso.get()
                        .load("http://www.scifimoviepage.com/wp-content/uploads/2017/08/knight-2.jpg")
                        .into(imgTitle);
                    break;
                case "8":
                Picasso.get()
                        .load("https://wikiofthrones.com/static/uploads/2017/02/dancedragons2-compressed.jpg")
                        .into(imgTitle);
                    break;
                case "9":
                Picasso.get()
                        .load("https://www.ecured.cu/images/8/8b/La_Princesa_y_la_Reina.png")
                        .into(imgTitle);
                    break;
                case "10":
                Picasso.get()
                        .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZ5QrbrXbmSDlMHpBJhA3J9hx1XOvzqBa_yQ&usqp=CAU")
                        .into(imgTitle);
                    break;

        }

        getBookById(id);
    }

    private void getBookById(String id) {

        Call<Book> call= RetrofitClient.getInstance().getMyApi().getBookDetail(id);

        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                myBook= response.body();
                Log.d(TAG, "Taggg: "+myBook.getNameBook());
                /*BookDetailsAdapter adapter= new BookDetailsAdapter(BooksDetail.this,myBook);
                listBooksDetail.setAdapter(adapter);*/

                TextView tvTitleNameBook =findViewById(R.id.tvTitleName2);
                tvTitleNameBook.setText(myBook.getNameBook());
                String [] autor=myBook.getAuthorsBook();
                TextView tvAuthors =findViewById(R.id.tvAuthors2);
                for (int i = 0; i <autor.length ; i++) {
                    String autorReco=autor[i];
                    tvAuthors.setText(tvAuthors.getText()+" "+autorReco);
                }

                TextView tvPages =findViewById(R.id.tvPages2);
                String pages= String.valueOf(myBook.getPagesBook());
                tvPages.setText(pages);

                TextView tvPublisher =findViewById(R.id.tvPublisherDetail2);
                tvPublisher.setText(myBook.getPublisherBook());

            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio Error",Toast.LENGTH_SHORT).show();

            }
        });

    }
}