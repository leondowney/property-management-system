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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Asset {

  private long id;
  private String communityName;
  private String rateName;
  private String owner;
  private String amount;
  private String figure;
  private Date figureDate;
  private String remark;
  private Date createDate;

}
