package com.zoeyun.mypays.sdk.bean.request;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.*;

import java.util.Map;

/**
 * <pre>
 *  提交商户余额提现请求对象类
 * Created by SinMax on 2022-05-06.
 * </pre>
 *
 * @author <a href="http://docs.mypays.cn/docs/hxtc-faas/mpos-mch-api-withdraw">SinMax</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class MerchantWithdrawRequest extends BaseMypaysRequest {

    /**
     * 商户号
     */
    @Required
    String merchantCode;

    /**
     * 渠道
     */
    @Required
    String channelCode;

    /**
     * 提现金额
     */
    @Required
    Integer transAmount;


    @Override
    protected void checkConstraints() throws MypaysException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("merchantCode", merchantCode);
        map.put("channelCode", channelCode);
        map.put("transAmount", String.valueOf(transAmount));
    }
}
