package com.zoeyun.mypays.sdk.bean.result;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MposLedgerRecordQueryResult extends BaseMypaysResult {

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
     * 商户分账订单号
     */
    String clientLedgerOrderId;

    /**
     * 平台分账订单号
     */
    String ledgerOrderId;

    /**
     * 交易状态
     * 1：支付中 2：支付成功 4：退款成功 6：支付失败
     */
    Integer txnStatus;

}
