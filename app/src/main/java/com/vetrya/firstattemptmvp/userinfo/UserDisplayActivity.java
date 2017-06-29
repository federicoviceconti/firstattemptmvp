package com.vetrya.firstattemptmvp.userinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.vetrya.firstattemptmvp.R;
import com.vetrya.firstattemptmvp.http.model.User;
import com.vetrya.firstattemptmvp.root.App;
import com.vetrya.firstattemptmvp.root.Field;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public class UserDisplayActivity extends AppCompatActivity implements UserDisplayMVP.View {

    UserDisplayAdapterInterface.View adapter;
    @Inject UserDisplayMVP.Presenter presenterUserDisplay;
    @BindView(R.id.user_display_recycler) RecyclerView recycler;
    Unbinder unbind;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        unbind = ButterKnife.bind(this);
        ((App)getApplication()).getComponent().inject(this);

        initialize();

    }

    private void initialize() {
        presenterUserDisplay.setView(this);
        adapter = new UserDisplayAdapter(this);
        recycler.setAdapter((RecyclerView.Adapter) adapter);
        recycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
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
    public void showAnErrorOccurred() throws RuntimeException {
        Toast.makeText(this, Field.AN_ERROR_OCCURRED, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoUserFound() throws RuntimeException {
        Toast.makeText(this, Field.NO_USER_INFO_DOWNLOADED, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshSingleItem(int position) {
        adapter.refreshItemAdded(position);
    }

    @Override
    public void refreshAllItems() {
        adapter.refreshDataSet();
    }

    @Override
    public void addUsersList(List<User> user) {
        adapter.addUsersList(user);
    }
}
