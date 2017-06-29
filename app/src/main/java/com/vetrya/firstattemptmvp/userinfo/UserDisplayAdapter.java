package com.vetrya.firstattemptmvp.userinfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vetrya.firstattemptmvp.R;
import com.vetrya.firstattemptmvp.http.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

class UserDisplayAdapter extends RecyclerView.Adapter<UserDisplayAdapter.UserVH>
        implements UserDisplayAdapterInterface.View {

    private final Context context;
    private UserDisplayList list;

    UserDisplayAdapter(Context context) {
        this.context = context;
        this.list = new UserDisplayList();
    }

    @Override
    public UserVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_info, null));
    }

    @Override
    public void onBindViewHolder(UserVH holder, int position) {
        User u = list.getUser(position);
        Glide.with(holder.itemView.getContext())
                .load(u.getUrlAvatar())
                .placeholder(context.getDrawable(R.drawable.ic_account_circle_black_24dp))
                .into(holder.avatarImage);
        holder.fistName.setText(u.getfName());
        holder.lastName.setText(u.getlName());
    }

    @Override
    public int getItemCount() {
        return list.getSize();
    }

    @Override
    public void add(User user) {
        list.add(user);
    }

    @Override
    public void refreshDataSet() {
        notifyDataSetChanged();
    }

    @Override
    public void refreshItemAdded(int position) {
        notifyItemInserted(position);
    }

    @Override
    public void refreshItemRemove(int position) {
        notifyItemRemoved(position);
    }

    @Override
    public void addUsersList(List<User> user) {
        list.addUsers(user);
    }

    class UserVH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_avatar_user) ImageView avatarImage;
        @BindView(R.id.tv_fname_user) TextView fistName;
        @BindView(R.id.tv_lname_user) TextView lastName;

        UserVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
