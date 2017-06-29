package com.vetrya.firstattemptmvp.userinfo;

import com.vetrya.firstattemptmvp.http.model.Data;

import rx.Observable;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

interface Repository {
    Observable<Data> downloadData();
    void noUserDownloaded() throws Exception;
    UserDisplayList getAllUsersFromNetwork();
}
