package com.vetrya.firstattemptmvp.userinfo;

import com.vetrya.firstattemptmvp.http.model.User;

import java.util.List;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

interface UserDisplayAdapterInterface {
    interface View{
        void add(User user);
        void refreshDataSet();
        void refreshItemAdded(int position);
        void refreshItemRemove(int position);
        void addUsersList(List<User> user);
    }
}
