package com.zoeyun.mypays.sdk.bean.request;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.*;

import java.util.Map;


/**
 * <pre>
 *  提交银行卡绑定解除请求对象类
 * Created by SinMax on 2022-05-06.
 * </pre>
 *
 * @author <a href="http://docs.mypays.cn/docs/hxtc-faas/payment-binding-api-cancel">SinMax</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class CardbindingCancelRequest extends BaseMypaysRequest {

    /**
     * 平台订单号
     */
    @Required
    String serverOrderId;


    @Override
    protected void checkConstraints() throws MypaysException {
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("serverOrderId", serverOrderId);
    }
}
