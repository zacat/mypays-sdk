package com.zoeyun.mypays.sdk.service;

import com.zoeyun.mypays.sdk.bean.request.PaymentCreateRequest;
import com.zoeyun.mypays.sdk.bean.request.PaymentQueryRequest;
import com.zoeyun.mypays.sdk.bean.result.PaymentCreateResult;
import com.zoeyun.mypays.sdk.bean.result.PaymentQueryResult;
import com.zoeyun.mypays.sdk.exception.MypaysException;

public interface PaymentService {


    PaymentCreateResult create(PaymentCreateRequest request)  throws MypaysException;


    PaymentQueryResult create(PaymentQueryRequest request)  throws MypaysException;
}
