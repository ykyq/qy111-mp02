package com.service.impl;

import com.entity.User;
import com.dao.UserDao;
import com.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author AAATeacherChen
 * @since 2020-06-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
