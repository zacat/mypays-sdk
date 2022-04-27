package com.zoeyun.mypays.sdk.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class MypaysException extends Exception {

    /**
     * 自定义错误讯息.
     */
    private String customErrorMsg;
    /**
     * 返回状态码.
     */
    private String returnCode;
    /**
     * 返回信息.
     */
    private String returnMsg;

    /**
     * 业务结果.
     */
    private String resultCode;

    /**
     * 错误代码.
     */
    private String errCode;

    /**
     * 错误代码描述.
     */
    private String errCodeDes;

    /**
     * 微信支付返回的结果字符串.
     */
    private String responseContent;

    /**
     * Instantiates a new Wx pay exception.
     *
     * @param customErrorMsg the custom error msg
     */
    public MypaysException(String customErrorMsg) {
        super(customErrorMsg);
        this.customErrorMsg = customErrorMsg;
    }

    /**
     * Instantiates a new Wx pay exception.
     *
     * @param customErrorMsg the custom error msg
     * @param tr             the tr
     */
    public MypaysException(String customErrorMsg, Throwable tr) {
        super(customErrorMsg, tr);
        this.customErrorMsg = customErrorMsg;
    }
}
