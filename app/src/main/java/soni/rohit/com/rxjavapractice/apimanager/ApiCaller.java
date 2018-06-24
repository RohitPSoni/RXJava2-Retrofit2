package soni.rohit.com.rxjavapractice.apimanager;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import soni.rohit.com.rxjavapractice.Constants;
import soni.rohit.com.rxjavapractice.modal.WiKi;
import soni.rohit.com.rxjavapractice.network.NetworkService;
import soni.rohit.com.rxjavapractice.network.RestNetworkTask;

public class ApiCaller {
    private NetworkService mService = RestNetworkTask.createRetrofit().create(NetworkService.class);
    private final Observer<WiKi> observer;

    public ApiCaller(Observer<WiKi> observer) {
        this.observer = observer;
    }

    public void getUsers(String userName) {
        Observable<WiKi> usersObservable = mService.getUsers(Constants.QUERY, Constants.ACTION,
                Constants.FORMAT, Constants.GENERATOR, Constants.FORMATVERSION, Constants.WBPATTERNS,
                userName, Constants.GPSLIMIT);

        usersObservable
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer);
    }
}