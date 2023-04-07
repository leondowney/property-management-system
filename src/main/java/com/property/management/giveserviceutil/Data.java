package com.property.management.giveserviceutil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@NoArgsConstructor
@lombok.Data
@Builder
@AllArgsConstructor
public class Data {
    private String info;
    private Integer state;
}
