package com.zoeyun.mypays.sdk.bean.request;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;


/**
 * <pre>
 *  提交银行卡绑定确认请求对象类
 * Created by SinMax on 2022-05-06.
 * </pre>
 *
 * @author <a href="http://docs.mypays.cn/docs/hxtc-faas/payment-binding-api-confirm">SinMax</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class CardbindingConfirmRequest extends BaseMypaysRequest {

    /**
     * 平台订单号
     */
    @Required
    String serverOrderId;



    /**
     * 绑卡申请单号
     */
    @Required
    String bindingOrderId;

    /**
     * 绑卡申请时间
     */
    @Required
    String bindingOrderTime;


    /**
     * 短信验证码
     */
    @Required
    String bindingSmsCode;


    @Override
    protected void checkConstraints() throws MypaysException {
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("serverOrderId", serverOrderId);
        map.put("bindingOrderId", bindingOrderId);
        map.put("bindingOrderTime", bindingOrderTime);
        map.put("bindingSmsCode", bindingSmsCode);
    }
}
