package soni.rohit.com.rxjavapractice.network;

import retrofit2.http.GET;
import retrofit2.http.Query;
import soni.rohit.com.rxjavapractice.modal.RestMethodName;
import io.reactivex.Observable;
import soni.rohit.com.rxjavapractice.modal.WiKi;

public interface NetworkService {

    @GET(RestMethodName.USERS)
    Observable<WiKi> getUsers(@Query("action") String action, @Query("format") String format,
                              @Query("prop") String prop, @Query("generator") String generator,
                              @Query("formatversion") String vesion, @Query("wbptterms") String terms,
                              @Query("gpssearch") String name, @Query("gpslimit") String limit);
}