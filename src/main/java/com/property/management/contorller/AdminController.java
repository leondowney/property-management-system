package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Admin;
import com.property.management.entity.Device;
import com.property.management.entity.Role;
import com.property.management.entity.User;
import com.property.management.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 管理员管理相关请求
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("admin_list")
    public String admin_list(String username, Model model, @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Admin> admins = adminService.queryByName(username);
        model.addAttribute("username",username);
        PageInfo<Admin> pageInfo = new PageInfo<>(admins);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = adminService.queryByNameCount(username);
        model.addAttribute("adminList", admins);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "mannage/adminList";
    }
    @RequestMapping("deleteAdminlById")
    @ResponseBody
    public Object deleteAdminlById(Integer id){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = adminService.deleteAdminlById(id);
        if(b){
            map.put("code",200);
            map.put("info","删除成功");
        }else {
            map.put("code",500);
            map.put("info","删除失败");
        }
        return map;
    }
    @RequestMapping("deleteAdminByIds/{ids}")
    @ResponseBody
    public Object deleteAdminByIds(@PathVariable("ids") String ids){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = adminService.deleteAdminByIds(ids);
        if(b){
            map.put("code",200);
            map.put("info","批量删除成功");
        }else {
            map.put("code",500);
            map.put("info","批量删除失败");
        }
        return map;
    }
    @RequestMapping("admin_add")
    public String admin_add(Model model){
        List<Role> roles = adminService.queryRoleInfo();
        model.addAttribute("rolelist",roles);
        return "mannage/adminAdd";
    }
    @RequestMapping("adminInsert")
    @ResponseBody
    public Object adminInsert(User user){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = adminService.adminInsert(user);
        if(b){
            map.put("code",200);
            map.put("info","添加成功");
        }else {
            map.put("code",500);
            map.put("info","添加失败");
        }
        return map;
    }
    @RequestMapping("admin_edit")
    public String admin_edit(Integer id,Model model){
        Admin admin = adminService.queryAdminById(id);
        List<Role> roles = adminService.queryRoleInfo();
        model.addAttribute("admin",admin);
        model.addAttribute("rolelist",roles);
        return "mannage/adminEdit";
    }
    @RequestMapping("updateAdmin")
    @ResponseBody
    public Object updateAdmin(User user){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = adminService.updateAdmin(user);
        if(b){
            map.put("code",200);
            map.put("info","编辑成功");
        }else {
            map.put("code",500);
            map.put("info","编辑失败");
        }
        return map;
    }
    @RequestMapping("usernameCheck")
    @ResponseBody
    public Object usernameCheck(String name){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = adminService.usernameCheck(name);
        if(b){
            map.put("code",200);
            map.put("info","该用户名已被使用");
        }else {
            map.put("code",500);
            map.put("info","该用户名可以使用");
        }
        return map;
    }
}
