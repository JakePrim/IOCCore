package com.prim.lib_ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author prim
 * @version 1.0.0
 * @desc 注解的多态对注解的扩展,事件注解
 * @time 2019-09-25 - 11:03
 * @contact https://jakeprim.cn
 * @name IOCCore
 */
@Retention(RetentionPolicy.RUNTIME)
//该注解在另外一个注解上使用
@Target(ElementType.ANNOTATION_TYPE)
public @interface EventBase {

    //setOnClickListener 订阅者
    String listenerSetter();

    //事件源 类型 OnClickListener
    Class<?> listenerType();

    //事件 回调方法
    String callbackMethod();

}
