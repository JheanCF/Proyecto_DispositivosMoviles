package com.jp.proyecto_api.ApiManager;

import com.jp.proyecto_api.BooksDetail;
import com.jp.proyecto_api.models.Book;
import com.jp.proyecto_api.models.Character;
import com.jp.proyecto_api.models.House;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL="https://www.anapioficeandfire.com/api/";
    @GET("books")
    Call<List<Book>> getBooks();

    @GET("houses")
    Call<List<House>> getHouses();

    @GET("books/{id}")
    Call<Book> getBookDetail(@Path("id")String id);

    @GET("characters")
    Call<List<Character>> getCharacters();


}
