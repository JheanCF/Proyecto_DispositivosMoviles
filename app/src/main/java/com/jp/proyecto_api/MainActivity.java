
package com.jp.proyecto_api;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivBooks;
    ImageView ivCharacters;
    ImageView ivHouses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivBooks=findViewById(R.id.ivBooks);
        ivCharacters=findViewById(R.id.ivCharacters);
        ivHouses=findViewById(R.id.ivHouses);

        ivBooks.setOnClickListener(this);
        ivCharacters.setOnClickListener(this);
        ivHouses.setOnClickListener(this);
        Button urlWebsite =findViewById(R.id.btnOficial);
        String url="https://www.westeros.org";
        urlWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnOficial) {
                    Uri link=Uri.parse(url);
                    Intent i=new Intent(Intent.ACTION_VIEW,link);
                    startActivity(i);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ivBooks) {
            Intent intent= new Intent(this,BooksActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.ivCharacters) {
            Intent intent= new Intent(this,CharacterActivity.class);
            startActivity(intent);

        }
        if (v.getId() == R.id.ivHouses) {
            Intent intent= new Intent(this,Houses_Activity.class);
            startActivity(intent);

        }

    }
}