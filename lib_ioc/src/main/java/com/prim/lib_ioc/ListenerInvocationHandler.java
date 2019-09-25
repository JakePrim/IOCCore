package com.prim.lib_ioc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author prim
 * @version 1.0.0
 * @desc 动态代理
 * @time 2019-09-25 - 11:34
 * @contact https://jakeprim.cn
 * @name IOCCore
 */
public class ListenerInvocationHandler implements InvocationHandler {
    //onClickListener
    //MainActivity

    private Object activity;

    private Method activitymethod;

    private String callbackMethod;

    public ListenerInvocationHandler(Object activity, Method method, String callbackMethod) {
        this.activity = activity;
        this.activitymethod = method;
        this.callbackMethod = callbackMethod;
    }

    /**
     * 点击调用如下方法
     *
     * @param o
     * @param method
     * @param objects
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if (method.getName().equals(callbackMethod)) {
            return activitymethod.invoke(activity, objects);
        }
        return null;
    }
}
