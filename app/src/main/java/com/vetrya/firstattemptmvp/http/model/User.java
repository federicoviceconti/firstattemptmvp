package com.vetrya.firstattemptmvp.http.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public class User {
    @SerializedName("id")
    private int id;
    @SerializedName("first_name")
    private String fName;
    @SerializedName("last_name")
    private String lName;
    @SerializedName("avatar")
    private String urlAvatar;

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
