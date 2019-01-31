package com.ref;

import java.lang.reflect.InvocationTargetException;

/**
 * @author jzx
 * @date 2019/01/30 10:27
 * @Description:
 */

public class Main {
   
    public static void main(String[] argv){
        ClassLoader classLoader = Main.class.getClassLoader();
        try {
           Class aClass=classLoader.loadClass("com.ref.TestInterfaceImpl");
           TestInterface testInterface=(TestInterface) aClass.getDeclaredConstructor().newInstance();
           testInterface.test();
        }catch (ClassNotFoundException e){
        
        }catch (InstantiationException e){
        
        }catch (IllegalAccessException e){
        
        }catch (NoSuchMethodException e){
        
        }catch (InvocationTargetException e){
        
        }
     
    
    }
}
