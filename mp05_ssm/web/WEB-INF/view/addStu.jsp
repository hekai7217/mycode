<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0019
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>添加学生</h3>

<form action="/mp05/student/addStu.do" method="post">
    name:<input type="text" name="sName"><br>
    age:<input type="text" name="sage"><br>
    <input type="submit" value="添加"><br>
</form>

</body>
</html>
