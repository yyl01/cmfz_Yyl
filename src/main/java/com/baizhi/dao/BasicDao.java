package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasicDao <T>{
    void insert(T t);
    void delete(String id);
    void update(T t);
    List<T> queryAll();
    T queryOne(String id);
    int findTotals();
    List<T> queryByPage(@Param("start") int start,@Param("rows") int rows);

}
