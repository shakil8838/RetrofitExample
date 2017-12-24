package com.example.retrofitexample.interfaces;

import com.example.retrofitexample.dataprovider.DataProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Anonymous on 12/24/2017.
 */
public interface ApiInterface {

    @GET("reminders.php")
    Call<List<DataProvider>> getAllReminders();
}
