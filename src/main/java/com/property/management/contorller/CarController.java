package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Car;
import com.property.management.entity.Owner;
import com.property.management.entity.RespBean;
import com.property.management.service.CarService;
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
 * @describe： 车辆管理相关请求
 */
@Controller
public class CarController {
    @Autowired
    private CarService carService;

    private String imgString = null;
    private String imgUrl = null;

//查询所有车辆信息
    @GetMapping("/vehicle_list")
    public String select(String carNumber, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1")Integer pageNum){
//分页查询  查询与搜索
        PageHelper.startPage(pageNum,5);//默认进来展示第一页 每页展示五条信息
        List<Car> cars = carService.query(carNumber,startTime,endTime);//查询所有信息
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("carNumber",carNumber);

        //将数据封装进pageInfo中

        PageInfo<Car> pageInfo = new PageInfo<>(cars);


            //查询总条数
        //方法一：
//         long total = pageInfo.getTotal();
//         System.out.println("total = " + total);
//         model.addAttribute("total",total);
         //方法二：
        Long count =carService.queryCount(carNumber,startTime,endTime);
        System.out.println("count = " + count);
        model.addAttribute("carList",cars);
        model.addAttribute("count",count);
        model.addAttribute("pageInfo",pageInfo);
        return "Simon/vehicle_list";
    }


//根据id单个删除
    @DeleteMapping("/deleteCarById/{id}")
    @ResponseBody
    public RespBean deleteCarById(@PathVariable("id") Integer id){
        Boolean b = carService.deleteById(id);
        RespBean respBean = null;
        if (b){
           respBean = RespBean.ok("删除成功！");
        }else{
            respBean = RespBean.error("删除失败！");
        }
        return respBean;
    }


    //根据ids批量删除
    @DeleteMapping("/deleteCarByIds/{ids}")
    @ResponseBody
    public RespBean deleteCarById(@PathVariable("ids") String  ids){
        Boolean b = carService.deleteByIds(ids);
        System.out.println("ids = " + ids);
        RespBean respBean = null;
        if (b){
          respBean = RespBean.ok("删除成功！");
        }else{
          respBean = RespBean.error("删除失败！");
        }
        return respBean;
    }



    //点击添加进入vehicle_add页面
@RequestMapping("vehicle_add")
    public String showAdd(Model model){
//查询所有业主信息 回显到添加车辆的车主下拉框选项中
    List<Owner> owners = carService.queryOwnerInfo(null);
    model.addAttribute("ownerInfo",owners);
        return "Simon/vehicle_add";
}
//添加车子信息 insert
 @PostMapping("carInsert")
 @ResponseBody
    public RespBean insertCar(Car car){
        car.setPicture(imgString);
        Boolean b = carService.insertCar(car);

        RespBean respBean =null;
        if (b){
           respBean = RespBean.ok("数据插入成功！");
        }else{
          respBean = RespBean.error("数据插入失败！");
        }
        return respBean;
    }




    //点击编辑进入vehicle_edit页面
    @RequestMapping("vehicle_edit")
    public String showEdit(Model model,Integer id){
        //根据选中id查询车主所有信息 回显到编辑车辆的车主下拉框选项中
        List<Owner> owners = carService.queryOwnerInfo(null);
        model.addAttribute("ownerInfo",owners);
//        System.out.println("owners = " + owners);

        //根据选中id查询车辆所有信息 回显到添加车辆的车主下拉框选项中
        Car cars = carService.queryCarInfoById(id);
        model.addAttribute("carInfo",cars);
//        System.out.println("cars = " + cars);
        return "Simon/vehicle_edit";
    }

//update 更新、编辑信息
    @PostMapping("carUpdate")
    @ResponseBody
    public RespBean editCar(Car car){
        car.setPicture(imgString);
       Boolean b = carService.updateCar(car);

        RespBean respBean = null;
       if (b){
           respBean = RespBean.ok("数据更新成功！");
       }else{
           respBean = RespBean.error("数据更新失败！");
       }
        return respBean;
    }



//编辑和增加时 上传图片
//    FileUpload
//    @PostMapping("carImgInsert")
//    @ResponseBody
//    public Map<String,String> FileUpload(MultipartFile img, HttpServletRequest req){
//        HashMap<String, String> map = new HashMap<>();
//        String filename = img.getOriginalFilename();
//        String realPath = req.getServletContext().getRealPath("/images");
//        File file = new File(realPath);
//        if (!file.exists()){
//            file.mkdirs();
//        }
//
//        String newName = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
//        try {
//            img.transferTo(new File(file,newName));
//            String url =req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/images"+newName;
//            System.out.println("url = " + url);
//            map.put("status","200");
//            map.put("newName",newName);
//            imgString = newName;
//            map.put("url",url);
//            imgUrl=url;
//        } catch (IOException e) {
//            map.put("status","500");
//            map.put("msg",e.getMessage());
//
//        }
//        return  map;
//
//    }



    @PostMapping("/carImgInsert")
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
