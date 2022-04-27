package com.zoeyun.mypays.sdk.service;

import com.zoeyun.mypays.sdk.config.MypaysConfigStorage;
import com.zoeyun.mypays.sdk.exception.MypaysException;

public interface MypaysService {

    String getPayBaseUrl();
 

    void setConfigStorage(MypaysConfigStorage mypaysConfigStorage);
    MypaysConfigStorage getConfigStorage();

    String getAccessToken();

    /**
     * 发送post请求，得到响应字节数组.
     *
     * @param url        请求地址
     * @param requestStr 请求参数的RSA加密
     * @return 返回请求结果字节数组 byte [ ]
     * @throws MypaysException the wx pay exception
     */
    byte[] postForBytes(String url, String requestStr) throws MypaysException;

    /**
     * 发送post请求，得到响应字节数组.
     *
     * @param authorization 授权许可
     * @param sign          请求参数的RSA加密
     * @param url           请求地址
     * @param requestStr    请求参数的RSA加密
     * @return 返回请求结果字节数组 byte [ ]
     * @throws MypaysException the wx pay exception
     */
    byte[] postForBytes(String authorization, String sign, String url, String requestStr) throws MypaysException;

    /**
     * 发送post请求，得到响应字符串.
     *
     * @param url        请求地址
     * @param requestStr 请求信息
     * @return 返回请求结果字符串 string
     * @throws MypaysException the wx pay exception
     */
    String post(String url, String requestStr) throws MypaysException;

    /**
     * 发送post请求，得到响应字符串.
     *
     * @param url        请求地址
     * @param requestStr 请求信息
     * @return 返回请求结果字符串 string
     * @throws MypaysException the wx pay exception
     */
    String postJSON(String url, String requestStr) throws MypaysException;

    /**
     * 发送post请求，得到响应字符串.
     *
     * @param authorization 授权许可
     * @param sign          请求参数的RSA加密
     * @param url           请求地址
     * @param requestStr    请求信息
     * @return 返回请求结果字符串 string
     * @throws MypaysException the wx pay exception
     */
    String post(String authorization, String sign, String url, String requestStr) throws MypaysException;

    /**
     * 发送post请求，得到响应字符串.
     *
     * @param authorization 授权许可
     * @param sign          请求参数的RSA加密
     * @param url           请求地址
     * @param requestStr    请求信息
     * @return 返回请求结果字符串 string
     * @throws MypaysException the wx pay exception
     */
    String postJSON(String authorization, String sign, String url, String requestStr) throws MypaysException;
    /**
     * 聚合支付
     *
     * @return
     */
    MposService getMposService();
}
