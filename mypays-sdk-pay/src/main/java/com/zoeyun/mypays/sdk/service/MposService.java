package com.zoeyun.mypays.sdk.service;

import com.zoeyun.mypays.sdk.bean.request.*;
import com.zoeyun.mypays.sdk.bean.result.*;
import com.zoeyun.mypays.sdk.exception.MypaysException;

public interface MposService {

    MposCreateResult create(MposCreateRequest request) throws MypaysException;

    MposGetResult get(MposGetRequest request) throws MypaysException;

    MposCloseResult close(MposCloseRequest request) throws MypaysException;

    MposRefundResult refund(MposRefundRequest request) throws MypaysException;

    MposRefundQueryResult refundQuery(MposRefundQueryRequest request) throws MypaysException;

    MposLedgerRecordCreateResult ledgerRecordCreate(MposLedgerRecordCreateRequest request) throws MypaysException;

    MposLedgerRecordQueryResult ledgerRecordQuery(MposLedgerRecordQueryRequest request) throws MypaysException;

    MposReverseResult reverse(MposReverseRequest request) throws MypaysException;

    MposReverseQueryResult reverseQuery(MposReverseQueryRequest request) throws MypaysException;
}
