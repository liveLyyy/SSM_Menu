package com.liyan.service.Impl;

import com.liyan.mapper.MenuMapper;
import com.liyan.pojo.Menu;
import com.liyan.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<Menu> show() {
        return menuMapper.findByPid(0);
    }
}
