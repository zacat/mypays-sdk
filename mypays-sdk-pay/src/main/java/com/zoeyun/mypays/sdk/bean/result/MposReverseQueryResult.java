package com.zoeyun.mypays.sdk.bean.result;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MposReverseQueryResult extends BaseMypaysResult {

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
     * 撤销订单号
     */
    String reverseOrderId;

    /**
     * 交易状态
     * 3：退款中 4：退款
     */
    Integer txnStatus;


    /**
     * 撤销金额
     */
    Integer reverseAmount;
}
