package com.example.retrofitexample.dataprovider;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Anonymous on 12/24/2017.
 */
public class DataProvider {

    @SerializedName("Date")
    private String Date;

    @SerializedName("Time")
    private String Time;

    @SerializedName("Details")
    private String Reminders;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getReminders() {
        return Reminders;
    }

    public void setReminders(String reminders) {
        Reminders = reminders;
    }
}
