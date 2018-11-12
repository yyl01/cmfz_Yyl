package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao extends BasicDao<Admin>{
    Admin query(Admin admin);
    void update(Admin admin);
    Admin queryByName(String name);
}
