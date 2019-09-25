package com.prim.lib_ioc;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2019-09-25 - 11:01
 * @contact https://jakeprim.cn
 * @name IOCCore
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@EventBase(listenerSetter = "setOnClickListener",
        listenerType = View.OnClickListener.class,
        callbackMethod = "onClick")
public @interface OnClick {
    int[] value() default -1;
}
