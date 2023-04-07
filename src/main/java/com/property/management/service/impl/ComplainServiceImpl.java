package com.property.management.service.impl;

import com.property.management.entity.ComplainEntity;
import com.property.management.mapper.ComplainMapper;
import com.property.management.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service
public class ComplainServiceImpl implements ComplainService {
    @Autowired
    private ComplainMapper complainMapper;

    @Override
    public List<ComplainEntity> selectAll(String complainName) {
        return complainMapper.selectAll(complainName);
    }

    @Override
    public Integer selectCount(String complainName) {
        return complainMapper.selectCount(complainName);
    }

    @Override
    public boolean deleteOne(Integer id) {
        Integer i = complainMapper.deleteOne(id);
        return i>0;
    }

    @Override
    public boolean addOne(ComplainEntity complainEntity) {
        Integer i = complainMapper.addOne(complainEntity);
        return i>0;
    }

    @Override
    public ComplainEntity selectId(Integer id) {
        return complainMapper.selectId(id);
    }

    @Override
    public boolean updateOne(ComplainEntity complainEntity) {
        Integer i = complainMapper.updateOne(complainEntity);
        return i>0;
    }

    @Override
    public Long deleteById(int parseInt) {
        Integer i = complainMapper.deleteById(parseInt);
        return Long.valueOf(i);
    }
}
