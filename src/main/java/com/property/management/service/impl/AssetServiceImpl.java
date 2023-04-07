package com.property.management.service.impl;

import com.property.management.entity.Asset;
import com.property.management.entity.Charge;
import com.property.management.mapper.AssetMapper;
import com.property.management.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Service("assetService")
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetMapper assetMapper;

    @Override
    public List<Asset> queryByName(String rateName, String startTime, String endTime) {
        return assetMapper.queryByName(rateName,startTime,endTime);
    }

    @Override
    public Long queryByNameCount(String rateName, String startTime, String endTime) {
        return assetMapper.queryByNameCount(rateName,startTime,endTime);
    }

    @Override
    public Boolean deleteAssetById(Integer id) {
        int line = assetMapper.deleteAssetById(id);
        return line>0;
    }

    @Override
    public Boolean deleteAssetByIds(String ids) {
        int line = assetMapper.deleteAssetByIds(ids);
        return line>0;
    }

    @Override
    public Asset queryAssetInfoById(Integer id) {
        return assetMapper.queryAssetInfoById(id);
    }

    @Override
    public List<Charge> qyeryAll() {
        return assetMapper.queryAll();
    }

    @Override
    public Boolean updateAsset(Asset asset) {
        int line = assetMapper.updateAsset(asset);
        return line>0;
    }

    @Override
    public List<Charge> selectRate(String cName) {
        return assetMapper.selectRate(cName);
    }

    @Override
    public boolean insertAsset(Asset asset) {
       int line =  assetMapper.insertAsset(asset);
        return line>0;
    }
}
