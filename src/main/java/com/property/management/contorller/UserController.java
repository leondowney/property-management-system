package com.property.management.contorller;

import cn.hutool.captcha.LineCaptcha;
import cn.hutool.crypto.SecureUtil;
import com.property.management.entity.User;
import com.property.management.service.UserService;
import com.property.management.util.LayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 登陆相关请求
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    private String imgString = null;
    private String imgUrl = null;
    @RequestMapping("captcha")
    public void captcha(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LineCaptcha lineCaptcha = new LineCaptcha(260, 100, 4, 5);
        String code = lineCaptcha.getCode();
        req.getSession().setAttribute("code", code);
        ServletOutputStream outputStream = resp.getOutputStream();

        lineCaptcha.write(outputStream);
        outputStream.close();
    }

    @RequestMapping("login")
    @ResponseBody
    public LayUtil login(String username, String password, String code, HttpSession session) {
        LayUtil layUtil = new LayUtil();
        User user = userService.login(username, SecureUtil.md5(password));
        System.out.println(code);
        if (session.getAttribute("code").equals(code)) {
            if (user != null) {
                if(user.getAvailable()==1){
                    layUtil.setCode("0");
                    layUtil.setMsg("登录成功！");
                    session.setAttribute("user", user);
                }else{
                    layUtil.setCode("500");
                    layUtil.setMsg("抱歉你的访问权限被关闭，请联系高级管理员");
                }
            } else {
                layUtil.setCode("500");
                layUtil.setMsg("用户名或者密码输入错误！");
            }
        } else {
            layUtil.setCode("500");
            layUtil.setMsg("验证码输入不正确！");
        }
        return layUtil;
    }

    @RequestMapping("logout")
    @ResponseBody
    public Object logout(HttpSession httpSession) {
        HashMap<String, Object> map = new HashMap<>();
        httpSession.invalidate();
        map.put("code", 200);
        map.put("info", "退出成功");
        return map;
    }


    @RequestMapping("register")
    @ResponseBody
    public Object register(User user) {
        Boolean b = userService.register(user);
        HashMap<String, Object> map = new HashMap<>();
        if (b) {
            map.put("code", 0);
            map.put("msg", "注册成功");
        } else {
            map.put("code", 500);
            map.put("msg", "注册失败");
        }
        return map;
    }
    @RequestMapping("userUpdate")
    @ResponseBody
    public Object userUpdate(User user){
        HashMap<String, Object> map = new HashMap<>();
        user.setImg(imgString);
        System.out.println(user);
        Boolean b = userService.userUpdate(user);
        if(b){
            map.put("code", 200);
            map.put("msg", "个人信息更新成功");
        }else{
            map.put("code", 200);
            map.put("msg", "个人信息更新失败");
        }
        return map;
    }
    @RequestMapping("userImgInsert")
    @ResponseBody
    public Object userImgInsert(MultipartFile img,HttpServletRequest req){
        HashMap<String, String> map = new HashMap<>();
        String Filename = img.getOriginalFilename();
        String realPath = req.getServletContext().getRealPath("/userImg");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }

        String newName = UUID.randomUUID().toString()+Filename.substring(Filename.lastIndexOf("."));
        try {
            img.transferTo(new File(file,newName));
            String url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/userImg/"+newName;
            System.out.println("url = " + url);
            map.put("status","200");
            map.put("newName",newName);
            imgString=newName;
            map.put("url",url);
            imgUrl=url;
        } catch (IOException e) {
            map.put("status","500");
            map.put("msg",e.getMessage());
        }
        return map;
    }
    @RequestMapping("checkPassword")
    @ResponseBody
    public Object checkPassword(String oldPassword,HttpSession session){
        HashMap<String, Object> map = new HashMap<>();
        User user = (User)session.getAttribute("user");
        if(SecureUtil.md5(oldPassword).equals(user.getPassword())){
            map.put("code",200);
            map.put(("info"),"原始密码验证通过");
        }else{
            map.put("code",500);
            map.put(("info"),"原始密码验证未通过");
        }
        return map;
    }
}


