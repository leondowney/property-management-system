package com.property.management.contorller;

import com.property.management.entity.LetterBoxEntity;
import com.property.management.giveserviceutil.Data;
import com.property.management.service.LetterBoxService;
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
 * @describe： 信箱管理相关请求
 */
@Controller
@RequestMapping
public class LetterBoxController {
    @Autowired
    private LetterBoxService letterBoxService;
    @RequestMapping("letterBoxlist")
    public String selectAll(Model model, String litterBoxName){
        List<LetterBoxEntity> letterBoxEntityList = letterBoxService.selectAll(litterBoxName);
        Integer i = letterBoxService.selectCount(litterBoxName);
        model.addAttribute("count",i);
        model.addAttribute(letterBoxEntityList);
        return "giveserviceview/letterboxlist";
    }
    @RequestMapping("letterBox_listDeleteOne")
    @ResponseBody
    public Data deleteOne(Integer id){
        boolean b = letterBoxService.deleteOne(id);
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
    @RequestMapping("letterBox_listAdd")
    @ResponseBody
    public Data addOne(LetterBoxEntity letterBoxEntity){
        System.out.println("letterBoxEntity = " + letterBoxEntity);
        boolean b = letterBoxService.addOne(letterBoxEntity);
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
    @RequestMapping("letterbox_selectId")
    public String selectId(Integer id,Model model){
        LetterBoxEntity letterBoxEntity = letterBoxService.selectId(id);
        System.out.println("letterBoxEntity = " + letterBoxEntity);
        model.addAttribute("letterBoxEntity1",letterBoxEntity);
        return "giveserviceview/letterboxedit";
    }
    @RequestMapping("letterBox_listUpdate")
    @ResponseBody
    public Data update(LetterBoxEntity letterBoxEntity){
        System.out.println("letterBoxEntity = " + letterBoxEntity);
        boolean b = letterBoxService.updateOne(letterBoxEntity);
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
    @RequestMapping("letterbox_deleteMore")
    @ResponseBody
    public Data deleteMore(@RequestBody String ids){
        System.out.println("ids = " + ids);
        Data data = new Data();
        String[] split = ids.replace("\"","").split(",");
        Long i = Long.valueOf(0);
        try {
            for (String s : split) {
                System.out.println("s = " + s);
                i = letterBoxService.deleteById(Integer.parseInt(s));
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
