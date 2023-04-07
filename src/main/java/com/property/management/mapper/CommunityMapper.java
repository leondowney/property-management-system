package com.property.management.mapper;

import com.property.management.entity.Community;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */


public interface CommunityMapper {


    Integer insert(Community community);

    List<Community> queryByName(@Param("communityName") String communityName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Long queryByNameCount(@Param("communityName") String communityName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Community queryById(Integer id);

    Boolean deleteById(Integer id);

    Boolean deleteCommunityByIds(String ids);

    Boolean updateCommunity(Community community);

}
