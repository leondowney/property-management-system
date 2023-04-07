package com.property.management.util;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LayUtil {
    private String code;
    private String msg;
    private Long count;
    private Object data;
}
