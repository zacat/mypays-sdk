package com.zoeyun.mypays.sdk.service;

import com.zoeyun.mypays.sdk.bean.request.*;
import com.zoeyun.mypays.sdk.bean.result.*;
import com.zoeyun.mypays.sdk.exception.MypaysException;

public interface MerchantService {

    /**
     * 账户查询
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MerchantBalanceResult balance(MerchantBalanceRequest request) throws MypaysException;

    /**
     * 账户提现
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MerchantWithdrawResult withdraw(MerchantWithdrawRequest request) throws MypaysException;

    /**
     * 分账关系创建
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MerchantLedgerRelationsCreateResult ledgerRelationsCreate(MerchantLedgerRelationsCreateRequest request) throws MypaysException;

    /**
     * 分账关系查询
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MerchantLedgerRelationsQueryResult ledgerRelationsQuery(MerchantLedgerRelationsQueryRequest request) throws MypaysException;

    /**
     * 分账关系删除
     *
     * @param request
     * @return
     * @throws MypaysException
     */
    MerchantLedgerRelationsDeleteResult ledgerRelationsDelete(MerchantLedgerRelationsDeleteRequest request) throws MypaysException;
}
