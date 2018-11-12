package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.Format;
import java.util.Date;

public class Course {
    private String id;
    private String title;
    private String mark;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JSONField(format = "MM/dd/yyyy")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Course() {
    }

    public Course(String id, String title, String mark, Date createTime) {
        this.id = id;
        this.title = title;
        this.mark = mark;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", mark='" + mark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
