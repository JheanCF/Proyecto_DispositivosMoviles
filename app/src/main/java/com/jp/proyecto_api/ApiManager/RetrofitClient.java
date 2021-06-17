package com.jp.proyecto_api.ApiManager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instace =null;
    private  Api myApi;

    private RetrofitClient(){

        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myApi=retrofit.create(Api.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if (instace==null){
            instace=new RetrofitClient();
        }
        return instace;
    }

    public Api getMyApi(){

        return myApi;
    }
}
