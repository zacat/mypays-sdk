package com.zoeyun.mypays.sdk.service;

import com.zoeyun.mypays.sdk.bean.request.CardBindingCreateRequest;
import com.zoeyun.mypays.sdk.bean.result.CardBindingCreateResult;
import com.zoeyun.mypays.sdk.exception.MypaysException;

public interface CardBindingService {


    /**
     * 银行卡绑定
     */

    CardBindingCreateResult create(CardBindingCreateRequest request) throws MypaysException;
}
