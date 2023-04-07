package com.property.management.giveserviceutil;

import java.util.ArrayList;

/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe：
 */
public class ParamDTO {
    private ArrayList<Integer> ids;

    public ArrayList<Integer> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "ParamDTO{" +
                "ids=" + ids +
                '}';
    }
}
