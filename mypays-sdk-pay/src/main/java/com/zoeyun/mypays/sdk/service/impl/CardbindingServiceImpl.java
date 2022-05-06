package com.zoeyun.mypays.sdk.service.impl;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import com.zoeyun.mypays.sdk.bean.request.CardbindingCancelRequest;
import com.zoeyun.mypays.sdk.bean.request.CardbindingConfirmRequest;
import com.zoeyun.mypays.sdk.bean.request.CardbindingCreateRequest;
import com.zoeyun.mypays.sdk.bean.result.CardbindingCancelResult;
import com.zoeyun.mypays.sdk.bean.result.CardbindingConfirmResult;
import com.zoeyun.mypays.sdk.bean.result.CardbindingCreateResult;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import com.zoeyun.mypays.sdk.service.CardbindingService;
import com.zoeyun.mypays.sdk.service.MypaysService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CardbindingServiceImpl implements CardbindingService {

    private final MypaysService payService;

    @Override
    public CardbindingCreateResult create(CardbindingCreateRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/card-binding/create";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        CardbindingCreateResult result = BaseMypaysResult.fromJSON(responseContent, CardbindingCreateResult.class);
        return result;
    }

    @Override
    public CardbindingConfirmResult confirm(CardbindingConfirmRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/card-binding/confirm";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        CardbindingConfirmResult result = BaseMypaysResult.fromJSON(responseContent, CardbindingConfirmResult.class);
        return result;
    }

    @Override
    public CardbindingCancelResult cancel(CardbindingCancelRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/card-binding/cancel";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        CardbindingCancelResult result = BaseMypaysResult.fromJSON(responseContent, CardbindingCancelResult.class);
        return result;
    }
}
