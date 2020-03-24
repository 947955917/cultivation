package com.programming.cultivation.rpc.rpc02;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Stub stub = new Stub();
        System.out.println(stub.getUser(88));
    }
}
