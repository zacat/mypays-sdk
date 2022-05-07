package com.zoeyun.mypays.sdk.bean.notify;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MposOrderNotifyResult extends BaseMypaysResult {

    /**
     * 机构ID
     */
    String groupId;
    /**
     * 商户号
     */
    String merchantCode;
    /**
     * 交易类型
     * MPOS:聚合支付
     */
    String txnType;
    /**
     * 交易场景
     * WX：微信 ALI：支付宝 UNION：云闪付 BANK：银行卡
     */
    String sceneType;
    /**
     * 银行卡类型
     */
    String cardType;
    /**
     * 支付方式
     * 反扫：MICRO 正扫：NATIVE 公众号:JSAPI
     */
    String tradeType;
    /**
     * 平台订单号
     */
    String serverOrderId;
    /**
     * 商户订单号
     */
    String clientOrderId;
    /**
     * 交易金额
     */
    Integer transAmount;
    /**
     * 实际到账金额
     */
    Integer payAmount;
    /**
     * 交易状态
     * 0：创建 1：处理中 2：成功 6：失败
     */
    Integer txnStatus;
    /**
     * 附加参数
     */
    String attach;
    /**
     * 错误码
     */
    String errCode;
    /**
     * 错误消息
     */
    String errMessage;
}
