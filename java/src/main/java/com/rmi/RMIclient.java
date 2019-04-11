package com.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author jzx
 * @date 2019/02/15 10:26
 * @Description:
 */
public class RMIclient {
    public static void main(String[] argv){
        try{
            Iecho iecho =  (Iecho) Naming.lookup("rmi://localhost:8888/Iecho");
            System.out.println(iecho.getResponse("Jack"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
