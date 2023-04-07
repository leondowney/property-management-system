package com.property.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Admin extends User{
  private String rolename;
}
