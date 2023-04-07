package com.property.management.contorller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Community;
import com.property.management.entity.Device;
import com.property.management.service.DeciveService;
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
 * @describe： 资产管理相关请求
 */

@Controller
@RequestMapping("decive")
public class DeciveController {
    @Autowired
    private DeciveService deciveService;
    @RequestMapping("/deciveList")
    public String queryByName(String conmunityName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
        //查询单个或多个
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Device> devices = deciveService.queryByName(conmunityName, startTime, endTime);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("communityName",conmunityName);
        PageInfo<Device> pageInfo = new PageInfo<>(devices);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = deciveService.queryByNameCount(conmunityName, startTime, endTime);
        model.addAttribute("deviceList", devices);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "decive/deciveList";
    }
    @RequestMapping("deciveEdit")
    public String deciveEdit(String id,Model model){
        Device device= deciveService.queryById(id);
        model.addAttribute("device",device);
        return "decive/deciveEdit";
    }
    @RequestMapping("updateDecive")
    @ResponseBody
    public Object updateDecive(Device device){
        System.out.println(device);
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = deciveService.updateDecive(device);
        if(b){
            map.put("status",200);
            map.put("info","更新成功");
        }else{
            map.put("status",500);
            map.put("info","更新失败");
        }
        return map;
    }
    @RequestMapping("deciveAdd")
    public String queryCommunityInfo(Model model){
        List<Community> communities =  deciveService.queryCommunityInfo();
        model.addAttribute("communities",communities);
        return "decive/deviceAdd";
    }
    @RequestMapping("deciveInsert")
    @ResponseBody
    public Object deciveInsert(Device device){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b= deciveService.insertDecive(device);
        if(b){
            map.put("status",200);
            map.put("info","上传成功");
        }else{
            map.put("status",500);
            map.put("info","上传失败");
        }
        return map;
    }
    @RequestMapping("deleteDeciveById")
    @ResponseBody
    public Object deleteDeciveById(Integer id){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = deciveService.deleteDeciveById(id);
        if(b){
            map.put("code",200);
            map.put("info","删除成功");
        }else{
            map.put("code",500);
            map.put("info","删除失败");
        }
        return map;
    }
    @RequestMapping("deletedDeciveByIds/{ids}")
    @ResponseBody
    public Object deletedDeciveByIds(@PathVariable("ids") String ids){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = deciveService.deletedDeciveByIds(ids);
        if(b){
            map.put("code",200);
            map.put("info","批量删除成功");
        }else{
            map.put("code",500);
            map.put("info","批量删除失败");
        }
        return map;
    }
}
