package com.zoeyun.mypays.sdk.bean.request;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;


/**
 * <pre>
 *  提交银行卡绑定请求对象类
 * Created by SinMax on 2022-05-06.
 * </pre>
 *
 * @author <a href="http://docs.mypays.cn/docs/hxtc-faas/mpos-mch-api-balance">SinMax</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class CardBindingCreateRequest extends BaseMypaysRequest {

    /**
     * 商户订单号
     */
    @Required
    String clientOrderId;

    /**
     * 业务类型
     * 代付：PAYMENT
     */
    @Required
    @Builder.Default
    String txnType = "PAYMENT";

    /**
     * 渠道编码
     */
    @Required
    String channelCode;

    /**
     * 持卡人姓名
     */
    @Required
    String familyName;

    /**
     * 证件号码
     */
    @Required
    String idCard;

    /**
     * 银行预留手机号码
     */
    @Required
    String mobile;

    /**
     * 银行卡号
     */
    @Required
    String bankNo;

    /**
     * 银行名称
     */
    @Required
    String bankName;

    /**
     * 联行号
     */
    String bankId;

    /**
     * 银行代码
     */
    String bankCode;

    /**
     * 银行卡类型
     * 借记卡：0 信用卡：1
     */
    @Required
    @Builder.Default
    Integer cardType = 0;

    /**
     * 结算类型
     * 对公：0 对私：1 ，对公只需要绑卡申请，不需要确认
     */
    @Required
    @Builder.Default
    Integer payeeType = 0;

    /**
     * 安全码
     * 信用卡必填
     */
    String cv2;

    /**
     * 有效期
     * 信用卡必填
     */
    String expireDate;


    @Override
    protected void checkConstraints() throws MypaysException {

        if (getCardType() == 1) {
            if (StringUtils.isEmpty(getCv2())) {
                throw new MypaysException("安全码不能为空");
            }

            if (StringUtils.isEmpty(getExpireDate())) {
                throw new MypaysException("有效期不能为空");
            }
        }
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("clientOrderId", clientOrderId);
        map.put("txnType", txnType);
        map.put("channelCode", channelCode);
        map.put("familyName", familyName);
        map.put("idCard", idCard);
        map.put("mobile", mobile);
        map.put("bankNo", bankNo);
        map.put("bankName", bankName);
        map.put("bankId", bankId);
        map.put("bankCode", bankCode);
        map.put("cardType", String.valueOf(cardType));
        map.put("payeeType", String.valueOf(payeeType));
        map.put("cv2", cv2);
        map.put("expireDate", expireDate);
    }
}
