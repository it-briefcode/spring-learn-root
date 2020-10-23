package org.myspring.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @ClassName: BeanFactory
 * @Author: zhoucx
 * @Date: 2020/3/7 17:45
 **/
public class BeanFactory {


    private static List<BeanDefinition> definitionList = new ArrayList<>();


    public Object getBean(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Optional<BeanDefinition> first = definitionList.stream().filter(item -> name.equals(item.getId())).findFirst();
        BeanDefinition definition = first.orElse(null);
        if (Objects.nonNull(definition)){
            Class<?> aClass = Class.forName(definition.getClassName());
            return aClass.newInstance();
        }
        return null;
    }


    public static void setDefinitionList(List<BeanDefinition> definitionList) {
        BeanFactory.definitionList.addAll(definitionList) ;
    }

    public static void addDefinition(BeanDefinition beanDefinition){
        BeanFactory.definitionList.add(beanDefinition);
    }
}
