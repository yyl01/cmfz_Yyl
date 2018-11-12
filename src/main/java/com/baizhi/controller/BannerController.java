package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("banner")
public class BannerController {
    @Resource
    private BannerService bannerService;
    @RequestMapping("showAll")
    public @ResponseBody Map<String,Object> showAll(int page,int rows){
        Map<String,Object> results=new HashMap<String, Object>();
        List<Banner> banners=bannerService.findByPage(page,rows);
        int totals=bannerService.findTotals();
        results.put("total",totals);
        results.put("rows",banners);
        return results;
    }
    @RequestMapping("delete")
    public @ResponseBody void delete(String id){
        Map<String,Object> results=new HashMap<String, Object>();
            bannerService.remove(id);
    }
    @RequestMapping("save")
    public @ResponseBody Map<String,Object> save(Banner banner, MultipartFile aa, HttpServletRequest request){
        Map<String,Object> results=new HashMap<String, Object>();
        String fileName= UUID.randomUUID().toString()+aa.getOriginalFilename();
        try{
            String realPath=request.getRealPath("/images");
            aa.transferTo(new File(realPath,fileName));
           banner.setId(UUID.randomUUID().toString());
            System.out.println(aa);
           banner.setImgPath(fileName);
           bannerService.add(banner);
            results.put("success",true);

        }catch(Exception e){

            results.put("success",false);
            results.put("success","添加失败");
        }
        return results;
    }
    @RequestMapping("change")
    public @ResponseBody Map<String,Object> change(Banner banner){
        Map<String,Object> results=new HashMap<String, Object>();
        try{
            bannerService.motify(banner);
            results.put("success",true);

        }catch(Exception e){
            results.put("success",false);
            results.put("success","修改失败");
        }
        return results;
    }
    @RequestMapping("findOne")
    public @ResponseBody Banner findOne(String id){
        bannerService.findOne(id);
        return bannerService.findOne(id);
    }
    @RequestMapping("deleteAll")
    public @ResponseBody void deleteAll(String[] id){
        for(int i=0;i<id.length;i++){
            bannerService.remove(id[i]);
        }

    }
}
