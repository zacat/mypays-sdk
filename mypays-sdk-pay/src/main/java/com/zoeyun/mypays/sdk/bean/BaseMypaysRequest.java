package com.zoeyun.mypays.sdk.bean;

import com.alibaba.fastjson.JSON;
import com.zoeyun.mypays.sdk.common.bean.MypaysRequest;
import com.zoeyun.mypays.sdk.common.exception.MypaysErrorException;
import com.zoeyun.mypays.sdk.common.utils.BeanUtils;
import com.zoeyun.mypays.sdk.common.utils.RsaUtils;
import com.zoeyun.mypays.sdk.config.MypaysConfigStorage;
import com.zoeyun.mypays.sdk.exception.MypaysException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

@Data
public abstract class BaseMypaysRequest extends MypaysRequest {

    String clientId;
    String sign;


    /**
     * 签名时，忽略的参数.
     *
     * @return the string [ ]
     */
    protected String[] getIgnoredParamsForSign() {
        return new String[0];
    }


    /**
     * 检查请求参数内容，包括必填参数以及特殊约束.
     */
    private void checkFields() throws MypaysException {
        //check required fields
        try {
            BeanUtils.checkRequiredFields(this);
        } catch (MypaysErrorException e) {
            throw new MypaysException(e.getMessage(), e);
        }

        //check other parameters
        this.checkConstraints();
    }

    protected abstract void checkConstraints() throws MypaysException;


    /**
     * 获取签名时需要的参数.
     * 注意：不含sign属性
     */
    public Map<String, String> getSignParams() {
        Map<String, String> map = new HashMap<>(8);
        storeMap(map);
        return map;
    }

    /**
     * 将属性组装到一个Map中，供签名和最终发送XML时使用.
     * 这里需要将所有的属性全部保存进来，签名的时候会自动调用getIgnoredParamsForSign进行忽略，
     * 不用担心。否则最终生成的XML会缺失。
     *
     * @param map 传入的属性Map
     */
    protected abstract void storeMap(Map<String, String> map);


    /**
     * <pre>
     * 检查参数，并设置签名.
     * 1、检查参数（注意：子类实现需要检查参数的而外功能时，请在调用父类的方法前进行相应判断）
     * 2、补充系统参数，如果未传入则从配置里读取
     * 3、生成签名，并设置进去
     * </pre>
     *
     * @param configStorage 支付配置对象，用于读取相应系统配置信息
     * @throws MypaysException the wx pay exception
     */
    public void checkAndSign(MypaysConfigStorage configStorage) throws MypaysException {
        this.checkFields();
        if (StringUtils.isBlank(clientId)) {
            this.clientId = configStorage.getClientId();
        }

        String content = toString();
        PrivateKey privateKey = RsaUtils.getPrivateKeyFromPKCS8(RsaUtils.SIGN_TYPE_RSA2, configStorage.getRsaPriKey().getBytes());
        sign = RsaUtils.rsa256Sign(content.getBytes(), privateKey);
    }

    public String toString() {
        return JSON.toJSONString(getSignParams());
    }

}
