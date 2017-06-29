package com.vetrya.firstattemptmvp.userinfo;

import com.vetrya.firstattemptmvp.R;
import com.vetrya.firstattemptmvp.http.model.Data;
import com.vetrya.firstattemptmvp.root.BaseView;

import java.net.SocketTimeoutException;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

class UserDisplayPresenter implements UserDisplayMVP.Presenter {
    private UserDisplayMVP.View view;
    private UserDisplayMVP.Model model;

    UserDisplayPresenter(UserDisplayMVP.Model model) {
        this.model = model;
    }

    @Override
    public <T extends BaseView> void removeView(T base) {
        if (view != null) {
            view = null;
        }
    }

    @Override
    public <T extends UserDisplayMVP.View> void setView(T base) {
        if (view == null) {
            this.view = base;
        } else {
            view.showAnErrorOccurred();
        }
    }

    @Override
    public boolean choiceMenuItem(int idItem) {
        switch (idItem) {
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
        model.getAllUser().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Data>() {
                    @Override
                    public void onCompleted() {
                        view.refreshAllItems();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(e.getCause() instanceof SocketTimeoutException){
                            view.showErrorNetworkNotAvailable();
                        }
                    }

                    @Override
                    public void onNext(Data user) {
                        view.addUsersList(user.getUsers());
                    }
                });

        return true;
    }
}
