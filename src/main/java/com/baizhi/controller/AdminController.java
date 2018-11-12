package com.baizhi.controller;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    @RequestMapping("login")
    public String login(HttpServletRequest request, Admin admin, HttpSession session,String code){
        Admin admin1= adminService.findByName(admin.getName());
        String salt=admin1.getSalt();
        String hex= DigestUtils.md5Hex(admin.getPassword()+salt);
        admin.setPassword(hex);
        if(session.getAttribute("code").equals(code)) {
            if (adminService.login(admin) != null) {
                session.setAttribute("admin",adminService.login(admin));
                return "redirect:/main/main.jsp";
            }
            else {
                return "redirect:/error.jsp";
            }
        }else{
            return "redirect:/error.jsp";
        }
    }
    @RequestMapping("exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "redirect:/main/main.jsp";
    }
    @RequestMapping("change")
    public @ResponseBody Map<String,Object> change(Admin admin,String oldpassword,HttpSession session){
        Map<String,Object> result=new HashMap<String,Object>();
        Admin admin2=(Admin)session.getAttribute("admin");
        String salt=admin2.getSalt();
        String hex= DigestUtils.md5Hex(oldpassword+salt);
        try {
            System.out.println(hex);
            if(hex.equals(admin2.getPassword())){
                String hex1= DigestUtils.md5Hex(admin.getPassword()+salt);
                admin.setPassword(hex1);
            adminService.motify(admin);
            result.put("success",true);
            }else{
                result.put("success",false);
                result.put("success","原密码错误");
            }

        }catch(Exception e){
            result.put("success",false);
            result.put("success","密码修改失败");
        }
        return result;

    }
}
