package com.property.management.service.impl;

import com.property.management.entity.Community;
import com.property.management.entity.Home;
import com.property.management.entity.Owner;
import com.property.management.mapper.OwnerMapper;
import com.property.management.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerMapper ownerMapper;



//查询所有或者单个业主信息（涉及到分页查询）
    @Override
    public List<Owner> query(String ownerName, String startTime, String endTime) {
        return ownerMapper.query(ownerName,startTime,endTime);
    }



//查询总条数
    @Override
    public Long queryCount(String ownerName, String startTime, String endTime) {
        return ownerMapper.queryCount(ownerName,startTime,endTime);
    }


//    根据id单个删除
    @Override
    public Boolean deleteById(Integer id) {

        return ownerMapper.deleteById(id);
    }
//根据ids批量删除
    @Override
    public Boolean deleteOwnerByIds(String ids) {
        return ownerMapper.deleteByIds(ids);
    }


    //根据选中编辑的id来查询需要回显的数据
    @Override
    public Owner queryById(Integer id) {
        return ownerMapper.queryById(id);
    }

    @Override
    public List<Community> queryCommunityInfo(Integer id) {
        return ownerMapper.queryCommunityInfo(id);
    }

    @Override
    public List<Home> queryHouseInfo(Integer id) {
        return ownerMapper.queryHouseInfo(id);
    }

    @Override
    public Boolean updateOwner(Owner owner) {
        return ownerMapper.updateOwner(owner);
    }

    @Override
    public Boolean insertOwner(Owner owner) {
        return ownerMapper.insert(owner);
    }
}
