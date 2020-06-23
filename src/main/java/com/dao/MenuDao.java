package com.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author AAATeacherChen
 * @since 2020-06-14
 */
@Repository
@Mapper
public interface MenuDao extends BaseMapper<Menu> {
    List<Menu> findMenusByLoginName(@Param("loginName") String loginName);

}
