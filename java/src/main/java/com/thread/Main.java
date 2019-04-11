package com.thread;

/**
 * @author jzx
 * @date 2019/02/15 09:39
 * @Description:
 */

class MyThread implements Runnable {
    public  Integer sleepTime=2000;
    public MyThread(Integer sleepTime){
        this.sleepTime=sleepTime;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"开始执行");
            System.out.println(Thread.currentThread().getName()+"休眠"+sleepTime);
            Thread.sleep(sleepTime);
            System.out.println(Thread.currentThread().getName()+"结束执行");
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

public class Main {
    public static void main(String[] argv) throws Exception {
        
        Thread.currentThread().setName("主进程");
        
        MyThread thread1=new MyThread(30000);
        Thread t1 = new Thread(thread1);
        t1.setName("A线程");
        t1.start();
        
    
        MyThread thread2=new MyThread(20000);
        Thread t2 = new Thread(thread2);
        t2.setName("B线程");
        t2.start();
        
     
        while (1==1){
        
        }
        
    }
}
