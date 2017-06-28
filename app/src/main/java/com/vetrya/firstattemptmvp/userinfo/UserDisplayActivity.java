package com.vetrya.firstattemptmvp.userinfo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public class UserDisplayActivity extends AppCompatActivity implements UserDisplayMVP.View {

    @Inject
    UserDisplayMVP.Presenter presenterUserDisplay;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenterUserDisplay.setView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenterUserDisplay.removeView(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void showErrorNetworkNotAvailable() throws RuntimeException {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserInfoDownloaded() throws RuntimeException {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoUserFound() throws RuntimeException {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
