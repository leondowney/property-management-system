package com.property.management.service;

import com.property.management.entity.Car;
import com.property.management.entity.Owner;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface CarService {
//    select
//查询所有、搜索
    List<Car> query(String carNumber, String startTime, String endTime);
//查询总条数
    Long queryCount(String carNumber, String startTime, String endTime);

//  delete
//根据id进行单个删除
    Boolean deleteById(Integer id);
//根据ids进行批量删除
    Boolean deleteByIds(String ids);


    //添加和编辑共用的一个查询车主信息方法
//  insert
List<Owner> queryOwnerInfo(Integer id);
Boolean insertCar(Car car);

    //    edit
//编辑时查询车辆信息
    Car queryCarInfoById(Integer id);
//    update
    Boolean updateCar(Car car);



}
