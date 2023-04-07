package com.property.management.contorller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Building;
import com.property.management.entity.Community;
import com.property.management.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 栋数管理相关请求
 */
@Controller
public class BuildingController {

    @Autowired
    private BuildingService buildingService;
    @RequestMapping("/buildinglst")
    public String buildinglist(String buildingName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
        //查询单个或多个
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Building> building = buildingService.query(buildingName, startTime, endTime);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("buildingName",buildingName);
        PageInfo<Building> pageInfo = new PageInfo<>(building);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = buildingService.queryCount(buildingName, startTime, endTime);
        model.addAttribute("buildinglist", building);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "home/buildinglst";
    }

    @RequestMapping("/buildingadd")
    public String buildingadd(Model model) {
        List<Community> CommunityInfo = buildingService.queryCommunityInfo(null);
        model.addAttribute("communityInfo", CommunityInfo);
        return "home/buildingadd";
    }

    @RequestMapping("/buildingInsert")
    @ResponseBody
    public HashMap<String,Object> insertBuilding(Building building) {
        building.setBuildHiredate(new Date());
        Integer result = buildingService.insertBuilding(building);
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

    @RequestMapping("/deleteBuildingById")
    @ResponseBody
    public HashMap<String,Object> deleteBuildingById(Integer id) {
        System.out.println("id = " + id);
        Integer result = buildingService.deleteBuildingById(id);
        HashMap<String, Object> map = new HashMap<>();
        if (result == 1) {
            map.put("status",200);
            map.put("info","删除成功");
        } else {
            map.put("status",500);
            map.put("info","删除失败");
        }
        return map;
    }
    @RequestMapping("deleteBuildingByIds/{ids}")
    @ResponseBody
    public HashMap<String,Object> deleteHouseByIds(@PathVariable("ids") String ids) {

        Integer result = buildingService.deleteBuildingByIds(ids);
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

    @RequestMapping("/buildingedit")
    public String buildingedit(Model model, Integer id) {
        Building building = buildingService.queryById(id);

        List<Community> CommunityInfo = buildingService.queryCommunityInfo(null);
        model.addAttribute("communityInfo", CommunityInfo);
        model.addAttribute("buildingInfo", building);
        return "home/buildingedit";
    }
    @RequestMapping("/buildingUpdate")
    @ResponseBody
    public HashMap<String,Object> buildingUpdate(Building building) {
        Integer result = buildingService.buildingUpdate(building);
        HashMap<String, Object> map = new HashMap<>();
        if (result == 1) {
            map.put("status",200);
            map.put("info","更新成功");
        } else {
            map.put("status",500);
            map.put("info","更新失败");
        }
        return map;
    }
}
