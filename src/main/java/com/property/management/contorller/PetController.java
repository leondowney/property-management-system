package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Car;
import com.property.management.entity.Owner;
import com.property.management.entity.Pet;
import com.property.management.entity.RespBean;
import com.property.management.service.PetService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 宠物管理相关请求
 */
@Controller
public class PetController {

    @Autowired
    private PetService petService;
    private String imgString = null;
    private String imgUrl = null;

//    查询所有宠物 和总条数
    @RequestMapping("pet_list")
    public String selectAll(String petName,String startTime,String endTime,Model model, @RequestParam(defaultValue = "1")Integer pageNum){
        PageHelper.startPage(pageNum,5);//默认进入页面后展示第一页的五条数据
        List<Pet> pets = petService.query(petName,startTime,endTime);//查询所有宠物信息
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("petName",petName);

//       将数据封装进pageInfo中
        PageInfo<Pet> pageInfo = new PageInfo<>(pets);


//        查询总条数
        Long count = petService.queryCount(petName,startTime,endTime);
        model.addAttribute("petList",pets);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("count",count);

        return "Simon/pet_list";
    }


//   add 插入
    @RequestMapping("pet_add")
    public String showAdd(Model model){
        List<Owner> owners = petService.queryOwnerInfo(null);
        model.addAttribute("ownerInfo",owners);

        return "Simon/pet_add";
    }
//insert
    @RequestMapping("petInsert")
    @ResponseBody
    public RespBean petInsert(Pet pet){
        pet.setPicture(imgString);
        Boolean b = petService.insert(pet);
        RespBean respBean = null;
        if (b){
             respBean = RespBean.ok("插入成功！");
        }else{
             respBean = RespBean.error("插入失败！");
        }
        return respBean;
    }





    //  update 更新
    @RequestMapping("pet_edit")
    public String showEdit(Model model,Integer id){
        List<Owner> owners = petService.queryOwnerInfo(null);
        model.addAttribute("ownerInfo",owners);

        Pet pet = petService.queryPetById(id);
        model.addAttribute("petInfo",pet);

        return "Simon/pet_edit";
    }

//    update
    @PostMapping("petUpdate")
    @ResponseBody
    public RespBean updatePet(Pet pet){
        System.out.println("pet = " + pet);
        pet.setPicture(imgString);
        Boolean b = petService.update(pet);
        RespBean respBean = null;
        if (b){
             respBean = RespBean.ok("更新成功！");
        }else{
            respBean = RespBean.error("更新失败！");
        }
        return respBean;
    }





//    根据id进行单个删除
@DeleteMapping("/deletePetById")
@ResponseBody
public RespBean deletePetById(Integer id) {
    Boolean result = petService.deleteById(id);
    RespBean respBean = null;
    if (result) {
        respBean = RespBean.ok("删除成功");
    } else {
        respBean = RespBean.error("删除失败");
    }
    return respBean;
}



//    根据ids进行批量删除
    @DeleteMapping("deletePetByIds/{ids}")
    @ResponseBody
    public RespBean deletePetByIds(@PathVariable("ids")String  ids){
        System.out.println("ids = " + ids);
        Boolean b = petService.deleteByIds(ids);
        RespBean respBean = null;
        if (b){
            respBean = RespBean.ok("删除成功！");
        }else{
            respBean = RespBean.error("删除失败！");
        }
        return respBean;
    }






//图片文件上传
@PostMapping("/petImgInsert")
@ResponseBody
public Map<String, String> fileupload(MultipartFile images, HttpServletRequest req) {
    Map<String, String> result = new HashMap<>();
    String oldName = images.getOriginalFilename();
    String realPath = req.getServletContext().getRealPath("/images");
    System.out.println("realPath = " + realPath);
    File folder = new File(realPath);
    if (!folder.exists()) {
        folder.mkdirs();
    }

    String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
    try {
        images.transferTo(new File(folder, newName));
        String tomcatUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/images/" + newName;
        System.out.println("url = " + tomcatUrl);
        result.put("status", "200");
        result.put("newName", newName);
        imgString = newName;
        result.put("url", tomcatUrl);
        imgUrl = tomcatUrl;
        System.out.println("url = " + tomcatUrl);
    } catch (IOException e) {
        result.put("status", "500");
        result.put("msg", e.getMessage());
    }
    return result;
}






}





