package com.property.management.mapper;

import com.property.management.entity.Charge;
import com.property.management.entity.Community;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface ChargesMapper {
    List<Charge> queryByName(@Param("chargeName") String chargeName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Long queryByNameCount(@Param("chargeName")String chargeName, @Param("startTime")String startTime, @Param("endTime")String endTime);

    List<Charge> queryById(String id);

    int updateCharge(Charge charge);

    List<Community> queryCommunityInfo();

    int chargeInsert(Charge charge);

    int deleteChargeById(Integer id);

    int deletedChargeByIds(String ids);
}
