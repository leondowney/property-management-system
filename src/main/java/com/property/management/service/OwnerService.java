package com.property.management.service;

import com.property.management.entity.Community;
import com.property.management.entity.Home;
import com.property.management.entity.Owner;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface OwnerService {

//查询所有或者单个业主信息（涉及到分页查询）
    List<Owner> query(String ownerName, String startTime, String endTime);
//查询总条数
    Long queryCount(String ownerName, String startTime, String endTime);

//删除数据
    Boolean deleteById(Integer id);
//批量删除数据
    Boolean deleteOwnerByIds(String ids);

//根据选中编辑的id来查询需要回显的数据
    Owner queryById(Integer id);
    List<Community> queryCommunityInfo(Integer id);
    List<Home> queryHouseInfo(Integer id);

//编辑信息 更新数据
    Boolean updateOwner(Owner owner);

//插入数据
    Boolean insertOwner(Owner owner);
}
