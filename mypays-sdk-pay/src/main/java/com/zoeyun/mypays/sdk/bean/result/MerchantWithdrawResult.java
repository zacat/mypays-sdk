package com.zoeyun.mypays.sdk.bean.result;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MerchantWithdrawResult extends BaseMypaysResult {

    /**
     * 提现金额
     */
    Integer transAmount;

    /**
     * 实际到账金额
     */
    Integer payAmount;

    /**
     * 手续费
     */
    Integer serviceFee;
}
