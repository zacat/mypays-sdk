package com.zoeyun.mypays.sdk.bean.result;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MposRefundQueryResult extends BaseMypaysResult {
    /**
     * 商户号
     */
    String merchantCode;
    /**
     * 商户名称
     */
    String merchantName;
    /**
     * 平台订单号
     */
    String serverOrderId;
    /**
     * 商户订单号
     */
    String clientOrderId;
    /**
     * 退款订单号
     */
    String refundOrderId;
    /**
     * 交易状态
     * 0：创建 1：支付中 2：成功 3：退款中 4：退款 5：关闭 6：失败
     */
    Integer txnStatus;
    /**
     * 交易金额
     */
    Integer refundAmount;
}
