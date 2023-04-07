package com.property.management.contorller;


import com.property.management.entity.RepairEntity;
import com.property.management.giveserviceutil.Data;
import com.property.management.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 报修管理相关请求
 */
@Controller
@RequestMapping
public class RepairController {
    @Autowired
    private RepairService repairService;
    @RequestMapping("repair_list")
    public String selectAll(Model model,String repairName){
//        PageHelper.startPage(pageNum,5);
        System.out.println("repairName = " + repairName);
        List<RepairEntity> repairEntityList = repairService.selectAll(repairName);
        Integer i = repairService.selectCount(repairName);
//        System.out.println("i = " + i);
        model.addAttribute("count",i);
//        System.out.println("activeEntityList = " + activeEntityList);
        model.addAttribute(repairEntityList);
        return "giveserviceview/repairlist";
    }
    @RequestMapping("repair_listDeleteOne")
    @ResponseBody
    public Data deleteOne(Integer id){
        System.out.println("id = " + id);
        boolean b = repairService.deleteOne(id);
        Data data = new Data();
        if(b){
            data.setInfo("删除成功！");
            data.setState(1);
        }else {
            data.setInfo("删除失败！");
            data.setState(2);
        }
        return data;
    }
    @RequestMapping("repair_listAdd")
    @ResponseBody
    public Data addOne(RepairEntity repairEntity){
        System.out.println("repairEntity = " + repairEntity);
        boolean b = repairService.addOne(repairEntity);
        Data data = new Data();
        if(b){
            data.setInfo("添加成功！");
            data.setState(1);
        }else {
            data.setInfo("添加失败！");
            data.setState(2);
        }
        return data;
    }
    @RequestMapping("repair_selectId")
    public String selectId(Integer id,Model model){
//        System.out.println("id = " + id);
        RepairEntity repairEntity = repairService.selectId(id);
        System.out.println("repairEntity = " + repairEntity);
        model.addAttribute("repairEntity1",repairEntity);
        return "giveserviceview/repairedit";
    }
    @RequestMapping("repair_listUpdate")
    @ResponseBody
    public Data update(RepairEntity repairEntity){
//        System.out.println("activeEntity = " + activeEntity);
        boolean b = repairService.updateOne(repairEntity);
        Data data = new Data();
        if(b){
            data.setInfo("修改成功！");
            data.setState(1);
        }else {
            data.setInfo("修改失败！");
            data.setState(2);
        }
        return data;
    }
    @RequestMapping("repair_deleteMore")
    @ResponseBody
    public Data deleteMore(@RequestBody String ids){
        System.out.println("ids = " + ids);
        Data data = new Data();
        String[] split = ids.replace("\"","").split(",");
        Long i = Long.valueOf(0);
        try {
            for (String s : split) {
                System.out.println("s = " + s);
                i = repairService.deleteById(Integer.parseInt(s));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(i>0){
            data.setInfo("删除成功！");
            data.setState(1);
        }else {
            data.setInfo("删除失败！");
            data.setState(2);
        }
        return data;
    }
}
