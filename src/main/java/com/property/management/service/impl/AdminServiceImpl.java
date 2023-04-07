package com.property.management.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.property.management.contorller.AdminController;
import com.property.management.entity.Admin;
import com.property.management.entity.Role;
import com.property.management.entity.User;
import com.property.management.mapper.AdminMapper;
import com.property.management.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> queryByName(String username) {
        System.out.println(adminMapper.queryByName(username));
        return adminMapper.queryByName(username);
    }

    @Override
    public Long queryByNameCount(String username) {
        return adminMapper.queryByNameCount(username);
    }

    @Override
    public Boolean deleteAdminlById(Integer id) {
        int line = adminMapper.deleteAdminlById(id);
        return line>0;
    }

    @Override
    public Boolean deleteAdminByIds(String ids) {
        int line = adminMapper.deleteAdminByIds(ids);
        return line>0;
    }

    @Override
    public List<Role> queryRoleInfo() {
        return adminMapper.queryRoleInfo();
    }

    @Override
    public Boolean adminInsert(User user) {
        user.setPassword(SecureUtil.md5("123456"));
        user.setAvailable(1);
        user.setImg("722d7c31-dd96-421f-8b70-f57c7c629334.jpg");
        int line = adminMapper.adminInsert(user);
        return line>0;
    }

    @Override
    public Admin queryAdminById(Integer id) {
        return adminMapper.queryAdminById(id);
    }

    @Override
    public Boolean updateAdmin(User user) {
        String password = user.getPassword();
        if("123456".equals(password)){
            user.setPassword(SecureUtil.md5(password));
        }
        int line = adminMapper.updateAdmin(user);
        return line>0;
    }

    @Override
    public Boolean usernameCheck(String name) {
        User user = adminMapper.usernameCheck(name);
        return user!=null;
    }
}
