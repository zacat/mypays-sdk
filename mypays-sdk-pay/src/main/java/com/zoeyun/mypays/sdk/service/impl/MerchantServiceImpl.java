package com.zoeyun.mypays.sdk.service.impl;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import com.zoeyun.mypays.sdk.bean.request.*;
import com.zoeyun.mypays.sdk.bean.result.*;
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
        String url = this.payService.getPayBaseUrl() + "/api/merchant/withdraw";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MerchantWithdrawResult result = BaseMypaysResult.fromJSON(responseContent, MerchantWithdrawResult.class);
        return result;
    }

    @Override
    public MerchantLedgerRelationsCreateResult ledgerRelationsCreate(MerchantLedgerRelationsCreateRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/merchant/ledger-relations/create";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MerchantLedgerRelationsCreateResult result = BaseMypaysResult.fromJSON(responseContent, MerchantLedgerRelationsCreateResult.class);
        return result;
    }

    @Override
    public MerchantLedgerRelationsQueryResult ledgerRelationsQuery(MerchantLedgerRelationsQueryRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/merchant/ledger-relations/get";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MerchantLedgerRelationsQueryResult result = BaseMypaysResult.fromJSON(responseContent, MerchantLedgerRelationsQueryResult.class);
        return result;
    }

    @Override
    public MerchantLedgerRelationsDeleteResult ledgerRelationsDelete(MerchantLedgerRelationsDeleteRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/merchant/ledger-relations/delete";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MerchantLedgerRelationsDeleteResult result = BaseMypaysResult.fromJSON(responseContent, MerchantLedgerRelationsDeleteResult.class);
        return result;
    }
}
