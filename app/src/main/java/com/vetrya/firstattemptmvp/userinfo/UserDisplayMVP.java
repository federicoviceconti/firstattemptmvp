package com.vetrya.firstattemptmvp.userinfo;

import com.vetrya.firstattemptmvp.http.model.Data;
import com.vetrya.firstattemptmvp.http.model.User;
import com.vetrya.firstattemptmvp.root.BasePresenter;
import com.vetrya.firstattemptmvp.root.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public interface UserDisplayMVP {
    interface View extends BaseView {
        void showErrorNetworkNotAvailable() throws RuntimeException;
        void showUserInfoDownloaded() throws RuntimeException;
        void showAnErrorOccurred() throws RuntimeException;
        void showNoUserFound() throws RuntimeException;
        void refreshSingleItem(int position);
        void refreshAllItems();
        void addUsersList(List<User> user);
    }

    interface Presenter extends BasePresenter {
        <T extends View> void setView(T base);
        boolean choiceMenuItem(int idItem);
        boolean onItemDownloadClicked();
    }

    interface Model{
        void addUser(User user);
        Observable<Data> getAllUser();
    }
}
