package soni.rohit.com.rxjavapractice.DataManagers;

import android.util.Log;

import java.util.HashSet;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import soni.rohit.com.rxjavapractice.apimanager.ApiCaller;
import soni.rohit.com.rxjavapractice.modal.WiKi;

public class UserDataManager implements Observer<WiKi>{

    private final String TAG = UserDataManager.class.getSimpleName();
    private static UserDataManager instance;
    private UserDataManager(){}
    private HashSet<IDataManager> subscribers = new HashSet<>();
    private ApiCaller mApiCaller = new ApiCaller(this);

    public static synchronized UserDataManager getInstance(){
        if (null == instance){
            instance = new UserDataManager();
        }
        return instance;
    }

    public void subscribe(IDataManager iDataManager){
        subscribers.add(iDataManager);
    }

    public void unSubscribe(IDataManager iDataManager){
        subscribers.remove(iDataManager);
    }

    private void publishData(WiKi data){
        for (IDataManager manager: subscribers){
            manager.dataPublished(data);
        }
    }

    private void publishException(Exception e){
        for (IDataManager manager: subscribers){
            manager.publishException(e);
        }
    }

    public void getData(String name) {
        mApiCaller.getUsers(name);
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.i(TAG,"Subscribe:"+d.toString());
    }

    @Override
    public void onNext(WiKi users) {
        publishData(users);
    }

    @Override
    public void onError(Throwable e) {
        publishException(new Exception(e));
    }

    @Override
    public void onComplete() {
        Log.i(TAG,"API completed....");
    }
}