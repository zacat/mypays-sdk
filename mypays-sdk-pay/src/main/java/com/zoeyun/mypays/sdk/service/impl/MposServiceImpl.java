package com.zoeyun.mypays.sdk.service.impl;


import com.zoeyun.mypays.sdk.bean.BaseMypaysListResult;
import com.zoeyun.mypays.sdk.bean.BaseMypaysResult;
import com.zoeyun.mypays.sdk.bean.notify.MposOrderNotifyResult;
import com.zoeyun.mypays.sdk.bean.request.*;
import com.zoeyun.mypays.sdk.bean.result.*;
import com.zoeyun.mypays.sdk.common.utils.RsaUtils;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import com.zoeyun.mypays.sdk.service.MposService;
import com.zoeyun.mypays.sdk.service.MypaysService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.PrivateKey;

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
    public MposOrderNotifyResult parseOrderNotifyResult(HttpServletRequest request, String responseContent) throws MypaysException {
        String sign = request.getHeader("x-token-sign");
        if (StringUtils.isEmpty(sign)) {
            throw new MypaysException("sign签名为空");
        }
        PrivateKey privateKey = RsaUtils.getPrivateKeyFromPKCS8(RsaUtils.SIGN_TYPE_RSA2, payService.getConfigStorage().getRsaPriKey().getBytes());
        String checkSign = RsaUtils.rsa256Sign(responseContent.getBytes(), privateKey);
        if (!sign.equals(checkSign)) {
            throw new MypaysException("sign签名无效");
        }
        MposOrderNotifyResult result = BaseMypaysResult.fromJSON(responseContent, MposOrderNotifyResult.class);
        return result;
    }

    @Override
    public MposQueryResult query(MposQueryRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/mpos/get";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MposQueryResult result = BaseMypaysResult.fromJSON(responseContent, MposQueryResult.class);
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

    /**
     * 账单查询
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    @Override
    public MposBillResult bill(MposBillRequest request) throws MypaysException {
        String url = this.payService.getPayBaseUrl() + "/api/txn/mpos/bill";
        request.checkAndSign(payService.getConfigStorage());
        String responseContent = this.payService.post(payService.getAccessToken(), request.getSign(), url, request.toJSONString());
        MposBillResult result = BaseMypaysListResult.fromJSON(responseContent, MposBillResult.class);
        return result;
    }
}
