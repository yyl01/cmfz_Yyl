package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao extends BasicDao<User> {
    User queryBy(User user);
}

