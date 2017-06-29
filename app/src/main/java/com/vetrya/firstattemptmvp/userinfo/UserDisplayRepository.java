package com.vetrya.firstattemptmvp.userinfo;

import com.vetrya.firstattemptmvp.http.UserDisplayHttpApi;
import com.vetrya.firstattemptmvp.http.model.Data;

import rx.Observable;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

class UserDisplayRepository implements Repository{
    private final UserDisplayHttpApi api;
    private final UserDisplayList list;

    UserDisplayRepository(UserDisplayHttpApi api){
        this.api = api;
        this.list = new UserDisplayList();
    }

    @Override
    public Observable<Data> downloadData() {
        return api.getUser();
    }

    @Override
    public void noUserDownloaded() throws Exception {
        throw new Exception("No user downloaded");
    }

    @Override
    public UserDisplayList getAllUsersFromNetwork() {
        return list;
    }
}
