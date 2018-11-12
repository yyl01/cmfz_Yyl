package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    @Override
    public User login(User user) {
        userDao.queryBy(user);
        return userDao.queryBy(user);
    }

    @Override
    public void add(User user) {
        userDao.insert(user);
    }

    @Override
    public void remove(String id) {
        userDao.delete(id);
    }

    @Override
    public void motify(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findOne(String id) {
        return null;
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        return null;
    }

    @Override
    public int findTotals() {
        return 0;
    }
}
