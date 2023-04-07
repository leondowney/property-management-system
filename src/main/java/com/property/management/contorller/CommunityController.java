package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Community;
import com.property.management.entity.RespBean;
import com.property.management.service.CommunityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 小区列表相关请求
 */

@Controller
@MultipartConfig
public class CommunityController {

    @Autowired
    private CommunityService communityService;
    private String imgString = null;
    private String imgUrl = null;


    //添加按钮  跳转到communityadd.jsp页面
    @RequestMapping("communityadd")
    public String communityadd() {

        return "community/communityadd";
    }


    @RequestMapping("communitylist")
    public String queryByName(String communityName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
        //查询单个或多个
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Community> community = communityService.queryByName(communityName, startTime, endTime);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("communityName", communityName);

        //pageInfo:将分页数据和显示的数据封装到PageInfo当中
        PageInfo<Community> pageInfo = new PageInfo<>(community);

        Long count = communityService.queryByNameCount(communityName, startTime, endTime);
        System.out.println("list = " + community);
        model.addAttribute("commList", community);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "community/communitylist";
    }


    //编辑按钮点击    跳转到communityupdate.jsp页面
    @RequestMapping("/communityupdate")
    public String communityupdate(Integer id, Model model) {
        Community community = communityService.queryById(id);
        model.addAttribute("comm", community);
        return "community/communityupdate";
    }


    //监听保存按钮进行数据更新
    @RequestMapping("updateCommunity")
    @ResponseBody
    public Object updateCommunity(Community community) {
        community.setImg(imgString);
        System.out.println("--------------------------------------------------------");
        System.out.println("community = " + community);
        Boolean b = communityService.updateCommunity(community);
        HashMap<String, Object> map = new HashMap<>();
        if (b) {
            map.put("info", "用户更新成功");
            map.put("status", 200);

        } else {
            map.put("info", "用户更新失败");
            map.put("status", 500);
        }
        return map;
    }




    //单独删除
    @RequestMapping("deleteById/{id}")
    @ResponseBody
    public Object deleteById(@PathVariable("id") Integer id) {
        Boolean b = communityService.deleteById(id);
        HashMap<String, Object> map = new HashMap<>();
        if (b) {
            map.put("info", "用户删除成功");
            map.put("status", 200);
        } else {
            map.put("info", "用户删除失败");
            map.put("status", 500);
        }
        return map;
    }


    //批量删除
    @RequestMapping("deleteCommunityByIds/{ids}")
    @ResponseBody
    //PathVariable获取路径参数
    public Object deleteCommunityByIds(@PathVariable("ids") String ids) {
        Boolean b = communityService.deleteCommunityByIds(ids);
        HashMap<String, Object> map = new HashMap<>();
        if (b) {
            map.put("info", "用户删除成功");
            map.put("status", 200);
        } else {
            map.put("info", "用户删除失败");
            map.put("status", 500);
        }
        return map;
    }


    //添加信息
//    @RequestMapping("communityInsert")
//    @ResponseBody
//    public Object communityInsert(Community community) {
//        System.out.println("community = " + community);
//        String address = community.getAddress();
//        System.out.println("address = " + address);
//        Integer line = communityService.insertInfo(community);
//        HashMap<String, Object> map = new HashMap<>();
//        if (line > 0) {
//            map.put("info", "用户添加成功");
//            map.put("status", 200);
//        } else {
//            map.put("info", "用户添加失败");
//            map.put("status", 500);
//        }
//        return map;
//    }


    @RequestMapping("/communityInsert")
    @ResponseBody
    public RespBean add(Community community) {

        Date date = new Date();
        community.setHiredate(date);
        System.out.println("imgString = " + imgString);
        community.setImg(imgString);
        Integer result = communityService.insertInfo(community);
        RespBean respBean = null;
        if (result == 1) {
            respBean = RespBean.ok("添加成功");
        } else {
            respBean = RespBean.error("添加失败");
        }
        return respBean;
    }


    //监听图片的上传按钮进行上传图片
    @PostMapping("/communityImgInsert")
    @ResponseBody
    public Map<String, String> fileupload(MultipartFile img, HttpServletRequest req, Model model) {
        Map<String, String> result = new HashMap<>();
        String oldName = img.getOriginalFilename();
        String realPath = req.getServletContext().getRealPath("/images");
        System.out.println("realPath = " + realPath);

        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            img.transferTo(new File(folder, newName));
            String tomcatUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/images/" + newName;
            System.out.println("url = " + tomcatUrl);
            result.put("status", "200");
            result.put("newName", newName);
            imgString = newName;
            result.put("url", tomcatUrl);

            imgUrl = tomcatUrl;
            System.out.println("url = " + tomcatUrl);
        } catch (IOException e) {
            result.put("status", "500");
            result.put("msg", e.getMessage());
        }
        return result;
    }
}