package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Building;
import com.property.management.entity.Community;
import com.property.management.entity.DbPark;
import com.property.management.entity.TbParkingUse;
import com.property.management.service.ParkingusageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 车位使用管理相关请求
 */
@Controller
public class ParkingusageController {
    @Autowired
    private ParkingusageService parkingusageService;

    @RequestMapping("/parkingusagelist")
    public String parkingusagelist(String carNumber, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
        //查询单个或多个
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<TbParkingUse> TbParkingUse = parkingusageService.query(carNumber, startTime, endTime);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("carNumber", carNumber);
        PageInfo<TbParkingUse> pageInfo = new PageInfo<>(TbParkingUse);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = parkingusageService.queryCount(carNumber, startTime, endTime);
        model.addAttribute("parkingusagelist", TbParkingUse);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "home/parkingusagelist";
    }

    @RequestMapping("/parkingusageadd")
    public String homelistadd(Model model) {

        List<Community> CommunityInfo = parkingusageService.queryCommunityInfo();
        List<DbPark> dbParkInfo = parkingusageService.queryDbparkInfo();
        model.addAttribute("communityInfo", CommunityInfo);
        model.addAttribute("dbParkInfo", dbParkInfo);
        return "home/parkingusageadd";
    }

    @RequestMapping("/parkingusageInsert")
    @ResponseBody
    public HashMap<String, Object> parkingusageInsert(TbParkingUse tbParkingUse) {
        tbParkingUse.setCreateTime(new Date());

        Integer result = parkingusageService.parkingusageInsert(tbParkingUse);
        HashMap<String, Object> map = new HashMap<>();
        if (result == 1) {
            map.put("status", 200);
            map.put("info", "添加成功");
        } else {
            map.put("status", 500);
            map.put("info", "添加失败");
        }
        return map;
    }

    @RequestMapping("/deleteparkingusageById")
    @ResponseBody
    public HashMap<String, Object> deleteparkingusageById(Integer id) {
        Integer result = parkingusageService.deleteparkingusageById(id);
        HashMap<String, Object> map = new HashMap<>();
        if (result == 1) {
            map.put("status", 200);
            map.put("info", "删除成功");
        } else {
            map.put("status", 500);
            map.put("info", "删除失败");
        }
        return map;
    }

    @RequestMapping("deleteparkingusageByIds/{ids}")
    @ResponseBody
    public HashMap<String, Object> deleteparkingusageByIds(@PathVariable("ids") String ids) {
        Integer result = parkingusageService.deleteparkingusageByIds(ids);
        HashMap<String, Object> map = new HashMap<>();
        if (result > 1) {
            map.put("status", 200);
            map.put("info", "删除成功");
        } else {
            map.put("status", 500);
            map.put("info", "删除失败");
        }
        return map;
    }
    @RequestMapping("/parkingusageedit")
    public String parkingusageedit(Integer id, Model model) {
        TbParkingUse tbParkingUseInfo = parkingusageService.queryId(id);

        List<Community> CommunityInfo = parkingusageService.queryCommunityInfo();
        List<DbPark> dbParkInfo = parkingusageService.queryDbparkInfo();
        model.addAttribute("tbParkingUseInfo",tbParkingUseInfo);
        model.addAttribute("communityInfo", CommunityInfo);
        model.addAttribute("dbParkInfo", dbParkInfo);
        return "home/parkingusageedit";
    }


    @RequestMapping("/parkingusageUpate")
    @ResponseBody
    public HashMap<String, Object> parkingusageUpate(TbParkingUse tbParkingUse) {
        Integer result = parkingusageService.parkingusageUpate(tbParkingUse);
        HashMap<String, Object> map = new HashMap<>();
        if (result == 1) {
            map.put("status", 200);
            map.put("info", "更新成功");
        } else {
            map.put("status", 500);
            map.put("info", "删除失败");
        }
        return map;
    }
}

