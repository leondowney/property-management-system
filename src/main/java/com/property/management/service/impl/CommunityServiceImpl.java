package com.property.management.service.impl;

import com.property.management.entity.Community;
import com.property.management.mapper.CommunityMapper;
import com.property.management.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public Integer insertInfo(Community community) {
//        community.setImg("tx.jpg");
        Integer line = communityMapper.insert(community);
        return line;
    }

    @Override
    public List<Community> queryByName(String communityName, String startTime, String endTime) {
        return communityMapper.queryByName(communityName, startTime, endTime);
    }

    @Override
    public Long queryByNameCount(String communityName, String startTime, String endTime) {
        return communityMapper.queryByNameCount(communityName, startTime, endTime);
    }

    @Override
    public Community queryById(Integer id) {
        return  communityMapper.queryById(id);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return communityMapper.deleteById(id);
    }

    @Override
    public Boolean deleteCommunityByIds(String ids) {
        return communityMapper.deleteCommunityByIds(ids);
    }

    @Override
    public Boolean updateCommunity(Community community) {
        return communityMapper.updateCommunity(community);
    }


}
