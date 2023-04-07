package com.property.management.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Device {
  private long id;
  private String conmunityName;
  private String deciveNum;
  private String deciveName;
  private String brand;
  private String price;
  private long number;
  private Date purchaseDate;
  private long durationService;
  private Date createTime;
}
