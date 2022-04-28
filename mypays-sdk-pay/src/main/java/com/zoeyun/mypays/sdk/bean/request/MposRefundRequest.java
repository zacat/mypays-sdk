package com.zoeyun.mypays.sdk.bean.request;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;


/**
 * <pre>
 *  提交聚合申请退款请求对象类
 * Created by SinMax on 2022-04-25.
 * </pre>
 *
 * @author <a href="http://docs.mypays.cn/docs/hxtc-faas/mpos-pay-mpos-api-refund">SinMax</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class MposRefundRequest extends BaseMypaysRequest {

    /**
     * 商户订单号
     */
    String clientOrderId;

    /**
     * 平台订单号
     */
    String serverOrderId;

    /**
     * 商户分账订单号
     */
    String clientLedgerOrderId;

    /**
     * 平台分账订单号
     */
    String ledgerOrderId;

    /**
     * 退款金额
     */
    @Required
    Integer refundAmount;

    /**
     * 分账交易关系组
     */
    String ledgerRelation;

    @Override
    protected void checkConstraints() throws MypaysException {
        if (StringUtils.isEmpty(clientOrderId) && StringUtils.isEmpty(serverOrderId)) {
            throw new MypaysException("clientOrderId 和 serverOrderId 不能同时为空，必须提供一个");
        }
        if (StringUtils.isNotEmpty(ledgerOrderId) || StringUtils.isNotEmpty(clientLedgerOrderId)) {

            if (StringUtils.isEmpty(ledgerRelation)) {
                throw new MypaysException("ledgerRelation 分账交易退款是不能为空");
            }
        }
        if(refundAmount.compareTo(0)==0){
            throw new MypaysException("退款金额不能为空或为0");
        }
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
        map.put("clientOrderId", clientOrderId);
        map.put("serverOrderId", serverOrderId);
        map.put("ledgerOrderId", ledgerOrderId);
        map.put("clientLedgerOrderId", clientLedgerOrderId);
        map.put("ledgerRelation", ledgerRelation);
    }
}
