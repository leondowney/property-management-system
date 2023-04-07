package com.property.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DbPark {

  private long id;
  private long zid;
  private String parkNum;
  private String parkName;
  private java.sql.Timestamp craterTime;
  private long state;




}
