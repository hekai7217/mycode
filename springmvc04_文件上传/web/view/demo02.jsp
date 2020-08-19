<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0019
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>
</head>
<body>

<%--2. 页面的文件提交--%>


<form action="/mvc04/img02.do" method="post" enctype="multipart/form-data">

    name:<input type="text" name="name"><br>
    头像1:<input type="file" name="imgs"><br>
    头像2:<input type="file" name="imgs"><br>
    头像3:<input type="file" name="imgs"><br>
    <input type="submit"/>
</form>

</body>
</html>
