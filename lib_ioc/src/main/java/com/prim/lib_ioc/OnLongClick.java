package com.prim.lib_ioc;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author prim
 * @version 1.0.0
 * @desc 长按事件
 * @time 2019-09-25 - 11:01
 * @contact https://jakeprim.cn
 * @name IOCCore
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@EventBase(listenerSetter = "setOnLongClickListener",
        listenerType = View.OnLongClickListener.class,
        callbackMethod = "onLongClick")
public @interface OnLongClick {
    int[] value() default -1;
}
