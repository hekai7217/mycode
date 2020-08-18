<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0018
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/action02.do" method="post">
    <input type="submit" value="登录">
</form>

<br>
<form action="${pageContext.request.contextPath}/action03.do" method="post">
    账号：<input name="username"><br>
    密码：<input type="password" name="password"><br>
    <button type="submit">登录</button>
</form>

</body>
</html>
