package com.vetrya.firstattemptmvp.userinfo;

import com.vetrya.firstattemptmvp.http.UserDisplayHttpApi;

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
    UserDisplayMVP.Presenter providesUserDisplayPresenter(UserDisplayMVP.Model model){
        return new UserDisplayPresenter(model);
    }

    @Provides
    @Singleton
    UserDisplayMVP.Model providesUserDisplayModel(Repository repo){
        return new UserDisplayModel(repo);
    }

    @Provides
    @Singleton
    Repository provideUserDisplayRepository(UserDisplayHttpApi userDisplayHttpApi) {
        return new UserDisplayRepository(userDisplayHttpApi);
    }
}
