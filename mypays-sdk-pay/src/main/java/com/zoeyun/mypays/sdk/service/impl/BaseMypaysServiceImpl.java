package com.zoeyun.mypays.sdk.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zoeyun.mypays.sdk.config.MypaysConfigStorage;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import com.zoeyun.mypays.sdk.service.*;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseMypaysServiceImpl implements MypaysService {

    final Logger log = LoggerFactory.getLogger(this.getClass());
    MposService mposService = new MposServiceImpl(this);
    MerchantService merchantService = new MerchantServiceImpl(this);
    PaymentService paymentService = new PaymentServiceImpl(this);
    CardbindingService cardbindingService = new CardbindingServiceImpl(this);


    MypaysConfigStorage mypaysConfigStorage;

    @Override
    public void setConfigStorage(MypaysConfigStorage mypaysConfigStorage) {
        this.mypaysConfigStorage = mypaysConfigStorage;
    }

    @Override
    public MypaysConfigStorage getConfigStorage() {
        return mypaysConfigStorage;
    }

    @Override
    public String getPayBaseUrl() {
        return getConfigStorage().getPayBaseUrl();
    }


    @SneakyThrows
    @Override
    public String getAccessToken() {
        String accessToken = "";
        if (!getConfigStorage().isAccessTokenExpired()) {
            accessToken = getConfigStorage().getAccessToken();
        }
        if (StringUtils.isEmpty(accessToken)) {
            String url = this.getPayBaseUrl() + "/oauth/token";
            String requestStr = "client_id=" + getConfigStorage().getClientId()
                    + "&client_secret=" + getConfigStorage().getClientSecret()
                    + "&grant_type=client_credentials"
                    + "&scope=snsapi_openid";
            try {
                String responseContent = post(url, requestStr);
                if (StringUtils.isNotEmpty(responseContent)) {
                    JSONObject responseObj = JSON.parseObject(responseContent);

                    if (responseObj.containsKey("access_token") && responseObj.containsKey("token_type")) {
                        accessToken = responseObj.getString("token_type") + " " + responseObj.getString("access_token");
                        int expiresIn = responseObj.getIntValue("expires_in");
                        getConfigStorage().updateAccessToken(accessToken, expiresIn);
                    }
                }
            } catch (MypaysException e) {
                e.printStackTrace();
                throw new MypaysException("????????????=" + url, e);
            }

            if (StringUtils.isEmpty(accessToken)) {
                throw new MypaysException("?????????????????????" + url);
            }
        }

        return accessToken;
    }


}
