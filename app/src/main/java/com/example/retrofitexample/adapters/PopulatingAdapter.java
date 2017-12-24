package com.example.retrofitexample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retrofitexample.R;
import com.example.retrofitexample.dataprovider.DataProvider;

import java.util.List;

/**
 * Created by Anonymous on 12/24/2017.
 */
public class PopulatingAdapter extends RecyclerView.Adapter<PopulatingAdapter.MyviewHolder> {

    List<DataProvider> list;
    Context context;

    public void dataPopulateAdapter(){
        //empty Constructor
    }

    public PopulatingAdapter(List<DataProvider> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_view,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {

        holder.showDate.setText(list.get(position).getDate());
        holder.showTime.setText(list.get(position).getTime());
        holder.showReminders.setText(list.get(position).getReminders());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{

        TextView showDate, showTime, showReminders;

        public MyviewHolder(View itemView) {
            super(itemView);

            showDate = (TextView)itemView.findViewById(R.id.showDate);
            showTime = (TextView)itemView.findViewById(R.id.showTime);
            showReminders = (TextView)itemView.findViewById(R.id.showDetails);
        }
    }
}
