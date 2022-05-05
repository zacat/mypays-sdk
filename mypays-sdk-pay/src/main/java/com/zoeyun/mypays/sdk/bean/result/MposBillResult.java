package com.zoeyun.mypays.sdk.bean.result;

import com.zoeyun.mypays.sdk.bean.BaseMypaysListResult;
import com.zoeyun.mypays.sdk.bean.mpos.Bill;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MposBillResult extends BaseMypaysListResult<Bill> {
}
