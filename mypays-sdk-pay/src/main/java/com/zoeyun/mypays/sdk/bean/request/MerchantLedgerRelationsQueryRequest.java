package com.zoeyun.mypays.sdk.bean.request;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.*;

import java.util.Map;

/**
 * <pre>
 *  提交聚合支付的分账关系查询请求对象类
 * Created by SinMax on 2022-05-06.
 * </pre>
 *
 * @author <a href="http://docs.mypays.cn/docs/hxtc-faas/legar-relation-query">SinMax</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class MerchantLedgerRelationsQueryRequest extends BaseMypaysRequest {

    /**
     * 分账商户号
     */
    @Required
    String fromMerchantCode;

    /**
     * 收账商户号
     */
    @Required
    String toMerchantCode;

    /**
     * 渠道
     */
    @Required
    String channelCode;



    @Override
    protected void checkConstraints() throws MypaysException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("fromMerchantCode", fromMerchantCode);
        map.put("toMerchantCode", toMerchantCode);
        map.put("channelCode", channelCode);
    }
}
