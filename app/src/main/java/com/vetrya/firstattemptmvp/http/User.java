package com.vetrya.firstattemptmvp.http;

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
}
