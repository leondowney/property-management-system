package com.property.management.mapper;

import com.property.management.entity.LetterBoxEntity;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface LetterBoxMapper {
    List<LetterBoxEntity> selectAll(String litterBoxName);

    Integer selectCount(String litterBoxName);

    Integer deleteOne(Integer id);

    Integer addOne(LetterBoxEntity letterBoxEntity);

    LetterBoxEntity selectId(Integer id);

    Integer updateOne(LetterBoxEntity letterBoxEntity);

    Integer deleteById(int parseInt);
}
