package com.future.desk.services;

import com.future.desk.model.Users;
import com.future.desk.params.UsersParam;

public interface UsersService {

    /**
     * 注册用户
     */
    boolean registerUser(UsersParam user);

    /**
     *
     * @param usersParam
     * @return
     */
    UsersParam loginUser(UsersParam usersParam);

}
