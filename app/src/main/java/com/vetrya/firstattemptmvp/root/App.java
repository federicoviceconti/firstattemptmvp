package com.vetrya.firstattemptmvp.root;

import android.app.Application;

import com.vetrya.firstattemptmvp.userinfo.UserDisplayModule;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .userDisplayModule(new UserDisplayModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
