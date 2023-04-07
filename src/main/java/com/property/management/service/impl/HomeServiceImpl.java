package com.property.management.service.impl;

import com.property.management.entity.Building;
import com.property.management.entity.Community;
import com.property.management.entity.Home;
import com.property.management.mapper.HomeMapper;
import com.property.management.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired

    private HomeMapper homeMapper;
    @Override
    public List<Home> query(String houseName, String startTime, String endTime) {
        return homeMapper.query(houseName,startTime,endTime);
    }

    @Override
    public Long queryCount(String houseName, String startTime, String endTime) {
        return homeMapper.queryCount(houseName,startTime,endTime);
    }

    @Override
    public List<Community> queryCommunityInfo(Integer id) {
        return homeMapper.queryCommunityInfo(id);
    }

    @Override
    public List<Building> queryBuildingInfo(Integer id) {
        return homeMapper.queryBuildingInfo(id);
    }

    @Override
    public Integer insertHouse(Home home) {
        return homeMapper.insertHouse(home);

    }

    @Override
    public Integer deleteHouse(Integer id) {
        return homeMapper.deleteHouse(id);
    }

    @Override
    public Integer deleteHouseByIds(String ids) {
        return homeMapper.deleteHouseMore(ids);
    }

    @Override
    public boolean updateHouse(Home home) {
        return homeMapper.updateHouse(home);
    }

    @Override
    public Home queryById(Integer id) {
        return homeMapper.queryByid(id);
    }
}
