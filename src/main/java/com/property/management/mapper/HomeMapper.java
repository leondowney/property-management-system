package com.property.management.mapper;

import com.property.management.entity.Building;
import com.property.management.entity.Community;
import com.property.management.entity.Home;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface HomeMapper {
    List<Home> query(@Param("houseName") String houseName,@Param("startTime") String startTime,@Param("endTime") String endTime);

    Long queryCount(@Param("houseName")String houseName,@Param("startTime") String startTime,@Param("endTime") String endTime);

    List<Community> queryCommunityInfo(Integer id);

    List<Building> queryBuildingInfo(Integer id);

    Integer insertHouse(Home home);

    Integer deleteHouse(Integer id);

    Integer deleteHouseMore(String ids);

    boolean updateHouse(Home home);

    Home queryByid(Integer id);
}
