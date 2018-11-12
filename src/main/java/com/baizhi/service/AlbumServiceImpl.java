package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Album;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
    @Resource
    private AlbumDao albumDao;
    @Override
    public Album login(Album album) {
        return null;
    }

    @Override
    public void add(Album album) {
        albumDao.insert(album);
    }

    @Override
    public void remove(String id) {
        albumDao.delete(id);
    }

    @Override
    public void motify(Album album) {
        albumDao.update(album);
    }

    @Override
    public List<Album> findAll() {
        return albumDao.queryAll();
    }

    @Override
    public Album findOne(String id) {
        return albumDao.queryOne(id);
    }

    @Override
    public List<Album> findByPage(int start, int rows) {
        int start1=(start-1)*rows;
        return albumDao.queryByPage(start1,rows);
    }

    @Override
    public int findTotals() {
        return albumDao.findTotals();
    }
}
