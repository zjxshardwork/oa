package com.project.oa.base.service;

import com.project.oa.base.bean.Menu;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: IMenuService
 * @Author: zhanghongkai
 * @Date: Create in 2019/3/5 15:45
 * @Version: 1.0
 */
public interface IMenuService {
    List<Menu> getMenu(Menu menu);
    List<Menu> getChildrenMenu(Menu menu);
    int addMenu(Menu menu);
    int updateMenu(Menu menu);
    Menu getMenuById(int id);
    int deleteMenu(int id);
    List<Menu> getUserMenu(HashMap map);
}
