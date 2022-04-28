package com.zoeyun.mypays.sdk.bean.result;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MposLedgerRecordCreateResult extends BaseMypaysResult {

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
     * 0：创建 1：支付中 2：成功 3：退款中 4：退款 5：关闭 6：失败
     */
    Integer txnStatus;

}
