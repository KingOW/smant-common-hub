package com.smant.common.core.beans;

import com.google.common.collect.Maps;
import com.smant.common.core.constants.CommConstants;
import com.smant.common.core.constants.RCode;
import com.smant.common.core.enums.DefRCode;
import com.smant.common.core.utils.StringExtUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * 运行结果
 *
 */
public class R implements Serializable {

    private int code;//操作结果编码
    private String msg;//操作结果消息
//    private T data;//操作结果数据
    private int count = 0;//操作结果数量
    private int total = 0;//操作结果总数
    //操作属性
    private Map<String, Object> props = Maps.newHashMap();

    public static final R DEFAULT_SUCCESS_R = new R(DefRCode.SUCCESS);
    public static final R DEFAULT_FAILE_R = new R(DefRCode.FAIL);


    public R(int code,String msg){
        this.code = code;
        this.msg = msg;
        this.count = 0;
        this.total = 0;
    }
    public R(RCode rCode){
        this(rCode.getCode(), rCode.getMsg());
    }

//    /**
//     * 构造函数
//     *
//     * @param code
//     * @param msg
//     * @param data
//     */
//    public R(int code, String msg, T data) {
//        this.code = code;
//        this.msg = msg;
//        this.data = data;
//        if (data == null) {
//            this.count = 0;
//            this.total = 0;
//        } else if (data instanceof Collection<?>) {
//            this.count = ((Collection<?>) data).size();
//        } else if (data instanceof Map<?, ?> && ((Map<?, ?>) data).isEmpty()) {
//            this.count = 0;
//            this.total = 0;
//        } else {
//            this.count = 1;
//            this.total = 1;
//        }
//    }

//    public R(RCode rCode, T data) {
//        this(rCode.getCode(), rCode.getMsg(), data);
//    }


    /**
     * 添加属性
     * @param key
     * @param value
     * @return
     */
    public R Prop(String key, Object value) {
        if (this.props == null)
            this.props = Maps.newHashMap();
        if (!StringExtUtils.isEmpty(StringExtUtils.trimStr(key))) {
            this.props.put(StringExtUtils.trimStr(key), value);
        }
        return this;
    }

    /**
     * 批量追加属性
     * @param props
     * @return
     */
    public R Props(Map<String, Object> props) {
        if (this.props == null) {
            this.props = Maps.newHashMap();
        }
        if(props != null){
            this.props.putAll(props);
        }
        return this;
    }

    public R Count(int count) {
        this.count = count;
        return this;
    }

    public R Total(int total) {
        this.total = total;
        return this;
    }

    public <T> T PropVal(String key){
        String key_ = StringExtUtils.trimStr(key);
        if(!StringExtUtils.isEmpty(key_) && !this.props.isEmpty() && this.props.containsKey(key_)){
            return (T)this.props.get(key_);
        }
        return null;
    }

    public boolean ExistProp(String key){
        String key_ = StringExtUtils.trimStr(key);
        if(!StringExtUtils.isEmpty(key_) && !this.props.isEmpty()){
            return this.props.containsKey(key_);
        }
        return CommConstants.BOOLEAN_FALSE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }
}
