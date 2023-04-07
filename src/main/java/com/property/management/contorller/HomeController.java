package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Building;
import com.property.management.entity.Community;
import com.property.management.entity.Home;
import com.property.management.service.HomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 房产管理相关请求
 */
@Controller
public class HomeController {
    @Autowired
    private HomeService homeService;

    @RequestMapping("/homelist")
    public String buildinglist(String houseName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
        //查询单个或多个
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Home> house = homeService.query(houseName, startTime, endTime);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("houseName", houseName);
        PageInfo<Home> pageInfo = new PageInfo<>(house);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = homeService.queryCount(houseName, startTime, endTime);
        model.addAttribute("houseList", house);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "home/homelist";
    }

    @RequestMapping("/homeadd")
    public String homelistadd(Model model) {

        List<Community> CommunityInfo = homeService.queryCommunityInfo(null);
        List<Building> buildingInfo = homeService.queryBuildingInfo(null);
        model.addAttribute("communityInfo", CommunityInfo);
        model.addAttribute("buildingInfo", buildingInfo);
        return "home/homeadd";
    }

    @RequestMapping("/homeInsert")
    @ResponseBody
    public HashMap<String, Object> homelistinsert(Home home) {

        Integer result = homeService.insertHouse(home);
        HashMap<String, Object> map = new HashMap<>();
            if (result == 1) {
                map.put("status",200);
                map.put("info","添加成功");
            } else {
                map.put("status",500);
                map.put("info","添加失败");
            }
        return map;
    }

    @RequestMapping("/deleteHouseById")
    @ResponseBody
    public HashMap<String,Object> homelistdelete(Integer id) {
        Integer result = homeService.deleteHouse(id);
        HashMap<String, Object> map = new HashMap<>();
        if (result == 1 ){
            map.put("status",200);
            map.put("info","删除成功");
        }else {
            map.put("status",500);
            map.put("info","删除失败");
        }
        return map;
    }
    @RequestMapping("deleteHouseByIds/{ids}")
    @ResponseBody
    public HashMap<String,Object> deleteHouseByIds(@PathVariable("ids") String ids) {

        Integer result = homeService.deleteHouseByIds(ids);
        HashMap<String, Object> map = new HashMap<>();
        if (result > 1) {
            map.put("status",200);
            map.put("info","删除成功");
        } else {
            map.put("status",500);
            map.put("info","删除失败");
        }
        return map;
    }

    @RequestMapping("/houseUpdate")
    @ResponseBody
    public HashMap<String,Object> houseUpdate(Home home) {

        boolean result = homeService.updateHouse(home);
        HashMap<String, Object> map = new HashMap<>();
        if (result) {
            map.put("status",200);
            map.put("info","更新成功");
        } else {
            map.put("status",500);
            map.put("info","更新失败");
        }
        return map;
    }

    @RequestMapping("/homeedit")
    public String homelistedit(Model model,Integer id) {
        Home houseInfo = homeService.queryById(id);
        List<Community> CommunityInfo = homeService.queryCommunityInfo(null);
        List<Building> buildingInfo = homeService.queryBuildingInfo(null);
        model.addAttribute("communityInfo", CommunityInfo);
        model.addAttribute("buildingInfo", buildingInfo);
        model.addAttribute("houseInfo", houseInfo);
        return "home/homeedit";


    }

}
