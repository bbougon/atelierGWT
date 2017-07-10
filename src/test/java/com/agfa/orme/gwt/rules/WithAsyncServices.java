package com.agfa.orme.gwt.rules;

import com.agfa.orme.gwt.client.AsyncServices;
import com.agfa.orme.gwt.client.RomanNumberServiceAsync;
import org.junit.rules.ExternalResource;

import static org.mockito.Mockito.mock;

public class WithAsyncServices extends ExternalResource {

    public WithAsyncServices() {
        AsyncServices.SingletonHolder.instance = new AsyncServices() {

            @Override
            public RomanNumberServiceAsync getRomanNumberService() {
                return romanNumberServiceAsync;
            }
        };
    }

    private final RomanNumberServiceAsync romanNumberServiceAsync = mock(RomanNumberServiceAsync.class);
}
