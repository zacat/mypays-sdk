package com.zoeyun.mypays.sdk.bean.result;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MposQueryResult extends BaseMypaysResult {


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
    Integer txnStatus;
    /**
     * 交易金额
     */
    Integer transAmount;
    /**
     * 实际金额
     */
    Integer payAmount;
    /**
     * 退款金额
     */
    Integer refundAmount;
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
    /**
     * 附加参数
     */
    String attach;
}
