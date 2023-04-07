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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
  private long id;
  private String username;
  private String realname;
  private String password;
  private String phone;
  private String email;
  private Date hiredate;
  private long type;
  private String img;
  private long available;
}
