<html>
<body>
<h2>Hello World!</h2>

<a href="${pageContext.request.contextPath }/helloworld">Hello World</a>

<form action="${pageContext.request.contextPath }/helloworld" method="post">
    <input type="submit" value="submit">
</form>

<br/>
<!-- 测试 @PathVariable -->
<a href="/testPathVariable/1">testPathVariable</a>
</body>

<!-- 实验1 测试 REST风格 GET 请求 -->
<a href="springmvc/testRESTGet/1">testREST GET</a><br/><br/>
 
<!-- 实验2 测试 REST风格 POST 请求 -->
<form action="springmvc/testRESTPost" method="POST">
    <input type="submit" value="testRESTPost">
</form>
 
<!-- 实验3 测试 REST风格 PUT 请求 -->
<form action="springmvc/testRESTPut/1" method="POST">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="testRESTPut">
</form>
 
<!-- 实验4 测试 REST风格 DELETE 请求 -->
<form action="springmvc/testRESTDelete/1" method="POST">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="testRESTDelete">
</form>


<!--测试 请求参数 @RequestParam 注解使用 -->
<a href="springmvc/testRequestParam?username=atguigu&age=10">testRequestParam</a>

<!--测试 请求Cookie @CookieValue 注解使用 -->
<a href="springmvc/testCookieValue">testCookieValue</a>
<!-- 测试 请求头@RequestHeader 注解使用 -->
<a href="springmvc/testRequestHeader">testRequestHeader</a>
<!-- 测试 POJO 对象传参，支持级联属性 -->
<form action=" testPOJO" method="POST">
    username: <input type="text" name="username"/><br>
    password: <input type="password" name="password"/><br>
    email: <input type="text" name="email"/><br>
    age: <input type="text" name="age"/><br>
    city: <input type="text" name="address.city"/><br>
    province: <input type="text" name="address.province"/>
    <input type="submit" value="Submit"/>
</form>

<!-- 测试 Servlet API 作为处理请求参数 -->
<a href="springmvc/testServletAPI">testServletAPI</a>
<!--测试 ModelAndView 作为处理返回结果 -->
<a href="springmvc/testModelAndView">testModelAndView</a>
<a href="springmvc/testRedirect">testRedirect</a>

</html>
