package com.zoeyun.mypays.sdk.service;

import com.zoeyun.mypays.sdk.bean.request.CardbindingCancelRequest;
import com.zoeyun.mypays.sdk.bean.request.CardbindingConfirmRequest;
import com.zoeyun.mypays.sdk.bean.request.CardbindingCreateRequest;
import com.zoeyun.mypays.sdk.bean.result.CardbindingCancelResult;
import com.zoeyun.mypays.sdk.bean.result.CardbindingConfirmResult;
import com.zoeyun.mypays.sdk.bean.result.CardbindingCreateResult;
import com.zoeyun.mypays.sdk.exception.MypaysException;

public interface CardbindingService {


    /**
     * 银行卡绑定
     */

    CardbindingCreateResult create(CardbindingCreateRequest request) throws MypaysException;


    /**
     * 银行卡确认
     */

    CardbindingConfirmResult confirm(CardbindingConfirmRequest request) throws MypaysException;


    /**
     * 银行卡解除
     */

    CardbindingCancelResult cancel(CardbindingCancelRequest request) throws MypaysException;
}
