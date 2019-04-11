package com.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author jzx
 * @date 2019/02/15 10:28
 * @Description:
 */
public interface Iecho  extends Remote  {
    String getResponse(String name) throws RemoteException;
}
