package com.pxzq.maoqiumanager.common;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * API统一返回值类
 *
 * @author ws
 * @date 19/4/23
 */
@Data
public class ResultMessage implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    private Object data;

    public ResultMessage() {}

    public ResultMessage(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultMessage success() {
        ResultMessage result = new ResultMessage();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static ResultMessage success(Object data) {
        ResultMessage result = new ResultMessage();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static ResultMessage failure(ResultCode resultCode) {
        ResultMessage result = new ResultMessage();
        result.setResultCode(resultCode);
        return result;
    }

    public static ResultMessage failure(ResultCode resultCode, Object data) {
        ResultMessage result = new ResultMessage();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

}