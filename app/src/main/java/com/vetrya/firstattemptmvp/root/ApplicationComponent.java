package com.vetrya.firstattemptmvp.root;

import com.vetrya.firstattemptmvp.http.UserDisplayHttpModule;
import com.vetrya.firstattemptmvp.userinfo.UserDisplayActivity;
import com.vetrya.firstattemptmvp.userinfo.UserDisplayModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

@Singleton
@Component(modules = {ApplicationModule.class, UserDisplayModule.class, UserDisplayHttpModule.class})
public interface ApplicationComponent {
    void inject(UserDisplayActivity activity);
}
