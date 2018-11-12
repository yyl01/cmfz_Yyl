package com.baizhi.service;


import com.baizhi.entity.Admin;

public interface AdminService extends BasicService <Admin>{
    Admin findByName(String name);
}
