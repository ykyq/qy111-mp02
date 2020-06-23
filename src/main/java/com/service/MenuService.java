package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.LayUiTree;
import com.entity.Menu;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author AAATeacherChen
 * @since 2020-06-14
 */
public interface MenuService extends IService<Menu> {
    List<LayUiTree> findMenus(String loginName);

}
