package com.property.management.service.impl;

import com.property.management.entity.Building;
import com.property.management.entity.Community;
import com.property.management.mapper.BuildingMapper;
import com.property.management.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public List<Building> query(String buildingName, String startTime, String endTime) {
        return buildingMapper.query(buildingName,startTime,endTime);
    }

    @Override
    public Long queryCount(String buildingName, String startTime, String endTime) {
        return buildingMapper.queryCount(buildingName,startTime,endTime);
    }

    @Override
    public List<Community> queryCommunityInfo(Object o) {
        return buildingMapper.queryCommunityInfo(o);
    }

    @Override
    public Integer insertBuilding(Building building) {
        return buildingMapper.insertBuilding(building);
    }

    @Override
    public Integer deleteBuildingById(Integer id) {
        return  buildingMapper.deleteBuildingById(id);
    }

    @Override
    public Integer deleteBuildingByIds(String ids) {
        return buildingMapper.deleteBuildingByIds(ids);
    }

    @Override
    public Building queryById(Integer id) {
        return buildingMapper.queryById(id);
    }

    @Override
    public Integer buildingUpdate(Building building) {
        return buildingMapper.buildingUpdate(building);
    }
}
