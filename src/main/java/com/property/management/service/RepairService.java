package com.property.management.service;

import com.property.management.entity.RepairEntity;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface RepairService {
    List<RepairEntity> selectAll(String repairName);

    Integer selectCount(String repairName);

    boolean deleteOne(Integer id);

    boolean addOne(RepairEntity repairEntity);

    RepairEntity selectId(Integer id);

    boolean updateOne(RepairEntity repairEntity);

    Long deleteById(int parseInt);
}
