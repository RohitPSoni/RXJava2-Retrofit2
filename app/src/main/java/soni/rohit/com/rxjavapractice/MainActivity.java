package soni.rohit.com.rxjavapractice;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import soni.rohit.com.rxjavapractice.DataManagers.IDataManager;
import soni.rohit.com.rxjavapractice.DataManagers.UserDataManager;
import soni.rohit.com.rxjavapractice.adapter.UserViewAdapter;
import soni.rohit.com.rxjavapractice.modal.Pages;
import soni.rohit.com.rxjavapractice.modal.WiKi;
import soni.rohit.com.rxjavapractice.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity implements IDataManager {
    private final String TAG = MainActivity.class.getName();
    private Button mGetUsers;
    private UserViewModel mViewModel;
    private RecyclerView mUserList;
    private UserViewAdapter mAdapter;
    private EditText mUserSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        mGetUsers = findViewById(R.id.button_search);
        mUserList = findViewById(R.id.list_view_users);
        mUserSearch = findViewById(R.id.search);

        mUserList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mAdapter = new UserViewAdapter(new ArrayList<Pages>());
        mUserList.setAdapter(mAdapter);
        mGetUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mUserSearch.getText().toString();
                if (TextUtils.isEmpty(text)){
                    Toast.makeText(MainActivity.this, "Please input Text", Toast.LENGTH_SHORT).show();
                } else {
                    UserDataManager.getInstance().getData(text);
                }
            }
        });
        UserDataManager.getInstance().subscribe(this);

        mViewModel.getUsersMutableLiveData().observe(this, new Observer<WiKi>() {
            @Override
            public void onChanged(@Nullable WiKi users) {
                mAdapter.setUserData(users.getQuery().getPages());
            }
        });
    }

    @Override
    public void dataPublished(WiKi data) {
        mViewModel.setUsersMutableLiveData(data);
    }

    @Override
    public void publishException(Exception e) {
        Log.i(TAG,"Exception received:"+e.toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        UserDataManager.getInstance().unSubscribe(this);
    }
}