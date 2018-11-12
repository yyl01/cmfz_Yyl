package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import com.baizhi.util.FileUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("chapter")
public class ChapterController {
    @Resource
    private ChapterService chapterService;
    private String address="/store";
    @Resource
    private AlbumService albumService;
    @RequestMapping("save")
    public @ResponseBody Map<String,Object> save(String id, Chapter chapter,HttpServletRequest request,MultipartFile aa){
        Map<String,Object> results=new HashMap<String, Object>();
       try {
           String filename=FileUtil.saveFile(aa,address,request);
           String time=FileUtil.AudioLength(filename,request);
           chapter.setDuration(time);
           Double size=FileUtil.AudioSize(filename,request);
           chapter.setSize(size);
           chapter.setDownPath(filename);
           Album album = albumService.findOne(id);
           chapter.setAlbum(album);
           chapter.setId(UUID.randomUUID().toString());
           chapterService.add(chapter);
           results.put("success", true);
       }catch(Exception e){
           results.put("success",false);
           results.put("success",e.getMessage());
       }
        return results;
    }
    @RequestMapping("download")
    public void download(String openStyle, String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据接收的文件名去服务器中查找对应的文件
        String realName =request.getSession().getServletContext().getRealPath(fileName);
        File file = new File(realName);
        //以文件输入流读取文件
        InputStream is = new FileInputStream(file);
        // 设置响应头部信息
        response.setHeader("content-disposition", openStyle+";fileName="+ URLEncoder.encode(fileName, "UTF-8"));
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //使用工具类复制文件
        IOUtils.copy(is, os);
        //关闭流
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }

}
