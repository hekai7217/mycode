<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath %>"/>

    <%--引入easyUI的资源--%>
    <link rel="stylesheet" type="text/css" href="static/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/themes/icon.css">
<%--     一定要先 引入jquery --%>
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/jquery.easyui.min.js"></script>


</head>
<body>

<%--
   引入 easyui:
     1. 导入 easyui主题  themes 文件
     2  导入 js   easyui/ jquery

     3. 页面引入 easy的样式


 --%>

<script>

    $(function () {
        $("#name").textbox({
            height:35,
            width:350,
            prompt:'输入用户名', // 文本框提示信息
            label:'用户名:',
            labelWidth:60,
            labelPosition:'before',
            onChange:function (newValue,oldValue) { // 内容发生了变化的 事件触发
                console.log(newValue + ":"+ oldValue);
            }
        })
    });

</script>
<input id="name" class="easyui-textbox" data-options="">
<br>
<input class="easyui-passwordbox" prompt="请输入密码"
       data-options="label:'密&nbsp;&nbsp;&nbsp;&nbsp;码:',labelPosition:'before',labelWidth:60,width:350,height:35,">

</body>
</html>
