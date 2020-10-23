package org.ioc.bean;

import java.util.List;

/**
 * @ClassName: Theacher
 * @Author: zhoucx
 * @Date: 2020/3/7 10:50
 **/
public class Theacher {



    private String id;

    private String name;

    private String subject;

    private Integer age;

    private List<String> classNames;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getClassNames() {
        return classNames;
    }

    public void setClassNames(List<String> classNames) {
        this.classNames = classNames;
    }

    @Override
    public String toString() {
        return "Theacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", age=" + age +
                ", classNames=" + classNames +
                '}';
    }
}
