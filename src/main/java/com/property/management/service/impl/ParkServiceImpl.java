package com.property.management.service.impl;

import com.property.management.entity.Community;
import com.property.management.entity.Park;
import com.property.management.mapper.ParkMapper;
import com.property.management.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service
public class ParkServiceImpl implements ParkService {

    @Autowired
    private ParkMapper parkMapper;


    @Override
    public List<Community> queryCommunityInfo(Integer id) {
        return parkMapper.queryCommunityInfo(id);
    }

    @Override
    public List<Park> queryByName(String parkName, String startTime, String endTime) {
        return parkMapper.queryByName(parkName, startTime, endTime);
    }


    @Override
    public Long queryByNameCount(String parkName, String startTime, String endTime) {
        return parkMapper.queryByNameCount(parkName, startTime, endTime);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return parkMapper.deleteById(id);
    }

    @Override
    public Boolean deleteByIds(String ids) {
        return parkMapper.deleteByIds(ids);
    }

    @Override
    public boolean insertInfo(Park park) {
        return parkMapper.insertInfo(park);
    }

    @Override
    public Community queryById(Integer id) {
        return parkMapper.queryById(id);
    }

    @Override
    public Park queryId(Integer id) {
        return parkMapper.queryId(id);
    }

    @Override
    public Boolean updatePark(Park park) {
        return parkMapper.updatePark(park);
    }


}
