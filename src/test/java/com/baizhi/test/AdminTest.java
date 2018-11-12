package com.baizhi.test;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.service.MenuService;
import com.baizhi.util.FileUtil;
import com.baizhi.util.SaltUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})

public class AdminTest {
    @Resource
    private AdminService adminService;
    @Test
    public void testAdmin(){
        adminService.findAll();
        System.out.println(adminService.findAll());
    }
    @Test
    public void testinsert(){
        String password="123456";
        String salt=SaltUtils.getSalt(4);
       String hex= DigestUtils.md5Hex(password+salt);
        Admin admin=new Admin();
        admin.setId(UUID.randomUUID().toString());
        admin.setName("qqq");
        admin.setPassword(hex);
        admin.setSalt(salt);
       adminService.add(admin);

    }



}
