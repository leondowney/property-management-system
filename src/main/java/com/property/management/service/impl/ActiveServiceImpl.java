package com.property.management.service.impl;

import com.property.management.entity.ActiveEntity;
import com.property.management.mapper.ActiveMapper;
import com.property.management.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service
public class ActiveServiceImpl implements ActiveService {
    @Autowired
    private ActiveMapper activeMapper;
    @Override
    public List<ActiveEntity> selectAll(String activeName) {
        return activeMapper.selectAll(activeName);
    }

    @Override
    public boolean deleteOne(Integer id) {
        Long i = activeMapper.deleteOne(id);
        return i>0;
    }

    @Override
    public boolean addOne(ActiveEntity activeEntity) {
        Long i = activeMapper.addOne(activeEntity);
        return i>0;
    }

    @Override
    public boolean updateOne(ActiveEntity activeEntity) {
        Long i = activeMapper.updateOne(activeEntity);
        return i>0;
    }

    @Override
    public ActiveEntity selectId(Integer id) {
        ActiveEntity i = activeMapper.selectId(id);
        return i;
    }

    @Override
    public Long deleteById(int parseInt) {
        Long i = activeMapper.deleteById(parseInt);
        return i;
    }

    @Override
    public Integer selectCount(String activeName) {
        return activeMapper.selectCount(activeName);
    }
}
