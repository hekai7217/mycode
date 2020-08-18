<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0018
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>自定义日期的绑定</legend>
<%--
    date 提交到 服务器的是?
--%>
    <form action="${pageContext.request.contextPath}/date01.do" method="get">
        生日: <input  type="date" name="birth"><br>
        <button type="submit">提交</button>
    </form>
</fieldset>

<fieldset>
    <legend>自定义日期的绑定</legend>
    <%--
        date 提交到 服务器的是?
    --%>
    <form action="${pageContext.request.contextPath}/date02.do" method="get">
        生日: <input  type="date" name="birth"><br>
        <button type="submit">提交</button>
    </form>
</fieldset>

<fieldset>
    <legend>测试乱码 </legend>

<%--
   表单的get请求?
     不会乱码

   表单的post乱码?
     会乱码
     SpringMVC默认接受的参数是ISO-8859-1编码参数
     解决?
     spring提了过滤器来解决
     配置过滤器

--%>
    <form action="${pageContext.request.contextPath}/code.do" method="post">

        姓名: <input  type="text" name="name"><br>
        描述: <input  type="text" name="info"><br>

        <button type="submit">提交</button>
    </form>
</fieldset>


</body>
</html>
