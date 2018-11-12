package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerDao bannerDao;
    @Override
    public Banner login(Banner banner) {
        return null;
    }

    @Override
    public void add(Banner banner) {
        bannerDao.insert(banner);
    }

    @Override
    public void remove(String id) {
        bannerDao.delete(id);
    }

    @Override
    public void motify(Banner banner) {
        bannerDao.update(banner);
    }

    @Override
    public List<Banner> findAll() {
        return bannerDao.queryAll();
    }

    @Override
    public Banner findOne(String id) {
        return bannerDao.queryOne(id);
    }



    @Override
    public List<Banner> findByPage(int start, int rows) {
        int start1=(start-1)*rows;
        return bannerDao.queryByPage(start1,rows);
    }

    @Override
    public int findTotals() {
        return bannerDao.findTotals();
    }
}
