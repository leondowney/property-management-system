package com.property.management.mapper;

import com.property.management.entity.Building;
import com.property.management.entity.Community;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface BuildingMapper {

    List<Building> query(@Param("buildingName") String buildingName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Long queryCount(@Param("buildingName") String buildingName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Community> queryCommunityInfo(Object o);

    Integer insertBuilding(Building building);

    Integer deleteBuildingById(Integer id);

    Integer deleteBuildingByIds(String ids);

    Building queryById(Integer id);

    Integer buildingUpdate(Building building);
}
