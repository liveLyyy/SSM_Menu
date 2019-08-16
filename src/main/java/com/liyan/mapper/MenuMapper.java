package com.liyan.mapper;

import com.liyan.pojo.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> findByPid(Integer id);
}
