<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0019
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<script src="/ssm/js/jquery-1.12.3.min.js"></script>

<%--    WEB-INF 下面的资源不能直接访问
        通过controller进行转发访问
 --%>
<a href="/ssm/toAddStu.do">添加学生</a>

<table border="1px" cellspacing="0px">

    <tr>
        <td> id </td>
        <td> name </td>
        <td> age </td>
        <td> 操作 </td>
    </tr>

    <c:forEach var="s" items="${stus}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
            <td>
                <a href="javascript:void(0)" onclick="delStu(${s.id},this)">删除操作</a>
            </td>
        </tr>
    </c:forEach>

</table>

<script>
    /**
     *  通过ajax删除 这一条数据
     *
     *    点击 按钮 发送ajax 服务器删除数据
     *    返回json 判断json dom操作 移除数据
     *
     * @param id
     * @param obj
     */
    function delStu(id,obj){
        var f = confirm("你确定删除吗");
        if(f){
            alert(id);
            //发送ajax
            $.post("/ssm/delstu.do",{
                id:id
            },function (data) {

                if(data.success){
                    // 删除成功
                    // a标签拿到 父标签 tr 拿到父标签 td 删除
                    alert(data.msg)
                    $(obj).parent().parent().remove();
                }else{
                    alert(data.msg)
                }
            },"json");

        }
    }
</script>


</body>
</html>
