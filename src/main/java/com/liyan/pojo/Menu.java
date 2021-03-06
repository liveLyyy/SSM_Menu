package com.liyan.pojo;

import java.util.List;

public class Menu {
    private Integer id;
    private String name;
    private Integer pid;
    private List<Menu> childre;

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
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Menu> getChildre() {
        return childre;
    }

    public void setChildre(List<Menu> childre) {
        this.childre = childre;
    }
}
