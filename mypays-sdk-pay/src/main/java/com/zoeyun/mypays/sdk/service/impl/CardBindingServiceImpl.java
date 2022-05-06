package com.zoeyun.mypays.sdk.service.impl;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import com.zoeyun.mypays.sdk.bean.request.CardBindingCreateRequest;
import com.zoeyun.mypays.sdk.bean.result.CardBindingCreateResult;
import com.zoeyun.mypays.sdk.bean.result.MerchantBalanceResult;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import com.zoeyun.mypays.sdk.service.CardBindingService;
import com.zoeyun.mypays.sdk.service.MypaysService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CardBindingServiceImpl implements CardBindingService {

    private final MypaysService payService;

    @Override
    public CardBindingCreateResult create(CardBindingCreateRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/card-binding/create";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        CardBindingCreateResult result = BaseMypaysResult.fromJSON(responseContent, CardBindingCreateResult.class);
        return result;
    }
}
