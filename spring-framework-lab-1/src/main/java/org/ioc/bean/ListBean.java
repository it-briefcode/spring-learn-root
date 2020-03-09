package org.ioc.bean;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ListBean
 * @Author: zhoucx
 * @Date: 2020/3/8 15:11
 **/
public class ListBean {


    private List<String> list;

    private Map<String,Object> map;


    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ListBean{" +
                "list=" + list +
                ", map=" + map +
                '}';
    }
}
