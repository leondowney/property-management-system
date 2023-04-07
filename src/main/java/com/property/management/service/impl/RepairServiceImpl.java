package com.property.management.service.impl;

import com.property.management.entity.RepairEntity;
import com.property.management.mapper.RepairMapper;
import com.property.management.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper repairMapper;

    @Override
    public List<RepairEntity> selectAll(String repairName) {
        return repairMapper.selectAll(repairName);
    }

    @Override
    public Integer selectCount(String repairName) {
        return repairMapper.selectCount(repairName);
    }

    @Override
    public boolean deleteOne(Integer id) {
        Integer i = repairMapper.deleteOne(id);
        return i>0;
    }

    @Override
    public boolean addOne(RepairEntity activeEntity) {
        Integer i = repairMapper.addOne(activeEntity);
        return i>0;
    }

    @Override
    public RepairEntity selectId(Integer id) {
        return repairMapper.selectId(id);
    }

    @Override
    public boolean updateOne(RepairEntity repairEntity) {
        Integer i = repairMapper.updateOne(repairEntity);
        return i>0;
    }

    @Override
    public Long deleteById(int parseInt) {
        Integer i = repairMapper.deleteById(parseInt);
        return Long.valueOf(i);
    }
}
