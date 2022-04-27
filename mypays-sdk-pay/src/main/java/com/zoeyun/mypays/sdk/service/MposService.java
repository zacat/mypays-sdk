package com.zoeyun.mypays.sdk.service;

import com.zoeyun.mypays.sdk.bean.mpos.MposCreateRequest;
import com.zoeyun.mypays.sdk.bean.mpos.MposCreateResult;
import com.zoeyun.mypays.sdk.exception.MypaysException;

public interface MposService {

    MposCreateResult create(MposCreateRequest request) throws MypaysException;
}
