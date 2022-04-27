package com.zoeyun.mypays.sdk.bean.mpos;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;


/**
 * <pre>
 *  提交聚合NATIVE支付请求对象类
 * Created by SinMax on 2022-04-25.
 * </pre>
 *
 * @author <a href="http://docs.mypays.cn/docs/hxtc-faas/mpos-pay-mpos-api-native">SinMax</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class MposCreateRequest extends BaseMypaysRequest {
    /**
     * 商户订单号
     */
    @Required
    String clientOrderId;
    /**
     * 交易类型
     * MPOS
     */
    @Required
    String txnType;
    /**
     * 交易场景
     * ALI：支付宝 WX：微信 UNION：云闪付
     */
    @Required
    String sceneType;
    /**
     * 支付方式
     * NATIVE
     * MICRO
     * JSAPI
     */
    @Required
    String tradeType;
    /**
     * 商品描述
     */
    @Required
    String body;
    /**
     * 备注
     */
    String remark;
    /**
     * 超时时间
     */
    @Required
    String expireTime;
    /**
     * 是否限制贷记卡
     * 0：不限制 1：限制
     */
    @Required
    Integer limitPay;
    /**
     * 交易金额（单位:分）
     */
    @Required
    Long transAmount;
    /**
     * 实际金额（单位:分）
     */
    @Required
    Long payAmount;
    /**
     * 交易渠道
     */
    @Required
    String channelCode;
    /**
     * 支付结果页面
     */
    String frontNotifyUrl;
    /**
     * 商户回调地址
     */
    String clientNotifyUrl;
    /**
     * 商户号
     */
    @Required
    String merchantCode;
    /**
     * 附加参数
     */
    String attach;
    /**
     * 是否延迟分账
     */
    Boolean delay;
    /**
     * 分账交易关系组
     */
    String ledgerRelation;

    List<LedgerRelation> ledgerRelationList;


    /**
     * 公众号/小程序appid
     */
    String subAppid;

    /**
     * 是否为小程序支付
     * 1，表示小程序支付；不传或值不为1，表示公众账号内支付
     */
    String isMinipg;

    /**
     * 微信/支付宝/银联用户ID
     */
    String openId;

    /**
     * 用户的外网IP，sceneType=UNION时必传
     */
    String customerIp;

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
        map.put("clientOrderId", clientOrderId);
        map.put("txnType", txnType);
        map.put("sceneType", sceneType);
        map.put("tradeType", tradeType);
        map.put("body", body);
        map.put("remark", remark);
        map.put("expireTime", expireTime);
        map.put("limitPay", limitPay != null ? String.valueOf(limitPay) : "0");
        map.put("transAmount", transAmount != null ? String.valueOf(transAmount) : "0");
        map.put("payAmount", payAmount != null ? String.valueOf(payAmount) : "0");
        map.put("channelCode", channelCode);
        map.put("frontNotifyUrl", frontNotifyUrl);
        map.put("clientNotifyUrl", clientNotifyUrl);
        map.put("merchantCode", merchantCode);
        map.put("attach", attach);
        map.put("delay", delay != null ? String.valueOf(delay) : "false");
        if (StringUtils.isNotEmpty(ledgerRelation)) {
            map.put("ledgerRelation", ledgerRelation);
        }
        map.put("isMinipg", isMinipg);
        map.put("openId", openId);
        map.put("customerIp", customerIp);
    }
}
