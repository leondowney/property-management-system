package com.property.management.mapper;

import com.property.management.entity.Car;
import com.property.management.entity.Owner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface CarMapper {

    //查询所有、搜索
    List<Car> queryAll(@Param("carNumber") String carNumber, @Param("startTime") String startTime, @Param("endTime") String endTime);

    //查询总条数
    Long queryCount(@Param("carNumber") String carNumber, @Param("startTime") String startTime,@Param("endTime") String endTime);
//根据id进行单个删除
    Boolean deleteById(Integer id);
//根据ids进行批量删除
    Boolean deleteByIds(String ids);
//添加和编辑共用的一个查询车主信息方法
    List<Owner> queryOwnerInfo(Integer oid);
//编辑时查询车辆信息
    Car queryCarInfo(Integer id);
//增加车子信息
    Boolean insert(Car car);
//更新车子信息
    Boolean updateCar(Car car);
}
