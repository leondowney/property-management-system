package com.property.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 车辆管理实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//Serializable 对象序列化的接口，一个类只有实现了Serializable接口，它的对象才能被序列化
public class Car  {
//强烈建议自定义一个serialVersionUID
//  private static final long serialVersionUID=-53440701877036285L;

  private long id;
  private long oid;
  private String carNumber;
  private String color;
  private String picture;
  private String remark;
  private Date createTime;
  private Owner owner;



}
