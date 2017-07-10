package com.agfa.orme.gwt.client;

import com.google.gwt.core.client.GWT;

public class AsyncServices {

    static AsyncServices get() {
        return SingletonHolder.instance;
    }

    public RomanNumberServiceAsync getRomanNumberService() {
        return GWT.create(RomanNumberService.class);
    }

    public static class SingletonHolder {
        public static AsyncServices instance = new AsyncServices();
    }

}
