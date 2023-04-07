package com.property.management.service.impl;

import com.property.management.entity.Car;
import com.property.management.entity.Owner;
import com.property.management.mapper.CarMapper;
import com.property.management.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;


    @Override
    public List<Car> query(String carNumber, String startTime, String endTime) {
        return carMapper.queryAll(carNumber,startTime,endTime);
    }

    @Override
    public Long queryCount(String carNumber, String startTime, String endTime) {
        return carMapper.queryCount(carNumber,startTime,endTime);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return carMapper.deleteById(id);
    }

    @Override
    public Boolean deleteByIds(String ids) {
        return carMapper.deleteByIds(ids);
    }

    //添加和编辑共用的一个查询车主信息方法
    @Override
    public List<Owner> queryOwnerInfo(Integer id) {
        return carMapper.queryOwnerInfo(id);
    }
    //编辑时查询车辆信息
    @Override
    public Car queryCarInfoById(Integer id) {
        return carMapper.queryCarInfo(id);
    }

    //insert
    @Override
    public Boolean insertCar(Car car) {
        return carMapper.insert(car);
    }
//    update
    @Override
    public Boolean updateCar(Car car) {
        return carMapper.updateCar(car);
    }
}
