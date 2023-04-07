package com.property.management.service.impl;

import com.property.management.entity.Community;
import com.property.management.entity.Device;
import com.property.management.mapper.DeciveMapper;
import com.property.management.service.DeciveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service("deciveService")
public class DeciveServiceImpl implements DeciveService {
    @Autowired
    private DeciveMapper deciveMapper;
    @Override
    public List<Device> queryByName(String conmunityName, String startTime, String endTime) {
           return deciveMapper.queryByName(conmunityName,startTime,endTime);
    }

    @Override
    public Long queryByNameCount(String conmunityName, String startTime, String endTime) {

        return deciveMapper.queryByNameCount(conmunityName,startTime,endTime);
    }

    @Override
    public Device queryById(String id) {
        return deciveMapper.queryById(id);
    }

    @Override
    public Boolean updateDecive(Device device) {
        int line = deciveMapper.updateDecive(device);
        return line>0;
    }

    @Override
    public List<Community> queryCommunityInfo() {
        return deciveMapper.queryCommunityInfo();
    }

    @Override
    public Boolean insertDecive(Device device) {
        int line = deciveMapper.insertDecive(device);
        return line>0;
    }

    @Override
    public Boolean deleteDeciveById(Integer id) {
        int line = deciveMapper.deleteDeciveById(id);
        return line>0;
    }

    @Override
    public Boolean deletedDeciveByIds(String ids) {
        int line = deciveMapper.deletedDeciveByIds(ids);
        return line>0;
    }
}
