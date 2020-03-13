package org.myspring.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class AnnotationConfigApplicationContext implements ApplicationContext {

    private static Map<Class,Object> beanMap = new HashMap<>();

    public AnnotationConfigApplicationContext(Class clazz) throws Exception {
        //初始化
        Annotation annotation = clazz.getAnnotation(Configuration.class);
        if (annotation == null){
            throw new Exception("传入的类不是配置类，请重新配置");
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {

            Bean annotation1 = method.getAnnotation(Bean.class);
            if (annotation1 != null){
                Class<?> returnType = method.getReturnType();
                Object invoke = method.invoke(clazz.newInstance());
                beanMap.put(returnType,invoke);
            }

        }


    }


    @Override
    public Object getBean(String name) {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> classType) {
        Object o = beanMap.get(classType);
        return (T) o;
    }
}
