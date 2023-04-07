package com.property.management.mapper;

import com.property.management.entity.User;
import org.apache.ibatis.annotations.Param;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface UserMapper {
    User login(@Param("username") String username,@Param("password") String password);

    Boolean insertUser(User user);

    int userUpdate(User user);
}
