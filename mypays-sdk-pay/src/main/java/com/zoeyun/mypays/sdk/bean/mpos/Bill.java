package com.zoeyun.mypays.sdk.bean.mpos;

import com.zoeyun.mypays.sdk.common.bean.BaseMypays;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bill extends BaseMypays {

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
     * 0：创建 1：支付中 2：成功 3：退款中 4：退款 5：关闭 6：失败
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
     * 订单详情扩展字符串
     */
    String packageInfo;
    /**
     * 支付地址
     */
    String payUrl;
    /**
     * 二维码地址
     */
    String qrCode;
    /**
     * 预下单订单号
     */
    String prepayId;
    /**
     * 附加参数
     */
    String attach;
}
