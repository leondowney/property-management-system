package com.property.management.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.property.management.entity.User;
import com.property.management.mapper.UserMapper;
import com.property.management.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

    @Override
    public Boolean userUpdate(User user) {
        String password = user.getPassword();
        if(password!=null){
            user.setPassword(SecureUtil.md5(password));
        }
        int line = userMapper.userUpdate(user);
        return line>0;
    }

    @Override
    public Boolean register(User user) {
        String password = user.getPassword();
        user.setPassword(SecureUtil.md5(password));
        return userMapper.insertUser(user);
    }
}
