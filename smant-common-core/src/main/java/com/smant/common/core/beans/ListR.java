package com.smant.common.core.beans;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.smant.common.core.constants.RCode;
import com.smant.common.core.utils.StringExtUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ListR<T extends Serializable> extends R{

    private List<T> data = Lists.newArrayList();

    public ListR(int code, String msg, List<T> data) {
        super(code, msg);
        if(data != null && !data.isEmpty()){
            this.data = data;
            this.Count(data.size());
        }else{
            this.Count(0);
        }
    }

    public ListR(RCode rCode, List<T> data) {
        this(rCode.getCode(),rCode.getMsg(),data);
    }


    /**
     * 添加属性
     * @param key
     * @param value
     * @return
     */
    public ListR<T> Prop(String key, Object value) {
       return (ListR<T>)super.Prop(key,value);
    }

    /**
     * 批量追加属性
     * @param props
     * @return
     */
    public ListR<T> Props(Map<String, Object> props) {
        return (ListR<T>)super.Props(props);
    }

    public ListR<T> Count(int count) {
       return (ListR<T>)super.Count(count);
    }

    public ListR<T> Total(int total) {
        return (ListR<T>)super.Total(total);
    }
}
