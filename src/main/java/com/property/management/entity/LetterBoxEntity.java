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
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LetterBoxEntity {
    private Integer id;
    private String xiaoQu;
    private String letterSource;
    private String letterName;
    private Date creatTime;
    private String state;
}
