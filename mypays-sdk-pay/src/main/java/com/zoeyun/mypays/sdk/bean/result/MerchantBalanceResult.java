package com.zoeyun.mypays.sdk.bean.result;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MerchantBalanceResult extends BaseMypaysResult {
    /**
     * 未结算余额(D0可提现金额)
     */
    Integer unsettledBalance;
    /**
     * 可提现余额(D1可提现金额 含提现手续费)
     */
    Integer availableBalance;
}
