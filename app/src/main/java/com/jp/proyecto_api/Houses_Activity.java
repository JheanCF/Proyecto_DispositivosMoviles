package com.jp.proyecto_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.jp.proyecto_api.ApiManager.RetrofitClient;
import com.jp.proyecto_api.models.AdapterHouses;
import com.jp.proyecto_api.models.Book;
import com.jp.proyecto_api.models.BookAdapter;
import com.jp.proyecto_api.models.Character;
import com.jp.proyecto_api.models.CharacterAdapter;
import com.jp.proyecto_api.models.House;
import com.jp.proyecto_api.models.HouseAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Houses_Activity extends AppCompatActivity {
    ListView listHouses;

    List<Character> myChara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houses_);

        listHouses=findViewById(R.id.listHouses);
        getMainHouses();
    }

    private void getMainHouses() {
 Call<List<House>> call= RetrofitClient.getInstance().getMyApi().getHouses();
        call.enqueue(new Callback<List<House>>() {
            @Override
            public void onResponse(Call<List<House>> call, Response<List<House>> response) {
                List<House> myHouse= response.body();
                HouseAdapter adapter=new HouseAdapter(Houses_Activity.this,myHouse);
                listHouses.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<House>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}