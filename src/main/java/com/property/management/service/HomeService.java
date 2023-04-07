package com.property.management.service;

import com.property.management.entity.Building;
import com.property.management.entity.Community;
import com.property.management.entity.Home;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface HomeService {
    List<Home> query(String houseName, String startTime, String endTime);

    Long queryCount(String houseName, String startTime, String endTime);

    List<Community> queryCommunityInfo(Integer id);

    List<Building> queryBuildingInfo(Integer id);

    Integer insertHouse(Home home);

    Integer deleteHouse(Integer id);

    Integer deleteHouseByIds(String ids);

    boolean updateHouse(Home home);

    Home queryById(Integer id);
}
