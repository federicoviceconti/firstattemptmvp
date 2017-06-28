package com.vetrya.firstattemptmvp.userinfo;

import com.vetrya.firstattemptmvp.root.BaseView;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public class UserDisplayPresenter implements UserDisplayMVP.Presenter {

    private UserDisplayMVP.View view;

    UserDisplayPresenter(UserDisplayMVP.View view){
    }

    @Override
    public <T extends BaseView> void removeView(T base) {
        if(view != null){
            view = null;
        }
    }

    @Override
    public <T extends UserDisplayMVP.View> void setView(T base) {
        if(view == null){
            this.view = base;
        }
    }
}
