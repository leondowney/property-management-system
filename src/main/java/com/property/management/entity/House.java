package com.property.management.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 房屋表(TbHouse)实体类
 */
public class House implements Serializable {
    private static final long serialVersionUID = -34554770746711742L;
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

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", cid=" + cid +
                ", bid=" + bid +
                ", code='" + code + '\'' +
                ", hname='" + hname + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", telephone=" + telephone +
                ", roomNum=" + roomNum +
                ", unit=" + unit +
                ", floor=" + floor +
                ", description='" + description + '\'' +
                ", liveTime=" + liveTime +
                ", community=" + community +
                ", building=" + building +
                '}';
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(Date liveTime) {
        this.liveTime = liveTime;
    }

}

