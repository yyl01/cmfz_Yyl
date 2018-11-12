package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    private String id;
    private String title;
    private String imgPath;
    private String content;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JSONField(format = "MM/dd/yyyy")
    private Date pdDate;
    private String guru_id;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPdDate() {
        return pdDate;
    }

    public void setPdDate(Date pdDate) {
        this.pdDate = pdDate;
    }

    public String getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(String guru_id) {
        this.guru_id = guru_id;
    }

    public Article(String id, String title, String imgPath, String content, Date pdDate,String guru_id) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.content = content;
        this.pdDate = pdDate;
        this.guru_id = guru_id;
    }

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", content='" + content + '\'' +
                ", pdDate=" + pdDate +
                ", guru_id=" + guru_id +
                '}';
    }
}
