package com.agfa.orme.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("romanNumberService")
public interface RomanNumberService extends RemoteService {

    String getRomanNumber(Integer arabNumber);

}
