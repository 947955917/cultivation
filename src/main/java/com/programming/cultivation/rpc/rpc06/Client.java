package com.programming.cultivation.rpc.rpc06;

import com.programming.cultivation.rpc.common.IUserService;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class Client {

    public static void main(String[] args) throws Exception {

        IUserService stub = Stub.proxy(IUserService.class);
        System.out.println(stub.getUser(156));
        // stub.saveUser(new User(555, "小明"));
    }
}
