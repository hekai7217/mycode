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
<%--*           1. 必须是post 提交--%>
<%--*           2. enctype  (多文件 multipart/form-data)--%>
<%--*           3. 表单域中要用 type = "file"--%>

<form action="/mvc04/img01.do" method="post" enctype="multipart/form-data">

    name:<input type="text" name="name"><br>
    头像:<input type="file" name="img"><br>
    <input type="submit"/>
</form>

<h3>图片下载</h3>
<img src="/mvc04/img/0.jpg" height="300px" width="300px"><br>
<a href="/mvc04/img03.do"> 图片下载 </a>

</body>
</html>
