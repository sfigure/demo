package com.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author jzx
 * @date 2019/02/15 10:29
 * @Description:
 */
public class IechoImpl extends UnicastRemoteObject implements Iecho, Serializable {
    
    public IechoImpl() throws RemoteException {
        System.out.println("init >>>>>>>>");
    }
    @Override
    public String getResponse(String name) throws RemoteException {
        System.out.println(">>>>>>>>");
        return "echo response";
    }
}
