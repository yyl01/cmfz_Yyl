package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminDao adminDao;
    @Override
    public void add(Admin admin) {
        adminDao.insert(admin);
    }
    public Admin findByName(String name){return adminDao.queryByName(name);}

    @Override
    public void remove(String id) {

    }

    @Override
    public void motify(Admin admin) {

        adminDao.update(admin);
    }



    @Override
    public Admin findOne(String id) {
        return adminDao.queryOne(id);
    }

    @Override
    public List<Admin> findByPage(int start, int rows) {
        return null;
    }



    @Override
    public int findTotals() {
        return 0;
    }

    @Override
    public Admin login(Admin admin) {
       return adminDao.query(admin);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Admin> findAll() {
        return adminDao.queryAll();
    }
}

