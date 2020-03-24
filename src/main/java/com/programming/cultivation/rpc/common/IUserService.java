package com.programming.cultivation.rpc.common;

/**
 * @author biyue
 * @since 2020/03/24
 */
public interface IUserService {

    User getUser(Integer id);

    void saveUser(User user);
}
