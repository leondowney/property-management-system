package com.property.management.contorller;

import com.property.management.entity.ActiveEntity;
import com.property.management.giveserviceutil.Data;
import com.property.management.service.ActiveService;
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
 * @describe： 活动管理相关请求
 */
@Controller
@RequestMapping
public class ActiveController {
    @Autowired
    private ActiveService activeService;
    @RequestMapping("activity_list")
    public String selectAll(Model model,String activeName){
//        PageHelper.startPage(pageNum,5);
//        System.out.println("activeName = " + activeName);
        List<ActiveEntity> activeEntityList = activeService.selectAll(activeName);
        Integer i = activeService.selectCount(activeName);
//        System.out.println("i = " + i);
        model.addAttribute("count",i);
//        System.out.println("activeEntityList = " + activeEntityList);
        model.addAttribute(activeEntityList);
        return "giveserviceview/activity_list";
    }
    @RequestMapping("activity_listDeleteOne")
    @ResponseBody
    public Data deleteOne(Integer id){
        System.out.println("id = " + id);
        boolean b = activeService.deleteOne(id);
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
    @RequestMapping("activity_listAdd")
    @ResponseBody
    public Data addOne(ActiveEntity activeEntity){
//        System.out.println("activeEntity = " + activeEntity);
        boolean b = activeService.addOne(activeEntity);
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
    @RequestMapping("activity_selectId")
    public String selectId(Integer id,Model model){
//        System.out.println("id = " + id);
       ActiveEntity activeEntity = activeService.selectId(id);
        System.out.println("activeEntity = " + activeEntity);
        model.addAttribute("activeEntity1",activeEntity);
        return "giveserviceview/activity_edit";
    }
    @RequestMapping("activity_listUpdate")
    @ResponseBody
    public Data update(ActiveEntity activeEntity){
//        System.out.println("activeEntity = " + activeEntity);
        boolean b = activeService.updateOne(activeEntity);
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
    @RequestMapping("active_deleteMore")
    @ResponseBody
    public Data deleteMore(@RequestBody String ids){
        System.out.println("ids = " + ids);
        Data data = new Data();
        String[] split = ids.replace("\"","").split(",");
        Long i = Long.valueOf(0);
        try {
            for (String s : split) {
                System.out.println("s = " + s);
                    i = activeService.deleteById(Integer.parseInt(s));
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
