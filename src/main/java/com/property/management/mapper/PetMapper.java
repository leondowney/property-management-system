package com.property.management.mapper;

import com.property.management.entity.Owner;
import com.property.management.entity.Pet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface PetMapper {

    //查询所有宠物
    List<Pet> selectAllPet(@Param("petName") String petName,@Param("startTime") String startTime,@Param("endTime") String endTime);
//查询宠物总条数
    Long selectAllCount(@Param("petName")String petName,@Param("startTime") String startTime, @Param("endTime")String endTime);
//根据id进行单个删除
    Boolean deleteById(Integer id);
    //根据ids进行批量删除
    Boolean deleteByIds(String ids);
    //添加时渲染宠物主人下拉框
    List<Owner> queryOwner(Integer oid);
    //更新数据时回显的宠物信息
    Pet queryPetById(Integer id);
//插入数据
    Boolean insert(Pet pet);
//更新数据
    Boolean update(Pet pet);
}
