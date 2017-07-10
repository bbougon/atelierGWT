package com.agfa.orme.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RomanNumberServiceAsync {

    void getRomanNumber(Integer arabNumber, final AsyncCallback<String> async);
}
