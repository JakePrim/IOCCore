package com.prim.lib_ioc;

import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2019-09-20 - 16:33
 * @contact https://jakeprim.cn
 * @name IOCCore
 */
public class InjectUtils {

    private static final LinkedHashMap<Integer, View> viewMaps = new LinkedHashMap<>();

    /**
     * 注入对象 初始化
     *
     * @param context
     */
    public static void inject(Object context) {
        viewMaps.clear();
        injectLayout(context);
        injectView(context);
        injectClick(context);
    }

    /**
     * 注入事件
     *
     * @param context
     */
    private static void injectClick(Object context) {
        Class<?> aClass = context.getClass();
        Method[] methods = aClass.getDeclaredMethods();//获取方法
        for (Method method : methods) {
            //获取方法上的注解 由于是多种注解不能够写死
            //可以找到EventBase 因为所有的事件都有EventBase
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                EventBase eventBase = annotationType.getAnnotation(EventBase.class);
                //判断注解的类型
                if (eventBase == null) {
                    continue;
                }
                //获取事件三要素
                String listenerSetter = eventBase.listenerSetter();
                Class<?> listenerType = eventBase.listenerType();
                String callbackMethod = eventBase.callbackMethod();
                //注入事件 根据view id 获取到view 但是现在不能够写死一个注解 因为有多种事件注解类型 如果拿到呢？
                Method valueMethod;
                try {
                    valueMethod = annotationType.getDeclaredMethod("value");
                    int[] viewIds = (int[]) valueMethod.invoke(annotation);
                    if (viewIds != null) {
                        for (int viewId : viewIds) {
                            View view;
                            if (viewMaps.containsKey(viewId)) {
                                view = viewMaps.get(viewId);
                            } else {
                                //获取到view
                                Method findViewByIdMethod = aClass.getMethod("findViewById", int.class);
                                view = (View) findViewByIdMethod.invoke(context, viewId);
                                viewMaps.put(viewId, view);//存储view
                            }
                            if (view == null)
                                continue;
                            //注入view事件
                            //获取事件的方法
                            Method listenerMethod = view.getClass().getMethod(listenerSetter, listenerType);

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 注入findViewById 获取类的所有属性 然后得到相应的注解
     *
     * @param context
     */
    private static void injectView(Object context) {
        //获取成员变量的所有注解
        Class<?> aClass = context.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            ViewInject viewInject = field.getAnnotation(ViewInject.class);
            if (viewInject != null) {
                int valueId = viewInject.value();
                try {
                    boolean containsKey = viewMaps.containsKey(valueId);
                    if (containsKey)
                        viewMaps.remove(valueId);
                    Method method = aClass.getMethod("findViewById", int.class);
                    View view = (View) method.invoke(context, valueId);
                    field.setAccessible(true);
                    field.set(context, view);
                    //可以将view存储到本地仓库，然后事件就可以不用在进行反射了
                    viewMaps.put(valueId, view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 注入setContentView
     *
     * @param context
     */
    private static void injectLayout(Object context) {
        int layoutId = 0;
        Class<?> aClass = context.getClass();
        //获取类上的注解
        ContentView contentView = aClass.getAnnotation(ContentView.class);
        if (contentView != null) {
            layoutId = contentView.value();
            try {
                Method setContentView = context.getClass().getMethod("setContentView", int.class);
                setContentView.setAccessible(true);
                setContentView.invoke(context, layoutId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
