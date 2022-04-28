package com.zoeyun.mypays.sdk.bean.request;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.bean.mpos.LedgerRelation;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.config.MypaysConfigStorage;
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
     * 商户号
     */
    @Required
    String merchantCode;
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
    @Builder.Default
    String txnType = "MPOS";
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
    Integer transAmount;
    /**
     * 实际金额（单位:分）
     */
    @Required
    Integer payAmount;
    /**
     * 交易渠道
     */
    @Required
    @Builder.Default
    String channelCode = "HAIKE";
    /**
     * 支付结果页面
     */
    String frontNotifyUrl;
    /**
     * 商户回调地址
     */
    String clientNotifyUrl;

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
        if (transAmount.compareTo(0) == 0) {
            throw new MypaysException("交易金额不能为空或为0");
        }
        if (payAmount.compareTo(0) == 0) {
            throw new MypaysException("实际金额不能为空或为0");
        }
        if (getTradeType() != null && getTradeType().equalsIgnoreCase("JSAPI")) {
            if (StringUtils.isEmpty(getOpenId())) {
                throw new MypaysException("JSAPI支付openId不能为空");
            }
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
        map.put("merchantCode", merchantCode);
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
        map.put("attach", attach);
        map.put("delay", delay != null ? String.valueOf(delay) : "false");
        map.put("ledgerRelation", ledgerRelation);
        map.put("isMinipg", isMinipg);
        map.put("openId", openId);
        map.put("customerIp", customerIp);
    }

    /**
     * <pre>
     * 检查参数，并设置签名.
     * 1、检查参数（注意：子类实现需要检查参数的而外功能时，请在调用父类的方法前进行相应判断）
     * 2、补充系统参数，如果未传入则从配置里读取
     * 3、生成签名，并设置进去
     * </pre>
     *
     * @param configStorage 支付配置对象，用于读取相应系统配置信息
     * @throws MypaysException the wx pay exception
     */
    @Override
    public void checkAndSign(MypaysConfigStorage configStorage) throws MypaysException {
        if (StringUtils.isBlank(merchantCode)) {
            this.merchantCode = configStorage.getMerchantCode();
        }
        super.checkAndSign(configStorage);
    }
}
