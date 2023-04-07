package com.property.management.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private Integer status;
    private String info;
    private Object data;



    public static RespBean ok(String info, Object data) {
        return new RespBean(200, info, data);
    }


    public static RespBean ok(String info) {
        return new RespBean(200, info, null);
    }

    public static RespBean error(String info, Object data) {
        return new RespBean(500, info, data);
    }


    public static RespBean error(String info) {
        return new RespBean(500, info, null);
    }


}
