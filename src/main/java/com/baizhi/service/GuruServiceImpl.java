package com.baizhi.service;

import com.baizhi.dao.GuruDao;
import com.baizhi.entity.Guru;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class GuruServiceImpl implements GuruService {
    @Resource
    private GuruDao guruDao;
    @Override
    public Guru login(Guru guru) {
        return null;
    }

    @Override
    public void add(Guru guru) {
        guruDao.insert(guru);

    }

    @Override
    public void remove(String id) {
        guruDao.delete(id);

    }

    @Override
    public void motify(Guru guru) {
        guruDao.update(guru);
    }

    @Override
    public List<Guru> findAll() {

        return guruDao.queryAll();
    }

    @Override
    public Guru findOne(String id) {
        return guruDao.queryOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findByPage(int start, int rows) {
        int start1=(start-1)*rows;
        return guruDao.queryByPage(start1,rows);
    }

    @Override
    public int findTotals() {
        return guruDao.findTotals();
    }
}
