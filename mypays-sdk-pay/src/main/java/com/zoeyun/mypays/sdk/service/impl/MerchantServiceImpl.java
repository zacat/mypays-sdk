package com.zoeyun.mypays.sdk.service.impl;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import com.zoeyun.mypays.sdk.bean.request.MerchantBalanceRequest;
import com.zoeyun.mypays.sdk.bean.request.MerchantWithdrawRequest;
import com.zoeyun.mypays.sdk.bean.result.MerchantBalanceResult;
import com.zoeyun.mypays.sdk.bean.result.MerchantWithdrawResult;
import com.zoeyun.mypays.sdk.bean.result.MposCreateResult;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import com.zoeyun.mypays.sdk.service.MerchantService;
import com.zoeyun.mypays.sdk.service.MypaysService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    private final MypaysService payService;

    @Override
    public MerchantBalanceResult balance(MerchantBalanceRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/merchant/balance";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MerchantBalanceResult result = BaseMypaysResult.fromJSON(responseContent, MerchantBalanceResult.class);
        return result;
    }

    @Override
    public MerchantWithdrawResult withdraw(MerchantWithdrawRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/merchant/balance";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MerchantBalanceResult result = BaseMypaysResult.fromJSON(responseContent, MerchantBalanceResult.class);
        return result;
    }
}
