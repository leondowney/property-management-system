package com.property.management.service;

import com.property.management.entity.ActiveEntity;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface ActiveService {
    List<ActiveEntity> selectAll(String activeName);

    boolean deleteOne(Integer id);

    boolean addOne(ActiveEntity activeEntity);

    boolean updateOne(ActiveEntity activeEntity);

    ActiveEntity selectId(Integer id);

    Long deleteById(int parseInt);

    Integer selectCount(String activeName);
}
