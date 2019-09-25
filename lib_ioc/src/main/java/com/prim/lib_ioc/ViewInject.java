package com.prim.lib_ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2019-09-20 - 16:49
 * @contact https://jakeprim.cn
 * @name IOCCore
 */
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Target(ElementType.FIELD)//运行在属性上
public @interface ViewInject {
    int value();
}
