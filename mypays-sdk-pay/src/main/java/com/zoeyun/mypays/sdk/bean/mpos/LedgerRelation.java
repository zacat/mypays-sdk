package com.zoeyun.mypays.sdk.bean.mpos;

import com.zoeyun.mypays.sdk.common.bean.BaseMypays;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class LedgerRelation extends BaseMypays {
    private static final long serialVersionUID = 1748279642650652681L;

    String merchantCode;
    Long amount;
    Boolean feeFlag;
}
