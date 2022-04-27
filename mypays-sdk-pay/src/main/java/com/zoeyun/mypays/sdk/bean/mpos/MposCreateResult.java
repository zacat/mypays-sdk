package com.zoeyun.mypays.sdk.bean.mpos;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class MposCreateResult extends BaseMypaysResult {


    /**
     * 机构ID
     */
    Long groupId;
    /**
     * 商户号
     */
    String merchantCode;
    /**
     * 商户名称
     */
    String merchantName;
    /**
     * 平台订单号
     */
    String serverOrderId;
    /**
     * 商户订单号
     */
    String clientOrderId;
    /**
     * 交易类型
     */
    String txnType;
    /**
     * 支付方式
     */
    String tradeType;
    /**
     * 交易场景
     */
    String sceneType;
    /**
     * 支付卡类型
     */
    String cardType;
    /**
     * 交易状态
     */
    String txnStatus;
    /**
     * 交易金额
     */
    Long transAmount;
    /**
     * 实际金额
     */
    Long payAmount;
    /**
     * 二维码图片地址
     */
    String qrCode;
    /**
     * 付款地址
     */
    String payUrl;
    /**
     * 订单详情扩展字符串
     */
    String packageInfo;
    /**
     * 预下单订单号
     */
    String prepayId;
}
