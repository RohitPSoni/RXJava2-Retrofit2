package soni.rohit.com.rxjavapractice.apimanager;

import soni.rohit.com.rxjavapractice.modal.WiKi;

public interface ReceivedListener {
    void dataReceived(WiKi data);

    void exceptionReceived(Exception e);
}
