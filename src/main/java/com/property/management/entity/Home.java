package com.property.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Home  {

    /**
     * 房屋ID
     */
    private Integer id;
    /**
     * 所属小区ID
     */
    private Integer cid;
    /**
     * 所属栋数ID
     */
    private Integer bid;
    /**
     * 房产编码
     */
    private String code;
    /**
     * 房产名称
     */
    private String hname;
    /**
     * 户主（业主）名称
     */
    private String ownerName;
    /**
     * 联系方式
     */
    private String telephone;
    /**
     * 房间数
     */
    private Integer roomNum;
    /**
     * 单元
     */
    private Integer unit;
    /**
     * 楼层
     */
    private Integer floor;
    /**
     * 描述
     */
    private String description;
    /**
     * 入住时间
     */
    private Date liveTime;

    private Community community;
    private Building building;


}

