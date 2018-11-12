package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
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
@RequestMapping("article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @RequestMapping("showAll")
    public @ResponseBody
    Map<String,Object> showAll(int page, int rows){
        Map<String,Object> results=new HashMap<String, Object>();
        List<Article> articles=articleService.findByPage(page,rows);
        int totals=articleService.findTotals();
        results.put("total",totals);
        results.put("rows",articles);
        return results;
    }
    @RequestMapping("delete")
    public @ResponseBody void delete(String id){
        Map<String,Object> results=new HashMap<String, Object>();
        articleService.remove(id);
    }
    @RequestMapping("save")
    public @ResponseBody Map<String,Object> save(Article article, MultipartFile aa, HttpServletRequest request){
        Map<String,Object> results=new HashMap<String, Object>();
        String fileName= UUID.randomUUID().toString()+aa.getOriginalFilename();
        try{
            String realPath=request.getRealPath("/images");
            aa.transferTo(new File(realPath,fileName));
            article.setId(UUID.randomUUID().toString());
            article.setImgPath(fileName);
            articleService.add(article);
            results.put("success",true);

        }catch(Exception e){
            results.put("success",false);
            results.put("success","添加失败");
        }
        return results;
    }
    @RequestMapping("change")
    public @ResponseBody Map<String,Object> change(Article article){
        Map<String,Object> results=new HashMap<String, Object>();
        System.out.println(article);
        try{
            articleService.motify(article);
            results.put("success",true);
        }catch(Exception e){
            results.put("success",false);
            results.put("success", e.getMessage());
        }
        return results;
    }
    @RequestMapping("findOne")
    public @ResponseBody
    Article findOne(String id){
        articleService.findOne(id);
        return articleService.findOne(id);
    }
    @RequestMapping("deleteAll")
    public @ResponseBody void deleteAll(String[] id){
        for(int i=0;i<id.length;i++){
            articleService.remove(id[i]);
        }

    }

}
