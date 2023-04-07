package com.property.management.service.impl;

import com.property.management.entity.Community;
import com.property.management.entity.DbPark;
import com.property.management.entity.TbParkingUse;
import com.property.management.mapper.ParkingusageMapper;
import com.property.management.service.ParkingusageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service
public class ParkingusageServiceImpl implements ParkingusageService {
    @Autowired
    private ParkingusageMapper parkingusageMapper;
    @Override
    public List<TbParkingUse> query(String carNumber, String startTime, String endTime) {
        return parkingusageMapper.query(carNumber,startTime,endTime);
    }

    @Override
    public Long queryCount(String carNumber, String startTime, String endTime) {
        return parkingusageMapper.queryCount(carNumber,startTime,endTime);
    }

    @Override
    public List<Community> queryCommunityInfo() {
        return parkingusageMapper.queryCommunityInfo();
    }

    @Override
    public List<DbPark> queryDbparkInfo() {
        return parkingusageMapper.queryDbparkInfo();
    }

    @Override
    public Integer parkingusageInsert(TbParkingUse tbParkingUse) {
        return parkingusageMapper.parkingusageInsert(tbParkingUse);
    }

    @Override
    public Integer deleteparkingusageById(Integer id) {
        return parkingusageMapper.deleteparkingusageById(id);
    }

    @Override
    public Integer deleteparkingusageByIds(String ids) {
        return parkingusageMapper.deleteparkingusageByIds(ids);
    }
    @Override
    public Integer parkingusageUpate(TbParkingUse tbParkingUse) {
        return parkingusageMapper.parkingusageUpate(tbParkingUse);
    }

    @Override
    public TbParkingUse queryId(Integer id) {
        return parkingusageMapper.queryId(id);
    }
}
