package com.property.management.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.property.management.entity.Asset;
import com.property.management.entity.Charge;
import com.property.management.service.AssetService;
import com.property.management.util.LayUtil;
import jdk.nashorn.internal.ir.CallNode;
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
 * @describe： 收费明细管理相关请求
 */
@Controller
@RequestMapping("asset")
public class AssetController {
    @Autowired
    private AssetService assetService;
    @RequestMapping("assetList")
    public String assetList(String rateName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Asset> assets= assetService.queryByName(rateName, startTime, endTime);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("rateName",rateName);
        PageInfo<Asset> pageInfo = new PageInfo<>(assets);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = assetService.queryByNameCount(rateName, startTime, endTime);
        model.addAttribute("assetList", assets);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "asset/asset_list";
    }
    @RequestMapping("deleteAssetById")
    @ResponseBody
    public Object deleteAssetById(Integer id){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = assetService.deleteAssetById(id);
        if(b){
            map.put("code",200);
            map.put("info","删除一条记录");
        }else{
            map.put("code",500);
            map.put("info","删除失败");
        }
        return map;
    }
    @RequestMapping("deleteAssetByIds/{ids}")
    public Object deleteAssetByIds(@PathVariable("ids") String ids){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = assetService.deleteAssetByIds(ids);
        if(b){
            map.put("code",200);
            map.put("info","批量删除成功");
        }else{
            map.put("code",500);
            map.put("info","批量删除失败");
        }
        return map;
    }
    @RequestMapping("assetEdit")
    public String assetEdit(Integer id,Model model){
        Asset asset = assetService.queryAssetInfoById(id);
        List<Charge> charges = assetService.qyeryAll();
        model.addAttribute("charges",charges);
        model.addAttribute("asset",asset);
        return "asset/asset_edit";
    }
    @RequestMapping("updateAsset")
    @ResponseBody
    public Object updateAsset(Asset asset){
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = assetService.updateAsset(asset);
        if(b){
            map.put("code",200);
            map.put("info","更新成功");
        }else{
            map.put("code",500);
            map.put("info","更新失败");
        }
        return map;
    }
    @RequestMapping("selectRate")
    @ResponseBody
    public Object selectRate(String cName,Model model) {
        System.out.println(cName);
        List<Charge> cha = assetService.selectRate(cName);
        return cha;
    }
    @RequestMapping("assetAdd")
    public String assetAdd(Model model){
        List<Charge> charges = assetService.qyeryAll();
        model.addAttribute("charges",charges);
        return "asset/asset_add";
    }
    @RequestMapping("insertAsset")
    @ResponseBody
    public Object insertAsset(Asset asset){
        HashMap<String, Object> map = new HashMap<>();
        boolean b = assetService.insertAsset(asset);
        if(b){
            map.put("code",200);
            map.put("info","插入成功");
        }else {
            map.put("code",500);
            map.put("info","插入失败");
        }
        return map;
    }
}
