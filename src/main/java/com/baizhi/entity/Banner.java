package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Banner {
    private String id;
    private String title;
    private String imgPath;
    private String status;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JSONField(format = "MM/dd/yyyy")
    private Date date;

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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Banner(String id, String title, String imgPath, String status, Date date) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.status = status;
        this.date = date;
    }

    public Banner() {
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
