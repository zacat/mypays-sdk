package com.zoeyun.mypays.sdk.bean;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.zoeyun.mypays.sdk.common.bean.MypaysResult;
import com.zoeyun.mypays.sdk.common.exception.MypaysRuntimeException;
import lombok.Data;

import java.util.List;

@Data
public abstract class BaseMypaysResult extends MypaysResult {
    int status;
    String message;

    @JSONField(serialize = false, deserialize = false)
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
            throw new MypaysRuntimeException("parse json error", e);
        }
    }


}
