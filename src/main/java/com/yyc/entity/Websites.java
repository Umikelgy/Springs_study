package com.yyc.entity;

import java.io.Serializable;

public class Websites implements Serializable {
    private Integer id;

    private String name;

    private String url;

    private Integer alexa;

    private String country;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getAlexa() {
        return alexa;
    }

    public void setAlexa(Integer alexa) {
        this.alexa = alexa;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }
}