package com.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author jzx
 * @date 2019/02/15 10:26
 * @Description:
 */
public class RMIserver {
    public static void main(String[] argv){
     
        try {
            Iecho iecho=new IechoImpl();
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/Iecho",iecho);
        }catch (RemoteException e){
            e.getMessage();
        }catch (AlreadyBoundException e){
            e.getMessage();
        }catch (MalformedURLException e){
            e.getMessage();
        }

    }
}
