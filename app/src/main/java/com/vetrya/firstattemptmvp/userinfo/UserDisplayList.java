package com.vetrya.firstattemptmvp.userinfo;

import com.vetrya.firstattemptmvp.http.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public class UserDisplayList {
    private final List<User> userList;

    public UserDisplayList() {
        userList = new ArrayList<>();
    }

    public synchronized List<User> getUserList(){
        return new ArrayList<>(userList);
    }

    public void add(User user) {
        userList.add(0, user);
    }
}
