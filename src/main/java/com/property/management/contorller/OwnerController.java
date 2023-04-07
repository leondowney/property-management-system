package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Community;
import com.property.management.entity.Home;
import com.property.management.entity.Owner;
import com.property.management.entity.RespBean;
import com.property.management.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 业主管理相关请求
 */
@Controller
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    private String imgString = null;
    private String imgUrl = null;

//查询所有业主信息列表  分页查询
    @GetMapping("personnel_list")
    public String  select(String ownerName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1")Integer pageNum){
//查询多个或单个
        PageHelper.startPage(pageNum,5);//默认进来展示第一页 每页展示5条信息
        List<Owner> owners =ownerService.query(ownerName,startTime,endTime);

        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("ownerName",ownerName);


//        pageInfo:将分页数据和显示的数据封装到pageInfo当中
        PageInfo<Owner> pageInfo = new PageInfo<>(owners);
        System.out.println("owners = " + owners);


//        查询总条数
        Long count = ownerService.queryCount(ownerName,startTime,endTime);
        model.addAttribute("ownerList",owners);
        model.addAttribute("count",count);
        System.out.println("count = " + count);

//        将分页数据和显示的数据封装到pageInfo当中 返回到前台
        model.addAttribute("pageInfo",pageInfo);

        return "Simon/personnel_list";

    }

//点击进入插入页面 插入
    @GetMapping("personnel_add")
    public String showAdd(Model model){
        List<Community> communities = ownerService.queryCommunityInfo(null);
        model.addAttribute("communityInfo",communities);
        List<Home> houses = ownerService.queryHouseInfo(null);
//        System.out.println("communities = " + communities);

        List<Home> homes = ownerService.queryHouseInfo(null);
        model.addAttribute("houseInfo",homes);
//        System.out.println("houses = " + houses);

        return "Simon/personnel_add";
    }

    //插入数据
    @PostMapping("personnelInsert")
    @ResponseBody
    public RespBean insert(Owner owner){
        owner.setCreateTime(new Date());
        owner.setPicture(imgString);
        Boolean b = ownerService.insertOwner(owner);
        RespBean respBean = null;
        if (b){
            respBean = RespBean.ok("添加成功");

        }else{
           respBean = RespBean.error("添加失败");
        }
        return  respBean;
    }


//    点击进入修改页面  回显当条信息展示的数据
    @GetMapping("personnel_edit")
    public String showEdit(Model model,Integer id){
        Owner owner = ownerService.queryById(id);
        List<Community> communities = ownerService.queryCommunityInfo(null);
        List<Home> houses = ownerService.queryHouseInfo(null);
//        查询到的数据包装起来存到session中
        model.addAttribute("communityInfo",communities);
        model.addAttribute("houseInfo",houses);
        model.addAttribute("ownerInfo",owner);
//        System.out.println("owner = " + owner);

        return "Simon/personnel_edit";
    }


//更新操作
@PostMapping("/personnelUpdate")
@ResponseBody
public RespBean houseUpdate(Owner owner) {
    System.out.println("owner = " + owner);
    RespBean respBean = null;
    owner.setPicture(imgString);
    Boolean result = ownerService.updateOwner(owner);
    if (result) {
        respBean = RespBean.ok("更新成功");
    } else {
        respBean = RespBean.error("更新失败");
    }
    return respBean;
}





//删除
@DeleteMapping("/deletePersonnelById/{id}")
@ResponseBody
    public RespBean deleteOwnerById(@PathVariable("id")Integer id){
        RespBean respBean = null;
       Boolean b = ownerService.deleteById(id);
       if (b){
           respBean =  RespBean.ok("删除成功！");
       }else{
           respBean =  RespBean.error("删除失败！");
       }
return respBean;
}

//批量删除
@DeleteMapping("/deletePersonnelByIds/{ids}")
@ResponseBody
public RespBean deletePersonnelByIds(@PathVariable("ids") String ids){
        Boolean b =ownerService.deleteOwnerByIds(ids);
        System.out.println("ids = " + ids);
        RespBean respBean = null;
        if (b){
             respBean = RespBean.ok("删除成功!");
        }else{
            respBean = RespBean.error("删除失败!");
        }
       return respBean;
    }



//文件上传 上传图片！！！！
@PostMapping("ownerImgInsert")
 @ResponseBody
public Map<String ,String > upload(MultipartFile img, HttpServletRequest req){
    HashMap<String, String> map = new HashMap<>();
    String Filename = img.getOriginalFilename();
    String realPath = req.getServletContext().getRealPath("/images");
    File file = new File(realPath);
    if (!file.exists()){
        file.mkdirs();
    }

    String newName = UUID.randomUUID().toString()+Filename.substring(Filename.lastIndexOf("."));
    try {
        img.transferTo(new File(file,newName));
        String url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/images/"+newName;
        System.out.println("url = " + url);
        map.put("status","200");
        map.put("newName",newName);
        imgString=newName;
        map.put("url",url);
        imgUrl=url;
    } catch (IOException e) {
        map.put("status","500");
        map.put("msg",e.getMessage());
    }
return map;


}































}
