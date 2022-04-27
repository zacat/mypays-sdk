package com.zoeyun.mypays.sdk.bean;


import com.alibaba.fastjson.JSONObject;
import com.zoeyun.mypays.sdk.common.bean.MypaysResult;
import com.zoeyun.mypays.sdk.common.exception.MypaysRuntimeException;
import lombok.Data;

@Data
public abstract class BaseMypaysResult extends MypaysResult {
    int status;
    String message;
    String responseContent;


    public static <T extends BaseMypaysResult> T fromJSON(String responseContent, Class<T> clz) {

        try {
            BaseMypaysResult t = clz.newInstance();
            JSONObject respObj = JSONObject.parseObject(responseContent);
            int status = respObj.getInteger("status");
            String message = respObj.getString("message");
            if (status == 200 && respObj.containsKey("data")) {
                JSONObject respDataObj = respObj.getJSONObject("data");
                t = respDataObj.toJavaObject(clz);
            }
            t.setStatus(status);
            t.setMessage(message);
            t.responseContent = responseContent;
            return (T) t;
        } catch (Exception e) {
            throw new MypaysRuntimeException("parse xml error", e);
        }
    }


}
