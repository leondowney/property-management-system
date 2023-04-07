package com.property.management.service.impl;

import com.property.management.entity.Charge;
import com.property.management.entity.Community;
import com.property.management.mapper.ChargesMapper;
import com.property.management.service.ChargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service("chargesService")
public class ChargesServiceImpl implements ChargesService {
    @Autowired
    private ChargesMapper chargesMapper;

    @Override
    public List<Charge> queryByName(String chargeName, String startTime, String endTime) {
        return chargesMapper.queryByName(chargeName,startTime,endTime);
    }

    @Override
    public Long queryByNameCount(String chargeName, String startTime, String endTime) {
        return chargesMapper.queryByNameCount(chargeName,startTime,endTime);
    }

    @Override
    public List<Charge> queryById(String id) {
        return chargesMapper.queryById(id);
    }

    @Override
    public boolean updateCharge(Charge charge) {
        int line = chargesMapper.updateCharge(charge);
        return line>0;
    }

    @Override
    public List<Community> queryCommunityInfo() {
        return chargesMapper.queryCommunityInfo();
    }

    @Override
    public boolean chargeInsert(Charge charge) {
        int line = chargesMapper.chargeInsert(charge);
        return line>0;
    }

    @Override
    public Boolean deleteChargeById(Integer id) {
        int line  = chargesMapper.deleteChargeById(id);
        return line>0;
    }

    @Override
    public Boolean deletedChargeByIds(String ids) {
        int line = chargesMapper.deletedChargeByIds(ids);
        return line>0;
    }
}
