package com.property.management.mapper;

import com.property.management.entity.Community;
import com.property.management.entity.Home;
import com.property.management.entity.Owner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */

public interface OwnerMapper {
//    查询所有分页查询
    List<Owner> query(@Param("ownerName") String ownerName, @Param("startTime") String startTime, @Param("endTime")String endTime);
//查询总条数
    Long queryCount(@Param("ownerName") String ownerName, @Param("startTime") String startTime, @Param("endTime") String endTime);
//删除
    Boolean deleteById(Integer id);
//    批量删除
    Boolean deleteByIds(String ids);
//根据id查询需要修改的数据回显
//    业主
    Owner queryById(Integer id);
//小区
    List<Community> queryCommunityInfo(Integer cid);
//房产
    List<Home> queryHouseInfo(Integer hid);
//编辑信息 更新数据
    Boolean updateOwner(Owner owner);

//插入数据
    Boolean insert(Owner owner);
}
