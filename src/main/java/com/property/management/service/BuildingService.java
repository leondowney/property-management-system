package com.property.management.service;

import com.property.management.entity.Building;
import com.property.management.entity.Community;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface BuildingService {
    List<Building> query(String buildingName, String startTime, String endTime);

    Long queryCount(String buildingName, String startTime, String endTime);

    List<Community> queryCommunityInfo(Object o);

    Integer insertBuilding(Building building);

    Integer deleteBuildingById(Integer id);

    Integer deleteBuildingByIds(String ids);

    Building queryById(Integer id);

    Integer buildingUpdate(Building building);
}
