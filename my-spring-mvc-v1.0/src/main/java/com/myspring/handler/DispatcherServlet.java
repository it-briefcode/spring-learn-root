package com.myspring.handler;

import com.myspring.annotation.Autowired;
import com.myspring.annotation.Controller;
import com.myspring.annotation.RequestMapping;
import com.myspring.annotation.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class DispatcherServlet extends HttpServlet {

    private static Properties properties = new Properties();
    private static List<String> classNameList = new ArrayList<>();
    //ioc容器 存放bean
    private static Map<String,Object> ioc = new HashMap();

    private static Map<String,Method> hanlerMapping = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        //2.扫描类初始化
        doScanner(properties.getProperty("basePakage"));
        //3.初始化实例，注册单列， 初始化ioc容器
        doIntance();
        //4.依赖ID构造，
        doAutowired();
        //5.构建映射关系，HandlerMapping
        initHandlerMapping();
        System.out.println("MySpring init success...");
    }

    private void initHandlerMapping() {
        //从容器中获取controller注解的类
        ioc.values()
                .stream()
                .filter(item ->
                        item.getClass()
                        .isAnnotationPresent(Controller.class))
                .forEach(obj ->{
                    //标有controller注解的类
                    String baseurl = "/";
                    if (obj.getClass().isAnnotationPresent(RequestMapping.class)){
                        //获取url的前缀
                        baseurl = obj.getClass().getAnnotation(RequestMapping.class).value();
                    }
                    for (Method method : obj.getClass().getMethods()) {
                        //遍历所有的共有方法
                        if (!method.isAnnotationPresent(RequestMapping.class)) continue;
                        //标注有request Mapping的方法
                        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                        String url= (baseurl+"/"+ requestMapping.value()).replaceAll("/+","/");
                        hanlerMapping.put(url,method);
                        System.out.println("HandlerMapping:[url:"+url+",method:"+method.getName()+"]");
                    }
                });
    }

    /**
     * 动态初始化类中的参数
     */
    private void doAutowired() {

        //遍历ioc容器中的类
        for (Object value : ioc.values()) {
            //获取里面所有的成员变量
            Field[] fields = value.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(Autowired.class)) continue;
                //被Annotation注解的进行解析
                //通过变量名字来取
                Object obj = ioc.get(field.getName());
                //通过自定义名字
                Autowired annotation = field.getAnnotation(Autowired.class);
                if (null == obj && !"".equals(annotation.value())){
                    obj = ioc.get(annotation.value());
                }
                //如果上面获取不到，则通过类型来获取
                if (null == obj){
                    Class<?> type = field.getType();
                    obj = ioc.get(toLowerCase(type.getName()));
                }
                field.setAccessible(true);
                try {
                    field.set(value,obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    System.out.println("属性："+field.getName()+" 注入失败...");
                    continue;
                }

            }
        }

    }

    /**
     * 初始化实列，注册时单例
     */
    private void doIntance() {
        for (String clazzName : classNameList) {
            try {
                Class<?> clazz = Class.forName(clazzName);
                if (clazz.isAnnotationPresent(Controller.class)
                ||clazz.isAnnotationPresent(Service.class)){
                    //初始化bean，存到ioc中
                    Object instance = clazz.newInstance();
                    //1.首字母转小写
                    String beanName = toLowerCase(clazz.getSimpleName());
                    //2.手动自定义的名字
                    Service annotation = clazz.getAnnotation(Service.class);
                    if (null != annotation &&!"".equals(annotation.value().trim())){
                        beanName = annotation.value();
                    }

                    if (ioc.containsKey(beanName)){
                        System.out.println("Bean 已经存在，无能重复添加...");
                        continue;
                    }
                    ioc.put(beanName,instance);

                    //3.类型名字 接口
                    for (Class intface : clazz.getInterfaces()){
                        if (ioc.containsKey(intface.getSimpleName())){
                            System.out.println("Bean 已经存在，无能重复添加...");
                            continue;
                        }
                        ioc.put(toLowerCase(intface.getSimpleName()),instance);
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                System.out.println("Bean 初始化失败...");
            }
        }


    }

    /**
     * AscII进行转换 相差32
     * @param name
     * @return
     */
    private String toLowerCase(String name) {
        char[] chars = name.toCharArray();
        chars[0] += 32;

        return String.valueOf(chars);
    }

    /**
     * 扫描类
     * @param basePakage
     */
    private void doScanner(String basePakage) {
        // 拿到路径com.myspring
        URL url = this.getClass().getClassLoader().getResource("/" + basePakage.replaceAll("\\.", "/"));
        //url是全路径
        File fileDir = new File(url.getFile());
        //遍历该目录
        for (File file : fileDir.listFiles()){
            if (file.isDirectory()){
                doScanner(basePakage+"."+file.getName());
            }
            //如果不是class文件则不解析
            if (!file.getName().endsWith(".class")){
                continue;
            }
            //如果是字节码文件，则将完整路径存入集合待解析
             classNameList.add(basePakage+"."+file.getName().replace(".class",""));
        }


    }

    /**
     * 加载配置文件
     * @param contextConfigLocation
     */
    private void doLoadConfig(String contextConfigLocation) {
        try {
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(" MySpring init fail...");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            doDispatcher(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //请求进入
   /*     String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        System.out.println(contextPath);
        System.out.println(servletPath);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);*/
        String path = req.getServletPath();
        if (!hanlerMapping.containsKey(path)) {
            resp.getWriter().write("404 NOT FOUND！");
            return;
        }
        Method method = hanlerMapping.get(path);
        String simpleName = method.getDeclaringClass().getSimpleName();
        Object intance = ioc.get(toLowerCase(simpleName));
        method.invoke(intance);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req,resp);
    }
}
