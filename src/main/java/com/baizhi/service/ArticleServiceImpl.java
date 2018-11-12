package com.baizhi.service;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
    @Resource
    private ArticleDao articleDao;
    @Override
    public Article login(Article article) {
        return null;
    }

    @Override
    public void add(Article article) {
        articleDao.insert(article);
    }

    @Override
    public void remove(String id) {
        articleDao.delete(id);
    }

    @Override
    public void motify(Article article) {
        articleDao.update(article);
    }

    @Override
    public List<Article> findAll() {
        return articleDao.queryAll();
    }

    @Override
    public Article findOne(String id) {
        return articleDao.queryOne(id);
    }

    @Override
    public List<Article> findByPage(int start, int rows) {
        int start1=(start-1)*rows;
        return articleDao.queryByPage(start1,rows);
    }

    @Override
    public int findTotals() {
        return articleDao.findTotals();
    }
}
