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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Role {
  private long id;
  private String rolename;
  private String roledesc;
  private long available;

}
