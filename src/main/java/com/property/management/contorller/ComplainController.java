package com.property.management.contorller;

import com.property.management.entity.ComplainEntity;
import com.property.management.giveserviceutil.Data;
import com.property.management.service.ComplainService;
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
 * @describe： 投诉管理相关请求
 */
@Controller
@RequestMapping
public class ComplainController {
    @Autowired
    private ComplainService complainService;
    @RequestMapping("complain_list")
    public String selectAll(Model model, String complainName){
//        PageHelper.startPage(pageNum,5);
//        System.out.println("complainName = " + complainName);
        List<ComplainEntity> complainEntityList = complainService.selectAll(complainName);
        Integer i = complainService.selectCount(complainName);
//        System.out.println("i = " + i);
        model.addAttribute("count",i);
//        System.out.println("activeEntityList = " + activeEntityList);
        model.addAttribute(complainEntityList);
        return "giveserviceview/complainlist";
    }
    @RequestMapping("complain_listDeleteOne")
    @ResponseBody
    public Data deleteOne(Integer id){
        boolean b = complainService.deleteOne(id);
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
    @RequestMapping("complain_listAdd")
    @ResponseBody
    public Data addOne(ComplainEntity complainEntity){
//        System.out.println("complainEntity = " + complainEntity);
        boolean b = complainService.addOne(complainEntity);
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
    @RequestMapping("complain_selectId")
    public String selectId(Integer id,Model model){
//        System.out.println("id = " + id);
        ComplainEntity complainEntity = complainService.selectId(id);
//        System.out.println("complainEntity = " + complainEntity);
        model.addAttribute("complainEntity1",complainEntity);
        return "giveserviceview/complainedit";
    }
    @RequestMapping("complain_listUpdate")
    @ResponseBody
    public Data update(ComplainEntity complainEntity){
//        System.out.println("activeEntity = " + activeEntity);
        boolean b = complainService.updateOne(complainEntity);
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
    @RequestMapping("complain_deleteMore")
    @ResponseBody
    public Data deleteMore(@RequestBody String ids){
        System.out.println("ids = " + ids);
        Data data = new Data();
        String[] split = ids.replace("\"","").split(",");
        Long i = Long.valueOf(0);
        try {
            for (String s : split) {
                System.out.println("s = " + s);
                i = complainService.deleteById(Integer.parseInt(s));
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
