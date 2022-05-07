package com.zoeyun.mypays.sdk.service.impl;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import com.zoeyun.mypays.sdk.bean.notify.MposOrderNotifyResult;
import com.zoeyun.mypays.sdk.bean.notify.PaymentOrderNotifyResult;
import com.zoeyun.mypays.sdk.bean.request.PaymentCreateRequest;
import com.zoeyun.mypays.sdk.bean.request.PaymentQueryRequest;
import com.zoeyun.mypays.sdk.bean.result.MerchantBalanceResult;
import com.zoeyun.mypays.sdk.bean.result.PaymentCreateResult;
import com.zoeyun.mypays.sdk.bean.result.PaymentQueryResult;
import com.zoeyun.mypays.sdk.common.utils.RsaUtils;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import com.zoeyun.mypays.sdk.service.MypaysService;
import com.zoeyun.mypays.sdk.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.PrivateKey;

@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final MypaysService payService;

    @Override
    public PaymentCreateResult create(PaymentCreateRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/payment/create";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        PaymentCreateResult result = BaseMypaysResult.fromJSON(responseContent, PaymentCreateResult.class);
        return result;
    }

    @Override
    public PaymentOrderNotifyResult parseOrderNotifyResult(HttpServletRequest request, String responseContent) throws MypaysException {
        String sign = request.getHeader("x-token-sign");
        if (StringUtils.isEmpty(sign)) {
            throw new MypaysException("sign签名为空");
        }
        PrivateKey privateKey = RsaUtils.getPrivateKeyFromPKCS8(RsaUtils.SIGN_TYPE_RSA2, payService.getConfigStorage().getRsaPriKey().getBytes());
        String checkSign = RsaUtils.rsa256Sign(responseContent.getBytes(), privateKey);
        if (!sign.equals(checkSign)) {
            throw new MypaysException("sign签名无效");
        }
        PaymentOrderNotifyResult result = BaseMypaysResult.fromJSON(responseContent, PaymentOrderNotifyResult.class);
        return result;
    }

    @Override
    public PaymentQueryResult query(PaymentQueryRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/payment/get";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        PaymentQueryResult result = BaseMypaysResult.fromJSON(responseContent, PaymentQueryResult.class);
        return result;
    }
}
