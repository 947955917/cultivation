package com.programming.cultivation.jdk.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {


    public static void main(String[] args) throws Exception{
        Apple apple = new Apple();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    apple.getApple("A");
                    System.out.println("我是创建出来的线程");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        apple.getApple("B");
        System.out.println("我是主线程");
    }

    static class Apple{
        Lock lock = new ReentrantLock();

        public Apple getApple(String info) throws Exception{
            System.out.println(info + "Method getApple lock before");
            lock.lock();
            Thread.sleep(5000);
            System.out.println(info + "Method getApple lock after");
            lock.unlock();
            return new Apple();
        }

    }
}
