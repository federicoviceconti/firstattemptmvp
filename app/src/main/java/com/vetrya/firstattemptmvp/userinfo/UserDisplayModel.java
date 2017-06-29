package com.vetrya.firstattemptmvp.userinfo;

import com.vetrya.firstattemptmvp.http.model.Data;
import com.vetrya.firstattemptmvp.http.model.User;

import rx.Observable;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

class UserDisplayModel implements UserDisplayMVP.Model {

    private final Repository userDisplayRepo;

    UserDisplayModel(Repository userDisplayRepository) {
        this.userDisplayRepo = userDisplayRepository;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public Observable<Data> getAllUser() {
        return userDisplayRepo.downloadData();
    }
}
