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
@AllArgsConstructor@Data
@Builder
public class Park {
    private long id;
    private long zid;
    private String parkNum;
    private String parkName;
    private Date craterTime;
    private long state;
    private Community community;
}
