package com.baizhi.service;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService{
    @Resource
    private MenuDao menuDao;
    @Override
    public List<Menu> findAll() {
        menuDao.queryAll();
        return  menuDao.queryAll();
    }
}
