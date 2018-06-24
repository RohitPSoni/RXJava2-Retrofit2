package soni.rohit.com.rxjavapractice.DataManagers;

import soni.rohit.com.rxjavapractice.modal.WiKi;

public interface IDataManager {

    void dataPublished(WiKi data);

    void publishException(Exception e);
}
