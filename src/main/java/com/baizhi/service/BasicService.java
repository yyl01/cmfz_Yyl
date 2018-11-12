package com.baizhi.service;

import java.util.List;

public interface BasicService <T>{
    T login(T t);
    void add(T t);
    void remove(String id);
    void motify(T t);
    List<T> findAll();
    T findOne(String id);
    List<T> findByPage(int start,int rows);
    int findTotals();
}
