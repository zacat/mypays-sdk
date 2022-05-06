package com.zoeyun.mypays.sdk.service.impl;

import com.zoeyun.mypays.sdk.exception.MypaysException;
import com.zoeyun.mypays.sdk.service.CardbindingService;
import com.zoeyun.mypays.sdk.service.MerchantService;
import com.zoeyun.mypays.sdk.service.MposService;
import com.zoeyun.mypays.sdk.service.PaymentService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MypaysServiceApacheHttpImpl extends BaseMypaysServiceImpl {


    private HttpClientBuilder createHttpClientBuilder() throws MypaysException {
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        return httpClientBuilder;
    }

    private StringEntity createEntry(String requestStr) {
        return new StringEntity(requestStr, ContentType.create("application/json", "utf-8"));
        //return new StringEntity(new String(requestStr.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
    }

    private HttpPost createHttpPost(String url, String requestStr) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(this.createEntry(requestStr));

        httpPost.setConfig(RequestConfig.custom()
                .setConnectionRequestTimeout(this.getConfigStorage().getHttpConnectionTimeout())
                .setConnectTimeout(this.getConfigStorage().getHttpConnectionTimeout())
                .setSocketTimeout(this.getConfigStorage().getHttpTimeout())
                .build());

        return httpPost;
    }

    /**
     * 发送post请求，得到响应字节数组.
     *
     * @param url        请求地址
     * @param requestStr 请求参数的RSA加密
     * @return 返回请求结果字节数组 byte [ ]
     * @throws MypaysException the wx pay exception
     */
    @Override
    public byte[] postForBytes(String url, String requestStr) throws MypaysException {
        try {
            HttpClientBuilder httpClientBuilder = createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPost(url, requestStr);
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    final byte[] bytes = EntityUtils.toByteArray(response.getEntity());
                    final String responseData = Base64.getEncoder().encodeToString(bytes);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据(Base64编码后)】：{}", url, requestStr, responseData);

                    return bytes;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            throw new MypaysException(e.getMessage(), e);
        }
    }

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
    @Override
    public byte[] postForBytes(String authorization, String sign, String url, String requestStr) throws MypaysException {
        try {
            HttpClientBuilder httpClientBuilder = createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPost(url, requestStr);
            httpPost.addHeader("authorization", authorization);
            if (StringUtils.isNotEmpty(sign)) {
                httpPost.addHeader("x-token-sign", sign);
            }
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    final byte[] bytes = EntityUtils.toByteArray(response.getEntity());
                    final String responseData = Base64.getEncoder().encodeToString(bytes);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据(Base64编码后)】：{}", url, requestStr, responseData);

                    return bytes;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            throw new MypaysException(e.getMessage(), e);
        }
    }

    /**
     * 发送post请求，得到响应字符串.
     *
     * @param url        请求地址
     * @param requestStr 请求信息
     * @return 返回请求结果字符串 string
     * @throws MypaysException the wx pay exception
     */
    @Override
    public String post(String url, String requestStr) throws MypaysException {
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPost(url, requestStr);
            httpPost.addHeader("Accept", "application/json");
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);

                    return responseString;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            throw new MypaysException(e.getMessage(), e);
        }
    }

    /**
     * 发送post请求，得到响应字符串.
     *
     * @param url        请求地址
     * @param requestStr 请求信息
     * @return 返回请求结果字符串 string
     * @throws MypaysException the wx pay exception
     */
    @Override
    public String postJSON(String url, String requestStr) throws MypaysException {
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPost(url, requestStr);
            httpPost.addHeader("Accept", "application/json");
            httpPost.addHeader("Content-Type", "application/json");
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);
                    return responseString;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            throw new MypaysException(e.getMessage(), e);
        }
    }

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
    @Override
    public String post(String authorization, String sign, String url, String requestStr) throws MypaysException {
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPost(url, requestStr);
            httpPost.addHeader("authorization", authorization);
            if (StringUtils.isNotEmpty(sign)) {
                httpPost.addHeader("x-token-sign", sign);
            }
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);

                    return responseString;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            throw new MypaysException(e.getMessage(), e);
        }
    }

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
    @Override
    public String postJSON(String authorization, String sign, String url, String requestStr) throws MypaysException {
        try {
            HttpClientBuilder httpClientBuilder = this.createHttpClientBuilder();
            HttpPost httpPost = this.createHttpPost(url, requestStr);
            httpPost.addHeader("Accept", "application/json");
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.addHeader("authorization", authorization);
            if (StringUtils.isNotEmpty(sign)) {
                httpPost.addHeader("x-token-sign", sign);
            }
            try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    this.log.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);

                    return responseString;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            this.log.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            throw new MypaysException(e.getMessage(), e);
        }
    }

    /**
     * 聚合支付
     *
     * @return
     */
    @Override
    public MposService getMposService() {
        return mposService;
    }

    @Override
    public MerchantService getMerchantService() {
        return merchantService;
    }

    @Override
    public CardbindingService getCardbindingService() {
        return cardbindingService;
    }

    @Override
    public PaymentService getPaymentService() {
        return paymentService;
    }

}
