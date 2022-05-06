package com.zoeyun.mypays.sdk.bean.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MerchantLedgerRelationsQueryResult extends BaseMypaysResult {

    /**
     * 分账关系状态
     * 1：审核中 2：审核成功 3：审核失败
     */
    @JSONField(name = "status")
    Integer txnStatus;

    /**
     * 关系审核信息
     */
    String errMessage;
}
