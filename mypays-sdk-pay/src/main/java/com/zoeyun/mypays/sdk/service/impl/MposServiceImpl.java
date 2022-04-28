package com.zoeyun.mypays.sdk.service.impl;

import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import com.zoeyun.mypays.sdk.bean.request.*;
import com.zoeyun.mypays.sdk.bean.result.*;
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
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MposCreateResult result = BaseMypaysResult.fromJSON(responseContent, MposCreateResult.class);
        return result;
    }

    @Override
    public MposGetResult get(MposGetRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/mpos/get";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MposGetResult result = BaseMypaysResult.fromJSON(responseContent, MposGetResult.class);
        return result;
    }

    @Override
    public MposCloseResult close(MposCloseRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/mpos/close";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MposCloseResult result = BaseMypaysResult.fromJSON(responseContent, MposCloseResult.class);
        return result;
    }

    @Override
    public MposRefundResult refund(MposRefundRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/mpos/close";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MposRefundResult result = BaseMypaysResult.fromJSON(responseContent, MposRefundResult.class);
        return result;
    }

    @Override
    public MposRefundQueryResult refundQuery(MposRefundQueryRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/mpos/refund-query";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MposRefundQueryResult result = BaseMypaysResult.fromJSON(responseContent, MposRefundQueryResult.class);
        return result;
    }

    @Override
    public MposLedgerRecordCreateResult ledgerRecordCreate(MposLedgerRecordCreateRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/mpos/ledgerRecordCreate";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MposLedgerRecordCreateResult result = BaseMypaysResult.fromJSON(responseContent, MposLedgerRecordCreateResult.class);
        return result;
    }

    @Override
    public MposLedgerRecordQueryResult ledgerRecordQuery(MposLedgerRecordQueryRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/mpos/ledgerRecordQuery";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MposLedgerRecordQueryResult result = BaseMypaysResult.fromJSON(responseContent, MposLedgerRecordQueryResult.class);
        return result;
    }

    @Override
    public MposReverseResult reverse(MposReverseRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/mpos/reverse";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MposReverseResult result = BaseMypaysResult.fromJSON(responseContent, MposReverseResult.class);
        return result;
    }

    @Override
    public MposReverseQueryResult reverseQuery(MposReverseQueryRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/mpos/reverse-query";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MposReverseQueryResult result = BaseMypaysResult.fromJSON(responseContent, MposReverseQueryResult.class);
        return result;
    }
}
