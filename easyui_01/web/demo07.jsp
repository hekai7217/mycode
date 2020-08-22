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

<script>

    $(function () {

        $("#btn_add").click(function(){
            // $.messager.alert("提示","我是提示框","question");

            $.messager.confirm("警告","你付款吗?",function (r) {

                if(r){
                    alert("我买单...");
                }
            });

        });
    });

</script>
<%--linkbutton组件效果--%>
<a id="btn_add" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">测试linkbutton按钮</a>
<a id="btn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">测试linkbutton按钮</a>
<a id="btn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-help'">测试linkbutton按钮</a>

</body>
</html>
