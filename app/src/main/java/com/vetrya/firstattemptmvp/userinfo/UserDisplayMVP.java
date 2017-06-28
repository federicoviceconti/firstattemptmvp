package com.vetrya.firstattemptmvp.userinfo;

import android.support.v7.widget.RecyclerView;

import com.vetrya.firstattemptmvp.http.User;
import com.vetrya.firstattemptmvp.root.BasePresenter;
import com.vetrya.firstattemptmvp.root.BaseView;

import java.util.List;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public interface UserDisplayMVP {
    interface View extends BaseView {
        void showErrorNetworkNotAvailable() throws RuntimeException;
        void showUserInfoDownloaded() throws RuntimeException;
        void showNoUserFound() throws RuntimeException;
    }

    interface Presenter extends BasePresenter {
        <T extends View> void setView(T base);
        void setAdapter(RecyclerView recyclerView);
        boolean choiceMenuItem(int idItem);
        boolean onItemDownloadClicked();
    }

    interface Model{
        List<User> getAllUser();
    }
}
