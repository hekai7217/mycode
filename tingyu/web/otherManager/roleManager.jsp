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
    <link rel="stylesheet" type="text/css" href="static/themes/color.css">
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/jquery.easyui.min.js"></script>
</head>
<body>

<script>
    $(function () {

        $("#roleDatagrid").datagrid({
            url: "role/roleInfo.do",
            pagination: true, // 分页工具栏
            pageNumber: 1,
            rownumbers: true, // datagrid 展示数据有行号
            pageSize: 3,
            pageList: [3, 6],
            columns: [[
                {field: 'rid', title: '角色编号', width: 100},
                {field: 'rname', title: '角色名称', width: 100},
                {field: 'rdesc', title: '角色描述', width: 100}
            ]]
        })

    });
</script>

<div id="p" class="easyui-panel"
     style="width:500px;height:150px;padding:10px;background:#fafafa;"
     data-options="fit:true,iconCls:'icon-save',closable:false,
    collapsible:false,minimizable:false,maximizable:false">
    <table id="roleDatagrid"></table>
</div>


</body>
</html>
