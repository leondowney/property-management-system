package com.property.management.service;

import com.property.management.entity.Community;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface CommunityService {

     Integer insertInfo(Community community);

    List<Community> queryByName(String communityName, String startTime, String endTime);

    Long queryByNameCount(String communityName, String startTime, String endTime);

    Community queryById(Integer id);

    Boolean deleteById(Integer id);

    Boolean deleteCommunityByIds(String ids);

    Boolean updateCommunity(Community community);

}
