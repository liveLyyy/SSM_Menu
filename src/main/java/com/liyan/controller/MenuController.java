package com.liyan.controller;

import com.liyan.pojo.Menu;
import com.liyan.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MenuController {
    @Resource
    private MenuService menuServiceImpl;

    /**
     *查询一级和二级目录
     */

    @RequestMapping(value = "/show",method = RequestMethod.POST)
    @ResponseBody
    public List<Menu> show(){
        return menuServiceImpl.show();
    }
}
