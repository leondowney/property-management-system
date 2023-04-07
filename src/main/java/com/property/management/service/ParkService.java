package com.property.management.service;

import com.property.management.entity.Community;
import com.property.management.entity.Park;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface ParkService {
    //查询小区 下拉框渲染
    List<Community> queryCommunityInfo(Integer id);

//查询所有停车位
    List<Park> queryByName(String parkName, String startTime, String endTime);

    Long queryByNameCount(String parkName, String startTime, String endTime);

    Boolean deleteById(Integer id);


    Boolean deleteByIds(String ids);

    boolean insertInfo(Park park);

    Community queryById(Integer id);

    Park queryId(Integer id);

    Boolean updatePark(Park park);

}
