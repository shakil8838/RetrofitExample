package com.example.retrofitexample.APIs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anonymous on 12/24/2017.
 */
public class ApiClint {

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        if (retrofit==null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(URLs.FETCH_REMINDERS)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
