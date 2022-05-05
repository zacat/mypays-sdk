package com.zoeyun.mypays.sdk.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.zoeyun.mypays.sdk.common.bean.BaseMypays;
import com.zoeyun.mypays.sdk.common.bean.MypaysResult;
import com.zoeyun.mypays.sdk.common.exception.MypaysRuntimeException;
import com.zoeyun.mypays.sdk.common.utils.ReflectUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseMypaysListResult<V extends BaseMypays> extends MypaysResult {

    int status;
    String message;
    String responseContent;

    List<V> list;

    public static <T extends BaseMypaysListResult> T fromJSON(String responseContent, Class<T> clz) {
        try {
            BaseMypaysListResult t = clz.newInstance();
            JSONObject respObj = JSONObject.parseObject(responseContent);
            int status = respObj.getInteger("status");
            String message = respObj.getString("message");
            if (status == 200 && respObj.containsKey("data")) {
                JSONArray respDataArray = respObj.getJSONArray("data");
                if (respDataArray.size() > 0) {
                    t.setList(Lists.newArrayList());
                    Class<?> clazz = ReflectUtils.getClassGenricType(clz);
                    for (int i = 0; i <= respDataArray.size() - 1; i++) {
                        JSONObject respDataObj = respDataArray.getJSONObject(i);
                        t.getList().add(respDataObj.toJavaObject(clazz));
                    }
                }
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
