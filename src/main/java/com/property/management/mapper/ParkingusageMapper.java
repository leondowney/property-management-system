package com.property.management.mapper;

import com.property.management.entity.Community;
import com.property.management.entity.DbPark;
import com.property.management.entity.TbParkingUse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface ParkingusageMapper {

    List<TbParkingUse> query(@Param("carNumber") String carNumber, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Long queryCount(@Param("carNumber")String carNumber, @Param("startTime")String startTime,@Param("endTime")String endTime);

    List<Community> queryCommunityInfo();

    List<DbPark> queryDbparkInfo();

    Integer parkingusageInsert(TbParkingUse tbParkingUse);

    Integer deleteparkingusageById(Integer id);

    Integer deleteparkingusageByIds(String ids);

    Integer parkingusageUpate(TbParkingUse tbParkingUse);

    TbParkingUse queryId(Integer id);
}
