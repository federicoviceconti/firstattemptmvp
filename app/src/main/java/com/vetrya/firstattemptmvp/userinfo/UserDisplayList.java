package com.vetrya.firstattemptmvp.userinfo;

import com.vetrya.firstattemptmvp.http.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

class UserDisplayList {
    private List<User> userList;

    UserDisplayList() {
        userList = new ArrayList<>();
    }

    public synchronized List<User> getUserList(){
        return new ArrayList<>(userList);
    }

    void add(User user) {
        userList.add(0, user);
    }

    User getUser(int position) {
        return userList.get(position);
    }

    int getSize(){
        return userList.size();
    }

    public void setList(List<User> list) {
        this.userList = list;
    }

    public void addUsers(List<User> users) {
        if (users != null){
            userList.addAll(users);
        }
    }
}
