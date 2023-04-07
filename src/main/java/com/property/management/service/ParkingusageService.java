package com.property.management.service;

import com.property.management.entity.Community;
import com.property.management.entity.DbPark;
import com.property.management.entity.TbParkingUse;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface ParkingusageService {
    List<TbParkingUse> query(String carNumber, String startTime, String endTime);

    Long queryCount(String carNumber, String startTime, String endTime);

    List<Community> queryCommunityInfo();

    List<DbPark> queryDbparkInfo();

    Integer parkingusageInsert(TbParkingUse tbParkingUse);

    Integer deleteparkingusageById(Integer id);

    Integer deleteparkingusageByIds(String ids);

    Integer parkingusageUpate(TbParkingUse tbParkingUse);

    TbParkingUse queryId(Integer id);
}
