package com.zoeyun.mypays.sdk.service;

import com.zoeyun.mypays.sdk.bean.notify.MposOrderNotifyResult;
import com.zoeyun.mypays.sdk.bean.request.*;
import com.zoeyun.mypays.sdk.bean.result.*;
import com.zoeyun.mypays.sdk.exception.MypaysException;

import javax.servlet.http.HttpServletRequest;

public interface MposService {

    /**
     * 创建聚合支付订单
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MposCreateResult create(MposCreateRequest request) throws MypaysException;

    /**
     * 解析聚合支付订单回调
     */
    MposOrderNotifyResult parseOrderNotifyResult(HttpServletRequest request, String responseContent) throws MypaysException;


    /**
     * 交易订单查询
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MposQueryResult query(MposQueryRequest request) throws MypaysException;

    /**
     * 交易订单关闭
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MposCloseResult close(MposCloseRequest request) throws MypaysException;

    /**
     * 普通交易订单退款，及延时分账交易支付确认后，对分账订单的退款，延时分账未确认的支付请通过支付撤销退款
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MposRefundResult refund(MposRefundRequest request) throws MypaysException;

    /**
     * 退款订单状态查询
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MposRefundQueryResult refundQuery(MposRefundQueryRequest request) throws MypaysException;

    /**
     * 创建分账订单，并返回平台分账订单号
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MposLedgerRecordCreateResult ledgerRecordCreate(MposLedgerRecordCreateRequest request) throws MypaysException;

    /**
     * 分账订单结果查询
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MposLedgerRecordQueryResult ledgerRecordQuery(MposLedgerRecordQueryRequest request) throws MypaysException;

    /**
     * 支付撤销
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MposReverseResult reverse(MposReverseRequest request) throws MypaysException;

    /**
     * 撤销订单查询
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MposReverseQueryResult reverseQuery(MposReverseQueryRequest request) throws MypaysException;

    /**
     * 账单查询
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MposBillResult bill(MposBillRequest request) throws MypaysException;
}
