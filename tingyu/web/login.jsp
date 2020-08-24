<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <%--    设置相对路径 --%>
    <base href="<%=basePath%>"/>

    <%--引入easyUI的资源--%>
    <link rel="stylesheet" type="text/css" href="static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/themes/icon.css">
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/jquery.easyui.min.js"></script>

</head>
<body>

<script>

    $(function () {

        // 给点击事件
        $("#btnLogin").click(function(){

            // 拿到表单提交数据
            $("#loginFrom").submit(); // 提交数据

        });
    })

</script>


<div style="margin: auto;margin-top: 120px;height: 240px;width: 500px">

    <%--展示错误的提示信息--%>
    <c:if test="${not empty msg}">
        <font size="4" color="red">${msg}</font>
    </c:if>

    <%-- 把session中的 msg属性移除掉--%>
    <c:remove var="msg" scope="session"></c:remove>
    <%--div中放一个面板--%>
    <div id="p" class="easyui-panel" title="ting域后台管理系统"
         style="width:500px;height:270px;padding:10px;background:#fafafa;"
         data-options="iconCls:'icon-save',closable:false,
    collapsible:false,minimizable:false,maximizable:false">

        <form id="loginFrom" action="/ting/admin/login.do" method="post">
            <div style="text-align: center;margin-top: 20px">
                <label for="aname">用户名:</label>
                <input class="easyui-textbox" type="text" name="aname"/>
            </div>
            <div style="text-align: center;margin-top: 20px">
                <label for="apwd">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
                <input class="easyui-passwordbox" type="text" name="apwd"/>
            </div>

            <div style="text-align: center;margin-top: 20px">
                <a id="btnLogin" href="javascript:void(0)" class="easyui-linkbutton" style="margin-right: 20px" data-options="iconCls:'icon-ok'">登陆</a>

                <input class="easyui-checkbox" data-options="labelPosition:'after'" name="fruit" label="记住密码" style="margin-left: 20px">

            </div>

        </form>

    </div>


</div>

</body>
</html>
