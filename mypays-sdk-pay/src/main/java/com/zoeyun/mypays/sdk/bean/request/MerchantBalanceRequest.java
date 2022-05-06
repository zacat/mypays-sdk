package com.zoeyun.mypays.sdk.bean.request;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.common.annotation.Required;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.*;

import java.util.Map;

/**
 * <pre>
 *  提交商户余额查询请求对象类
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
public class MerchantBalanceRequest extends BaseMypaysRequest {

    @Required
    String merchantCode;

    @Required
    String channelCode;

    @Override
    protected void checkConstraints() throws MypaysException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("merchantCode", merchantCode);
        map.put("channelCode", channelCode);
    }
}
