package com.property.management.entity;


import java.util.Date;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 小区实体类
 */
public class Community {
    private Integer id;
    private String communityNum;
    private String name;
    private String address;
    private Double communityArea;
    private Integer buildingNum;
    private Integer roomNum;
    private String img;
    private Double greeningRate;
    private String developerName;
    private String propertyName;
    private Date hiredate;
    private Integer state;
    private Integer uid;

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", communityNum='" + communityNum + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", communityArea=" + communityArea +
                ", buildingNum=" + buildingNum +
                ", roomNum=" + roomNum +
                ", img='" + img + '\'' +
                ", greeningRate=" + greeningRate +
                ", developerName='" + developerName + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", hiredate=" + hiredate +
                ", state=" + state +
                ", uid=" + uid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommunityNum() {
        return communityNum;
    }

    public void setCommunityNum(String communityNum) {
        this.communityNum = communityNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getCommunityArea() {
        return communityArea;
    }

    public void setCommunityArea(Double communityArea) {
        this.communityArea = communityArea;
    }

    public Integer getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(Integer buildingNum) {
        this.buildingNum = buildingNum;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getGreeningRate() {
        return greeningRate;
    }

    public void setGreeningRate(Double greeningRate) {
        this.greeningRate = greeningRate;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}

