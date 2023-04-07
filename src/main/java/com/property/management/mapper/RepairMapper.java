package com.property.management.mapper;

import com.property.management.entity.RepairEntity;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface RepairMapper {
    List<RepairEntity> selectAll(String repairName);

    Integer selectCount(String repairName);

    Integer deleteOne(Integer id);

    Integer addOne(RepairEntity activeEntity);

    Integer updateOne(RepairEntity repairEntity);

    RepairEntity selectId(Integer id);

    Integer deleteById(int parseInt);
}
