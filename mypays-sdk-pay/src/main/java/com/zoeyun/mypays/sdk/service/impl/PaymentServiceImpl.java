package com.zoeyun.mypays.sdk.service.impl;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import com.zoeyun.mypays.sdk.bean.request.PaymentCreateRequest;
import com.zoeyun.mypays.sdk.bean.request.PaymentQueryRequest;
import com.zoeyun.mypays.sdk.bean.result.MerchantBalanceResult;
import com.zoeyun.mypays.sdk.bean.result.PaymentCreateResult;
import com.zoeyun.mypays.sdk.bean.result.PaymentQueryResult;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import com.zoeyun.mypays.sdk.service.MypaysService;
import com.zoeyun.mypays.sdk.service.PaymentService;
import lombok.RequiredArgsConstructor;

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
    public PaymentQueryResult create(PaymentQueryRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/payment/get";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        PaymentQueryResult result = BaseMypaysResult.fromJSON(responseContent, PaymentQueryResult.class);
        return result;
    }
}
