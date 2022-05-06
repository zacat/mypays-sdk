package com.zoeyun.mypays.sdk.bean.request;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;


/**
 * <pre>
 *  提交代付查询请求对象类
 * Created by SinMax on 2022-05-06.
 * </pre>
 *
 * @author <a href="http://docs.mypays.cn/docs/hxtc-faas/payment-pay-api-query">SinMax</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentQueryRequest extends BaseMypaysRequest {

    /**
     * 商户订单号
     */
    String clientOrderId;

    /**
     * 平台订单号
     */
    String serverOrderId;


    @Override
    protected void checkConstraints() throws MypaysException {

        if (StringUtils.isEmpty(getClientOrderId()) || StringUtils.isEmpty(getServerOrderId())) {
            throw new MypaysException("clientOrderId 和 serverOrderId 不能同时为空，必须提供一个");
        }

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("serverOrderId", serverOrderId);
        map.put("clientOrderId", clientOrderId);
    }
}
