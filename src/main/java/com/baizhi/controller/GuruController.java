package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
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
@RequestMapping("guru")
public class GuruController {
    @Resource
    private GuruService guruService;
    @RequestMapping("showAll")
    public @ResponseBody Map<String,Object> showAll(int page, int rows){
        Map<String,Object> results=new HashMap<String, Object>();
        List<Guru> gurus=guruService.findByPage(page,rows);
        int totals=guruService.findTotals();
        results.put("total",totals);
        results.put("rows",gurus);
        return results;
    }
    @RequestMapping("show")
    public @ResponseBody List<Guru> show(){
        guruService.findAll();
        return  guruService.findAll();
    }
    @RequestMapping("delete")
    public @ResponseBody void delete(String id){
        Map<String,Object> results=new HashMap<String, Object>();
        guruService.remove(id);
    }
    @RequestMapping("save")
    public @ResponseBody Map<String,Object> save(Guru guru, MultipartFile aa, HttpServletRequest request){
        Map<String,Object> results=new HashMap<String, Object>();
        String fileName= UUID.randomUUID().toString()+aa.getOriginalFilename();
        try{
            String realPath=request.getRealPath("/guru_headPic");
            aa.transferTo(new File(realPath,fileName));
            guru.setId(UUID.randomUUID().toString());
            guru.setHeadPic(fileName);

            guruService.add(guru);
            results.put("success",true);

        }catch(Exception e){
            results.put("success",false);
            results.put("success","添加失败");
        }
        return results;
    }
    @RequestMapping("change")
    public @ResponseBody Map<String,Object> change(Guru guru){
        Map<String,Object> results=new HashMap<String, Object>();
        System.out.println(guru);
        try{
            guruService.motify(guru);
            results.put("success",true);
        }catch(Exception e){
            results.put("success",false);
            results.put("success", e.getMessage());
        }
        return results;
    }
    @RequestMapping("findOne")
    public @ResponseBody
    Guru findOne(String id){
        guruService.findOne(id);
        return guruService.findOne(id);
    }
    @RequestMapping("deleteAll")
    public @ResponseBody void deleteAll(String[] id){
        for(int i=0;i<id.length;i++){
            guruService.remove(id[i]);
        }

    }
}
