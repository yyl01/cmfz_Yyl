package com.baizhi.service;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class CourseServiceImpl  implements CourseService{
    @Resource
    private CourseDao courseDao;
    @Override
    public Course login(Course course) {
        return null;
    }

    @Override
    public void add(Course course) {
        courseDao.insert(course);
    }

    @Override
    public void remove(String id) {
        courseDao.delete(id);
    }

    @Override
    public void motify(Course course) {

    }

    @Override
    public List<Course> findAll() {
        return courseDao.queryAll();
    }

    @Override
    public Course findOne(String id) {
        return null;
    }

    @Override
    public List<Course> findByPage(int start, int rows) {
        return null;
    }

    @Override
    public int findTotals() {
        return 0;
    }
}
