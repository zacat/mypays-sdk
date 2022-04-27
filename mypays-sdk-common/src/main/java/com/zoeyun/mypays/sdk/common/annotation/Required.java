package com.zoeyun.mypays.sdk.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * 标识某个字段是否是必填的
 * Created by Binary Wang on 2016/9/25.
 * </pre>
 *
 * @author binarywang (https://github.com/binarywang)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Required {

}