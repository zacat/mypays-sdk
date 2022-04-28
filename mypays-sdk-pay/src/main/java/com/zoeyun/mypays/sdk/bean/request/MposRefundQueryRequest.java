package com.zoeyun.mypays.sdk.bean.request;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.*;

import java.util.Map;

/**
 * <pre>
 *  提交聚合退款订单状态查询请求对象类
 * Created by SinMax on 2022-04-25.
 * </pre>
 *
 * @author <a href="http://docs.mypays.cn/docs/hxtc-faas/mpos-pay-mpos-api-refund-query">SinMax</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class MposRefundQueryRequest extends BaseMypaysRequest {

    /**
     * 退款订单号
     */
    @Required
    String refundOrderId;

    @Override
    protected void checkConstraints() throws MypaysException {

    }

    /**
     * 将属性组装到一个Map中，供签名和最终发送XML时使用.
     * 这里需要将所有的属性全部保存进来，签名的时候会自动调用getIgnoredParamsForSign进行忽略，
     * 不用担心。否则最终生成的XML会缺失。
     *
     * @param map 传入的属性Map
     */
    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("refundOrderId", refundOrderId);
    }
}
