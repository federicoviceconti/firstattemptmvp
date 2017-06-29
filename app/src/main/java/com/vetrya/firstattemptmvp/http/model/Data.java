package com.vetrya.firstattemptmvp.http.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public class Data{
    @SerializedName("data")
    private List<User> users;
    @SerializedName("page")
    private int page;

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Data{" +
                "users=" + users +
                ", page=" + page +
                '}';
    }
}
