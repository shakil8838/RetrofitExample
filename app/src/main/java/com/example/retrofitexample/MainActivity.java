package com.example.retrofitexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.retrofitexample.APIs.ApiClint;
import com.example.retrofitexample.adapters.PopulatingAdapter;
import com.example.retrofitexample.dataprovider.DataProvider;
import com.example.retrofitexample.interfaces.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<DataProvider> list;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ApiInterface apiInterface;
    private PopulatingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.TheList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        apiInterface = ApiClint.getRetrofit().create(ApiInterface.class);

        Call<List<DataProvider>> call = apiInterface.getAllReminders();
        call.enqueue(new Callback<List<DataProvider>>() {
            @Override
            public void onResponse(Call<List<DataProvider>> call, Response<List<DataProvider>> response) {

                list = response.body();
                adapter = new PopulatingAdapter(list, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<DataProvider>> call, Throwable t) {
                Log.e("SOME ERRORS", call.toString() + "\t" + t.toString());
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.AddItem);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent toInfoAddActivity = new Intent(MainActivity.this, AddInfo.class);
                startActivity(toInfoAddActivity);
                //bhumi and ayush khurana new movie
            }
        });

    }

    /*@Override
    protected void onStart() {
        super.onStart();

        Call<List<DataProvider>> call = apiInterface.getAllReminders();
        call.enqueue(new Callback<List<DataProvider>>() {
            @Override
            public void onResponse(Call<List<DataProvider>> call, Response<List<DataProvider>> response) {

                list = response.body();
                adapter = new PopulatingAdapter(list, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<DataProvider>> call, Throwable t) {
                Log.e("SOME ERRORS", call.toString() + "\t" + t.toString());
            }
        });
    }*/
}
