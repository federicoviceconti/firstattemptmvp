package com.vetrya.firstattemptmvp.userinfo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.vetrya.firstattemptmvp.R;
import com.vetrya.firstattemptmvp.root.Field;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public class UserDisplayActivity extends AppCompatActivity implements UserDisplayMVP.View {

    @Inject UserDisplayMVP.Presenter presenterUserDisplay;
    @BindView(R.id.user_display_recycler) RecyclerView recycler;
    Unbinder unbind;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_user_info);
        unbind = ButterKnife.bind(this);

        initialize();
    }

    private void initialize() {
        presenterUserDisplay.setAdapter(recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_user_display, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return presenterUserDisplay.choiceMenuItem(item.getItemId());
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
        unbind = null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void showErrorNetworkNotAvailable() throws RuntimeException {
        Toast.makeText(this, Field.NO_NETWORK_FOUND, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserInfoDownloaded() throws RuntimeException {
        Toast.makeText(this, Field.USER_INFO_DOWNLOADED, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoUserFound() throws RuntimeException {
        Toast.makeText(this, Field.NO_USER_INFO_DOWNLOADED, Toast.LENGTH_SHORT).show();
    }
}
