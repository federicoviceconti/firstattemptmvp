package com.vetrya.firstattemptmvp.root;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application){
        this.application = application;
    }

    @Provides
    public Context providesApplicationContext(){
        return application;
    }
}
