package com.vetrya.firstattemptmvp.userinfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

@Module
public class UserDisplayModule {
    @Provides
    @Singleton
    public UserDisplayMVP.Presenter providesUserDisplayPresenter(){
        return new UserDisplayPresenter(providesUserDisplayModel());
    }

    @Provides
    @Singleton
    public UserDisplayMVP.Model providesUserDisplayModel(){
        return new UserDisplayModel();
    }
}
