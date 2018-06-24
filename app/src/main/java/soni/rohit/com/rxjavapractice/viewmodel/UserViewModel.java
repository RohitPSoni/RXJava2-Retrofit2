package soni.rohit.com.rxjavapractice.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import soni.rohit.com.rxjavapractice.modal.WiKi;

public class UserViewModel extends ViewModel {
    MutableLiveData<WiKi> usersMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<WiKi> getUsersMutableLiveData() {
        return usersMutableLiveData;
    }

    public void setUsersMutableLiveData(WiKi users) {
        usersMutableLiveData.setValue(users);
    }
}
