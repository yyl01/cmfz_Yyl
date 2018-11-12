package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Resource
    private ChapterDao chapterDao;
    @Override
    public Chapter login(Chapter chapter) {
        return null;
    }

    @Override
    public void add(Chapter chapter) {
        System.out.println(chapter);
        try{chapterDao.insert(chapter);
        }catch (Exception e){
            e.printStackTrace();

        }


    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void motify(Chapter chapter) {

    }

    @Override
    public List<Chapter> findAll() {
        return null;
    }

    @Override
    public Chapter findOne(String id) {
        return null;
    }

    @Override
    public List<Chapter> findByPage(int start, int rows) {
        return null;
    }

    @Override
    public int findTotals() {
        return 0;
    }
}
