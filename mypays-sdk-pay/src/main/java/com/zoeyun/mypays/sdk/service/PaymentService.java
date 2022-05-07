package com.zoeyun.mypays.sdk.service;

import com.zoeyun.mypays.sdk.bean.notify.PaymentOrderNotifyResult;
import com.zoeyun.mypays.sdk.bean.request.PaymentCreateRequest;
import com.zoeyun.mypays.sdk.bean.request.PaymentQueryRequest;
import com.zoeyun.mypays.sdk.bean.result.PaymentCreateResult;
import com.zoeyun.mypays.sdk.bean.result.PaymentQueryResult;
import com.zoeyun.mypays.sdk.exception.MypaysException;

import javax.servlet.http.HttpServletRequest;

public interface PaymentService {


    /**
     * 代付订单创建
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    PaymentCreateResult create(PaymentCreateRequest request) throws MypaysException;


    /**
     * 代付订单回调
     *
     * @param request
     * @param responseContent
     * @return
     * @throws MypaysException
     */
    PaymentOrderNotifyResult parseOrderNotifyResult(HttpServletRequest request, String responseContent) throws MypaysException;

    /**
     * 代付订单查询
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    PaymentQueryResult query(PaymentQueryRequest request) throws MypaysException;
}
