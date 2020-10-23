package org.myspring.annotation;

import java.util.Objects;

public interface ApplicationContext {



    public Object getBean(String name);

    <T> T getBean(Class<T> classType);



}
