package com.zoeyun.mypays.sdk.bean.result;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CardbindingCreateResult extends BaseMypaysResult {

    /**
     * 交易状态
     * 1：处理中 2:成功
     */
    Integer txnStatus;

    /**
     * 平台订单号
     */
    String serverOrderId;

    /**
     * 商户订单号
     */
    String clientOrderId;

    /**
     * 绑卡申请单号
     */
    String bindingOrderId;

    /**
     * 绑卡申请时间
     */
    String bindingOrderTime;
}
