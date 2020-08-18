<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0018
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数的绑定</title>
</head>
<body>

<!--  原始方式request.getParameter() -->
<fieldset>
    <legend> 原始方式request.getParameter()</legend>
    <form action="${pageContext.request.contextPath}/data01.do" method="get">
        账号: <input name="username"><br>
        年龄: <input name="age"><br>
        <button type="submit">提交</button>
    </form>
</fieldset>

<fieldset>
    <legend>方法形参与前台参数同名</legend>
    <form action="${pageContext.request.contextPath}/data02.do" method="post">
        账号: <input name="username"><br>
        年龄: <input name="age"><br>
        <button type="submit">提交</button>
    </form>
</fieldset>

<fieldset>
    <legend>方法形参与前台参数同名</legend>
    <form action="${pageContext.request.contextPath}/data03.do" method="post">
        账号: <input name="username"><br>
        年龄: <input name="age"><br>
        <button type="submit">提交</button>
    </form>
</fieldset>

<fieldset>
    <legend>接收数组或集合</legend>
    <form action="${pageContext.request.contextPath}/data04.do" method="post">
        账号: <input name="name"><br>
        年龄: <input name="age"><br>
        爱好: <input type="checkbox" name="hobbys" value="java">java
        <input type="checkbox" name="hobbys" value="html">html<br>
        <button type="submit">提交</button>
    </form>
</fieldset>

<fieldset>
    <legend>接受对象，表单参数名必须和后台pojo对象对应的属性名相同</legend>
    <form action="${pageContext.request.contextPath}/data05.do" method="get">
        账号: <input name="username"><br>
        密码: <input type="password" name="password"><br>
        邮箱: <input name="email"><br>
        电话: <input name="phone"><br>
        <button type="submit">提交</button>
    </form>
</fieldset>

多个值的数据
<fieldset>
    <legend>接受参数封装成Map集合</legend>
    <form action="${pageContext.request.contextPath}/data06.do" method="get">
        账号: <input name="username"><br>
        密码: <input name="password"><br>
        邮箱: <input name="email"><br>
        电话: <input name="phone"><br>
        爱好: <input type="checkbox" name="hobbys" value="java">java
        <input type="checkbox" name="hobbys" value="html">html<br>
        <button type="submit">提交</button>
    </form>
</fieldset>

</body>
</html>
