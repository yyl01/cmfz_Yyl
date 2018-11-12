package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("course")
public class CourseController {
    @Resource
    private CourseService courseService;
    @RequestMapping("showAll")
    public @ResponseBody List<Course> showAll(){

        List<Course> courses=courseService.findAll();
       return courses;


    }

    @RequestMapping("save")
    public @ResponseBody Map<String,Object> save(Course course){
        Map<String,Object> results=new HashMap<String, Object>();
        try{
            course.setId(UUID.randomUUID().toString());
            courseService.add(course);
            results.put("success",true);
        }catch (Exception e){
            results.put("success",false);
            results.put("success",e.getMessage());
        }
        return results;
    }

    @RequestMapping("deleteAll")
    public @ResponseBody void deleteAll(String[] id){
        for(int i=0;i<id.length;i++){
            courseService.remove(id[i]);
        }

    }
}
