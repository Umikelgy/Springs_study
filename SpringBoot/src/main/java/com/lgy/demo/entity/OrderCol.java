package com.lgy.demo.entity;


import java.util.List;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/9/3 10:48
 */

public class OrderCol {

    private String title;
    private String description;
    private String by;
    private String url;
    private List<Tags> tags;
    private Integer like;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

}
