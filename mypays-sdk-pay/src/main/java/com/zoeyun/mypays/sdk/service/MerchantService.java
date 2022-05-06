package com.zoeyun.mypays.sdk.service;

import com.zoeyun.mypays.sdk.bean.request.MerchantBalanceRequest;
import com.zoeyun.mypays.sdk.bean.request.MerchantWithdrawRequest;
import com.zoeyun.mypays.sdk.bean.result.MerchantBalanceResult;
import com.zoeyun.mypays.sdk.bean.result.MerchantWithdrawResult;
import com.zoeyun.mypays.sdk.exception.MypaysException;

public interface MerchantService {

    MerchantBalanceResult balance(MerchantBalanceRequest request) throws MypaysException;
    MerchantWithdrawResult withdraw(MerchantWithdrawRequest request) throws MypaysException;
}
