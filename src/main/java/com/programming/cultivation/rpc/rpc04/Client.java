package com.programming.cultivation.rpc.rpc04;

import com.programming.cultivation.rpc.common.IUserService;
import com.programming.cultivation.rpc.common.User;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class Client {

    public static void main(String[] args) throws Exception {

        IUserService stub = Stub.getStub();
        System.out.println(stub.getUser(156));
        // stub.saveUser(new User(555, "小明"));
    }
}
