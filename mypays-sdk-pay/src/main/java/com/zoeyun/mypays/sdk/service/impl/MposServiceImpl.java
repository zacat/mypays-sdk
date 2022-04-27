package com.zoeyun.mypays.sdk.service.impl;

import com.zoeyun.mypays.sdk.bean.BaseMypaysRequest;
import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import com.zoeyun.mypays.sdk.bean.mpos.MposCreateRequest;
import com.zoeyun.mypays.sdk.bean.mpos.MposCreateResult;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import com.zoeyun.mypays.sdk.service.MposService;
import com.zoeyun.mypays.sdk.service.MypaysService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MposServiceImpl implements MposService {

    private final MypaysService payService;


    @Override
    public MposCreateResult create(MposCreateRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/mpos/create";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(url, request.toString(), payService.getAccessToken(), request.getSign());
        MposCreateResult result = BaseMypaysResult.fromJSON(responseContent, MposCreateResult.class);
        return result;
    }
}
