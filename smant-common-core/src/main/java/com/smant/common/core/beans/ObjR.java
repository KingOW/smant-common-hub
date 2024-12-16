package com.smant.common.core.beans;

import com.smant.common.core.constants.RCode;
import com.smant.common.core.enums.DefRCode;

import java.io.Serializable;

public class ObjR<T extends Serializable> extends R{

    public static final ObjR<String> DEFAULT_SUCCESS_OBJR = new ObjR(DefRCode.SUCCESS,"");
    public static final ObjR<String> DEFAULT_FAILE_OBJR = new ObjR(DefRCode.FAIL,"");
    private T data;
    public ObjR(int code, String msg,T data) {
        super(code, msg);
        if(data != null) {
            this.data = data;
            this.Count(1);
            this.Total(1);
        }
    }

    public ObjR(RCode rCode,T data) {
        this(rCode.getCode(),rCode.getMsg(),data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
