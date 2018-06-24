package soni.rohit.com.rxjavapractice.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import soni.rohit.com.rxjavapractice.R;
import soni.rohit.com.rxjavapractice.modal.Pages;

public class UserViewAdapter extends RecyclerView.Adapter<UserViewAdapter.UsersViewHolder> {

    private ArrayList<Pages> mUserData;

    public UserViewAdapter(ArrayList<Pages> userData) {
        this.mUserData = userData;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_github_repo, parent, false);
        return new UsersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        if (null != mUserData.get(position).getThumbnail()) {
            Picasso.get().load(mUserData.get(position).getThumbnail().getSource())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.mUserImage);
        } else {
            holder.mUserImage.setImageResource(R.drawable.ic_launcher_foreground);
        }
        holder.mUserName.setText(mUserData.get(position).getTitle());
        if (null != mUserData.get(position).getTerms()) {
            holder.mUserReputation.setText(mUserData.get(position).getTerms().getDescription().get(0));
        }
    }

    @Override
    public int getItemCount() {
        return mUserData.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {
        ImageView mUserImage;
        TextView mUserName, mUserReputation;

        UsersViewHolder(View view) {
            super(view);
            mUserImage = view.findViewById(R.id.user_image);
            mUserName = view.findViewById(R.id.user_name);
            mUserReputation = view.findViewById(R.id.reputation);
        }
    }

    public void setUserData(ArrayList<Pages> mUserData) {
        this.mUserData = mUserData;
        notifyDataSetChanged();
    }
}
