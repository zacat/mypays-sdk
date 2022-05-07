package com.zoeyun.mypays.sdk.bean.notify;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PaymentOrderNotifyResult extends BaseMypaysResult {

    /**
     * 机构ID
     */
    String groupId;
    /**
     * 商户号
     */
    String merchantCode;
    /**
     * 平台订单号
     */
    String serverOrderId;
    /**
     * 商户订单号
     */
    String clientOrderId;
    /**
     * 交易金额
     */
    Integer transAmount;
    /**
     * 交易金额
     */
    Integer serviceFee;
    /**
     * 交易状态
     * 0：创建 1：处理中 2：成功 6：失败
     */
    Integer txnStatus;
    /**
     * 错误码
     */
    String errCode;
    /**
     * 错误消息
     */
    String errMessage;
}
