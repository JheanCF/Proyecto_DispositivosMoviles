package com.jp.proyecto_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.jp.proyecto_api.ApiManager.RetrofitClient;
import com.jp.proyecto_api.models.BookAdapter;
import com.jp.proyecto_api.models.CharacterAdapter;
import com.jp.proyecto_api.models.Character;
import com.jp.proyecto_api.models.House;
import com.jp.proyecto_api.models.HouseAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterActivity extends AppCompatActivity {
    ListView listChara;
    List<Character> myChara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        listChara=findViewById(R.id.listCharaters);
        getMainCharacter();

    }

    private void getMainCharacter() {


     Call<List<Character>> call= RetrofitClient.getInstance().getMyApi().getCharacters();
     call.enqueue(new Callback<List<Character>>() {
         @Override
         public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {
             myChara= response.body();
             CharacterAdapter adapter=new CharacterAdapter(CharacterActivity.this,myChara);
             listChara.setAdapter(adapter);
         }

         @Override
         public void onFailure(Call<List<Character>> call, Throwable t) {
             Toast.makeText(getApplicationContext(),"Ocurrio Error",Toast.LENGTH_SHORT).show();

         }
     });
    }
}