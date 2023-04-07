package com.property.management.service;

import com.property.management.entity.Asset;
import com.property.management.entity.Charge;

import java.util.List;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public interface AssetService {
    List<Asset> queryByName(String rateName, String startTime, String endTime);
    Long queryByNameCount(String rateName, String startTime, String endTime);

    Boolean deleteAssetById(Integer id);

    Boolean deleteAssetByIds(String ids);

    Asset queryAssetInfoById(Integer id);

    List<Charge> qyeryAll();

    Boolean updateAsset(Asset asset);

    List<Charge> selectRate(String cName);

    boolean insertAsset(Asset asset);
}
