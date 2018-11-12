package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})

public class BannerTest {
    @Resource
    private BannerService bannerService;
    @Test
    public void testBanner(){
        bannerService.findAll();
        System.out.println( bannerService.findAll());
    }
    @Test
    public void testfindpage(){
        bannerService.findByPage(0,1);
        System.out.println(  bannerService.findByPage(0,1));
    }
    @Test
    public void testinsert(){
        Banner banner=new Banner("2","df","ffs","f",null);
        bannerService.add(banner);
    }
    @Test
    public void testupdate(){
        Banner banner=new Banner("2","ggg","ffs","f",null);
        bannerService.motify(banner);
    }

}
