package com.vetrya.firstattemptmvp.userinfo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vetrya.firstattemptmvp.R;
import com.vetrya.firstattemptmvp.http.User;

import butterknife.BindView;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public class UserDisplayAdapter extends RecyclerView.Adapter<UserDisplayAdapter.UserVH> {

    private final UserDisplayList list;

    UserDisplayAdapter(){
        list = new UserDisplayList();
    }

    @Override
    public UserVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_info, parent));
    }

    @Override
    public void onBindViewHolder(UserVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void add(User user) {
        list.add(user);
        notifyItemChanged(0);
    }

    class UserVH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_avatar_user) ImageView avaterImage;
        @BindView(R.id.tv_fname_user) TextView fistName;
        @BindView(R.id.tv_lname_user) TextView lastName;

        public UserVH(View itemView) {
            super(itemView);
        }
    }
}
