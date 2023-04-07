package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Community;
import com.property.management.entity.Park;
import com.property.management.service.ParkService;
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
 * @describe： 车位管理相关请求
 */
@Controller
public class ParkController {

    @Autowired
    private ParkService parkService;


    //查所有然后进行分页查询
    @RequestMapping("parklist")
    public String queryByName(String parkName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
        //查询单个或多个
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Park> parks = parkService.queryByName(parkName, startTime, endTime);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("parkName", parkName);

        //pageInfo:将分页数据和显示的数据封装到PageInfo当中
        PageInfo<Park> pageInfo = new PageInfo<>(parks);

        Long count = parkService.queryByNameCount(parkName, startTime, endTime);
        System.out.println("list = " + parks);
        System.out.println("------------------------------------------------------------");
        model.addAttribute("parks", parks);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "park/parklist";
    }


    //添加按钮  跳转到park_add.jsp页面
    @RequestMapping("parkadd")
    public String parkadd(Model model) {
        List<Community> communities = parkService.queryCommunityInfo(null);
        System.out.println("communities = " + communities);
        model.addAttribute("communityInfo", communities);
        return "park/parkadd";
    }


    //跳转到parkadd.jsp页面然后写parkadd接口
    @RequestMapping("parkInsert")
    @ResponseBody
    public Object insertInfo(Park park) {
        boolean b = parkService.insertInfo(park);
        HashMap<String, Object> map = new HashMap<>();
        if (b) {
            map.put("status", 200);
            map.put("info", "用户添加成功");
        } else {
            map.put("status", 500);
            map.put("info", "用户添加失败");
        }
        return map;
    }


    //单个删除
    @RequestMapping("deleteParkById")
    @ResponseBody
    public Object deleteById(Integer id) {
        Boolean b = parkService.deleteById(id);
        HashMap<String, Object> map = new HashMap<>();
        if (b) {
            map.put("status", 200);
            map.put("info", "用户删除成功");
        } else {
            map.put("status", 500);
            map.put("info", "用户删除失败");
        }
        return map;
    }


    //批量删除
    @RequestMapping("deleteParkByIds/{ids}")
    @ResponseBody
    public Object deleteByIds(@PathVariable("ids") String ids) {
        Boolean b = parkService.deleteByIds(ids);
        System.out.println(ids);
        HashMap<String, Object> map = new HashMap<>();
        if (b) {
            map.put("status", "200");
            map.put("info", "用户删除成功");
        } else {
            map.put("status", "500");
            map.put("info", "用户删除失败");
        }
        return map;
    }


    //编辑按钮点击    跳转到parkupdate.jsp页面
    @RequestMapping("parkupdate")
    public String parkupdate(Integer id, Model model) {
        List<Community> community = parkService.queryCommunityInfo(null);
        Park parkInfo = parkService.queryId(id);
        model.addAttribute("parkInfo",parkInfo);
        model.addAttribute("communityInfo",community);
        return "park/parkupdate";
    }



    //监听保存按钮进行数据更新
  @RequestMapping("updatePark")
    @ResponseBody
    public Object updatePark(Park park){
      Boolean b =  parkService.updatePark(park);
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



}
