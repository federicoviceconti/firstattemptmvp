package com.vetrya.firstattemptmvp.userinfo;

import android.support.v7.widget.RecyclerView;

import com.vetrya.firstattemptmvp.R;
import com.vetrya.firstattemptmvp.http.User;
import com.vetrya.firstattemptmvp.http.UserDisplayHttpApi;
import com.vetrya.firstattemptmvp.root.BaseView;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public class UserDisplayPresenter implements UserDisplayMVP.Presenter {

    private UserDisplayAdapter adapter;
    private UserDisplayMVP.View view;
    private UserDisplayMVP.Model model;
    @Inject private UserDisplayHttpApi apiRequest;

    public UserDisplayPresenter(UserDisplayMVP.Model model) {
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

    @Override
    public void setAdapter(RecyclerView recyclerView) {
        recyclerView.setAdapter(adapter == null ? adapter = new UserDisplayAdapter() : adapter);
    }

    @Override
    public boolean choiceMenuItem(int idItem) {
        switch (idItem){
            case R.id.user_diplay_download:
                onItemDownloadClicked();
                break;
            default:
                return false;
        }

        return true;
    }

    @Override
    public boolean onItemDownloadClicked() {
        apiRequest.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override public void onCompleted() {}
                    @Override public void onError(Throwable e) {}
                    @Override public void onNext(User user) {adapter.add(user);}
                });
        return true;
    }
}
