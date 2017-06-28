package com.vetrya.firstattemptmvp.http;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public interface UserDisplayHttpApi {
    @GET("/api/users")
    Observable<User> getUser();
}