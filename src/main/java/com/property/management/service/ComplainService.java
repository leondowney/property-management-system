package com.property.management.service;

import com.property.management.entity.ComplainEntity;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface ComplainService {
    List<ComplainEntity> selectAll(String complainName);

    Integer selectCount(String complainName);

    boolean deleteOne(Integer id);

    boolean addOne(ComplainEntity complainEntity);

    ComplainEntity selectId(Integer id);

    boolean updateOne(ComplainEntity complainEntity);

    Long deleteById(int parseInt);
}
