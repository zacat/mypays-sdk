package com.zoeyun.mypays.sdk.bean.request;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.*;

import java.util.Map;


/**
 * <pre>
 *  提交代付请求对象类
 * Created by SinMax on 2022-05-06.
 * </pre>
 *
 * @author <a href="http://docs.mypays.cn/docs/hxtc-faas/payment-pay-api-pay">SinMax</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCreateRequest extends BaseMypaysRequest {

    /**
     * 商户号
     */
    @Required
    String merchantCode;

    /**
     * 渠道编码
     */
    @Required
    String channelCode;

    /**
     * 商户订单号
     */
    @Required
    String clientOrderId;

    /**
     * 交易金额
     */
    @Required
    Integer transAmount;

    /**
     * 收款卡号
     */
    @Required
    String bankNo;

    /**
     * 收款卡名称
     */
    String bankName;

    /**
     * 预留手机号
     */
    String mobile;

    /**
     * 姓名
     */
    String familyName;

    /**
     * 身份证
     */
    String idCard;

    /**
     * 后台通知地址
     */
    String clientNotifyUrl;

    @Override
    protected void checkConstraints() throws MypaysException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("merchantCode", merchantCode);
        map.put("channelCode", channelCode);
        map.put("clientOrderId", clientOrderId);
        map.put("transAmount", String.valueOf(transAmount));
        map.put("bankNo", bankNo);
        map.put("bankName", bankName);
        map.put("mobile", mobile);
        map.put("familyName", familyName);
        map.put("idCard", idCard);
        map.put("clientNotifyUrl", clientNotifyUrl);
    }
}
