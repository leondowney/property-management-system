package com.property.management.service.impl;

import com.property.management.entity.LetterBoxEntity;
import com.property.management.mapper.LetterBoxMapper;
import com.property.management.service.LetterBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service
public class LetterBoxServiceImpl implements LetterBoxService {
    @Autowired
    private LetterBoxMapper letterBoxMapper;
    @Override
    public List<LetterBoxEntity> selectAll(String litterBoxName) {
        return letterBoxMapper.selectAll(litterBoxName);
    }

    @Override
    public Integer selectCount(String litterBoxName) {
        return letterBoxMapper.selectCount(litterBoxName);
    }

    @Override
    public boolean deleteOne(Integer id) {
        Integer i = letterBoxMapper.deleteOne(id);
        return i>0;
    }

    @Override
    public boolean addOne(LetterBoxEntity letterBoxEntity) {
        Integer i = letterBoxMapper.addOne(letterBoxEntity);
        return i>0;
    }

    @Override
    public LetterBoxEntity selectId(Integer id) {
        return letterBoxMapper.selectId(id);
    }

    @Override
    public boolean updateOne(LetterBoxEntity letterBoxEntity) {
        Integer i = letterBoxMapper.updateOne(letterBoxEntity);
        return i>0;
    }

    @Override
    public Long deleteById(int parseInt) {
        Integer i = letterBoxMapper.deleteById(parseInt);
        return Long.valueOf(i);
    }
}
