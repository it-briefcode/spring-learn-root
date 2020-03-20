package com.mvc.controller;

import com.mvc.entity.Dept;
import com.mvc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@Controller  //声明Bean对象，为一个控制器组件
public class HelloWorldController {

    @Autowired
    private DeptService deptService;
    /**
     * 映射请求的名称：用于客户端请求；类似Struts2中action映射配置的action名称
     * 1. 使用 @RequestMapping 注解来映射请求的 URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于 InternalResourceViewResolver 视图解析器,
     * 会做如下的解析:
     *          通过 prefix + returnVal + suffix 这样的方式得到实际的物理视图, 然后做转发操作.
     *          /WEB-INF/views/success.jsp
     */
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String helloworld() {
        System.out.println("hello,world");
        Dept dept = deptService.queryById(10);
        System.out.println(dept);
        //结果如何跳转呢？需要配置映射解析器
        return "success";
    }

    //@PathVariabl
    // e 注解可以将请求URL路径中的请求参数，传递到处理请求方法的入参中
    @RequestMapping(value = "/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable...id=" + id);
        return "success";
    }

    /**
     * 1.测试REST风格的  GET,POST,PUT,DELETE 操作
     * 以CRUD为例：
     * 新增: /order POST
     * 修改: /order/1 PUT           update?id=1
     * 获取: /order/1 GET                get?id=1
     * 删除: /order/1 DELETE        delete?id=1
     *  
     * 2.如何发送PUT请求或DELETE请求?
     * ①.配置HiddenHttpMethodFilter
     * ②.需要发送POST请求
     * ③.需要在发送POST请求时携带一个 name="_method"的隐含域，值为PUT或DELETE
     *  
     * 3.在SpringMVC的目标方法中如何得到id值呢?
     * 使用@PathVariable注解
     */
    @RequestMapping(value = "/testRESTGet/{id}", method = RequestMethod.GET)
    public String testRESTGet(@PathVariable(value = "id") Integer id) {
        System.out.println("testRESTGet id=" + id);
        return "success";
    }

    @RequestMapping(value = "/testRESTPost", method = RequestMethod.POST)
    public String testRESTPost() {
        System.out.println("testRESTPost");
        return "success";
    }

    @RequestMapping(value = "/testRESTPut/{id}", method = RequestMethod.PUT)
    public String testRESTPut(@PathVariable("id") Integer id) {
        System.out.println("testRESTPut id=" + id);
        return "success";
    }

    @RequestMapping(value = "/testRESTDelete/{id}", method = RequestMethod.DELETE)
    public String testRESTDelete(@PathVariable("id") Integer id) {
        System.out.println("testRESTDelete id=" + id);
        return "success";
    }


    /**
     * @RequestParam 注解用于映射请求参数
     *         value 用于映射请求参数名称
     *         required 用于设置请求参数是否必须的
     *         defaultValue 设置默认值，当没有传递参数时使用该值
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam - username=" + username + ",age=" + age);
        return "success";
    }

    //了解: 映射请求头信息 用法同 @RequestParam
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al) {
        System.out.println("testRequestHeader - Accept-Language：" + al);
        return "success";
    }

    //了解:@CookieValue: 映射一个 Cookie 值. 属性同 @RequestParam
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("testCookieValue: sessionId: " + sessionId);
        return "success";
    }

    /**
     * Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配， 自动为该对象填充属性值。
     * 支持级联属性
     *                 如：dept.deptId、dept.address.tel 等
     */
    @RequestMapping("/testPOJO")
    public String testPojo(User user) {
        System.out.println("testPojo: " + user);
        return "success";
    }


    /**
     * 可以使用 Serlvet 原生的 API 作为目标方法的参数 具体支持以下类型
     * <p>
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     * java.security.Principal
     * Locale InputStream
     * OutputStream
     * Reader
     * Writer
     *
     * @throws IOException
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
        System.out.println("testServletAPI, " + request + ", " + response);
        out.write("hello springmvc");
//return "success";
    }

    /**
     * 目标方法的返回类型可以是ModelAndView类型
     *                 其中包含视图信息和模型数据信息
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView");
        String viewName = "success";
        ModelAndView mv = new ModelAndView(viewName);
        mv.addObject("time", new Date().toString()); //实质上存放到request域中
        return mv;
    }

    //目标方法的返回类型也可以是一个Map类型参数（也可以是Model,或ModelMap类型）
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) { //【重点】
        System.out.println(map.getClass().getName());
//org.springframework.validation.support.BindingAwareModelMap
        map.put("names", Arrays.asList("Tom", "Jerry", "Kite"));
        return "success";
    }


    //目标方法的返回类型也可以是一个Map类型参数（也可以是Model,或ModelMap类型）
    @RequestMapping("/testMap2")
    public String testMap2(Map<String, Object> map, Model model, ModelMap modelMap) {
        System.out.println(map.getClass().getName());
        map.put("names", Arrays.asList("Tom", "Jerry", "Kite"));
        model.addAttribute("model", "org.springframework.ui.Model");
        modelMap.put("modelMap", "org.springframework.ui.ModelMap");

        System.out.println(map == model);
        System.out.println(map == modelMap);
        System.out.println(model == modelMap);

        System.out.println(map.getClass().getName());
        System.out.println(model.getClass().getName());
        System.out.println(modelMap.getClass().getName());

        /*
        true
        true
        true
        org.springframework.validation.support.BindingAwareModelMap
        org.springframework.validation.support.BindingAwareModelMap
        org.springframework.validation.support.BindingAwareModelMap
            */
        return "success";
    }


    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
        //return "forward:/index.jsp";
    }

}