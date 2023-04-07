package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Charge;
import com.property.management.entity.Community;
import com.property.management.service.ChargesService;
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
 * @describe： 收费项目相关请求
 */
@Controller
@RequestMapping("charges")
public class ChargesController {
    @Autowired
    private ChargesService chargesService;
    @RequestMapping("chargesList")
    public String queryChargeByname(String chargeName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Charge> charges= chargesService.queryByName(chargeName, startTime, endTime);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("chargeName",chargeName);
        PageInfo<Charge> pageInfo = new PageInfo<>(charges);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = chargesService.queryByNameCount(chargeName, startTime, endTime);
        model.addAttribute("chargeList", charges);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "charges/charges_list";
    }
    @RequestMapping("chargeEdit")
    public String chargeEdit(String id,Model model){
        List<Charge> charge = chargesService.queryById(id);
        System.out.println(charge);
        model.addAttribute("chargeOne",charge);
        return "charges/charges_edit";
    }
    @RequestMapping("updateCharge")
    @ResponseBody
    public Object updateCharge(Charge charge){
        HashMap<String, Object> map = new HashMap<>();
        boolean b = chargesService.updateCharge(charge);
        if(b){
            map.put("code",200);
            map.put("info","更新成功");
        }else{
            map.put("code",500);
            map.put("info","更新失败");
        }
        return map;
    }
    @RequestMapping("chargeAdd")
    public String chargeAdd(Model model){
        List<Community> communities =  chargesService.queryCommunityInfo();
        model.addAttribute("communities",communities);
        return "charges/charges_add";
    }
    @RequestMapping("chargeInsert")
    @ResponseBody
    public Object chargeInsert(Charge charge){
        HashMap<String, Object> map = new HashMap<>();
        boolean b = chargesService.chargeInsert(charge);
        if(b){
            map.put("code",200);
            map.put("info","上传成功");
        }else{
            map.put("code",500);
            map.put("info","上传失败");
        }
        return map;
    }
    @RequestMapping("deleteChargeById")
    @ResponseBody
    public Object deleteChargeById(Integer id){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = chargesService.deleteChargeById(id);
        if(b){
            map.put("code",200);
            map.put("info","删除成功");
        }else{
            map.put("code",500);
            map.put("info","删除失败");
        }
        return map;
    }
    @RequestMapping("deletedChargeByIds/{ids}")
    @ResponseBody
    public Object deletedChargeByIds(@PathVariable("ids") String ids){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = chargesService.deletedChargeByIds(ids);
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
