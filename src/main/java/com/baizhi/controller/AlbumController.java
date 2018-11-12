package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Article;
import com.baizhi.service.AdminService;
import com.baizhi.service.AlbumService;
import org.aspectj.util.FileUtil;
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
@RequestMapping("album")
public class AlbumController {
    @Resource
    private AlbumService albumService;
    @RequestMapping("showAll")
    public @ResponseBody List<Album> showAll(){
       albumService.findAll();

        return albumService.findAll();
    }
    @RequestMapping("save")
    public @ResponseBody Map<String,Object> save(Album album, MultipartFile aa, HttpServletRequest request){
        Map<String,Object> results=new HashMap<String, Object>();
        String fileName= UUID.randomUUID().toString()+aa.getOriginalFilename();
        try{
            String realPath=request.getRealPath("/store");
            aa.transferTo(new File(realPath,fileName));
            album.setId(UUID.randomUUID().toString());
            album.setCoverImg(fileName);
            albumService.add(album);
            results.put("success",true);

        }catch(Exception e){
            results.put("success",false);

        }
        return results;
    }
    @RequestMapping("findOne")
    public @ResponseBody
    Album findOne(String id){
        albumService.findOne(id);
        return albumService.findOne(id);
    }
}
