package com.programming.cultivation.rpc.rpc03;

import com.programming.cultivation.rpc.common.IUserService;
import com.programming.cultivation.rpc.common.User;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class UserServiceImpl implements IUserService {

    @Override
    public User getUser(Integer id) {
        return new User(id, "jack");
    }

    @Override
    public void saveUser(User user) {

    }
}
