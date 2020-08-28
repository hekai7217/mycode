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

<%-- 面板--%>

<div id="p" class="easyui-panel"
     style="width:99%;height:99%;background:#fafafa;"
     data-options="fit:true,iconCls:'icon-save',closable:false,
        collapsible:false,minimizable:false,maximizable:false">

    <div id="cc" class="easyui-layout" style="width:99%;height:99%">
        <div data-options=" collapsible:false,minimizable:false,maximizable:false,region:'west',title:'操作',split:true" style="width:180px;">

            <div style="margin:20px 0;text-align: center">
                <a href="javascript:void(0)" class="easyui-linkbutton c1" style="width:120px;margin-top: 20px">添加按钮</a>
                <a href="javascript:void(0)" class="easyui-linkbutton c2" style="width:120px;margin-top: 20px">编辑按钮</a>
                <a href="javascript:void(0)" class="easyui-linkbutton c3" style="width:120px;margin-top: 20px">修改按钮</a>
            </div>
        </div>
        <div data-options=" collapsible:false,minimizable:false,maximizable:false,region:'center',title:'当前系统菜单'" style="width:100%;padding:5px;background:#eee;">

<%--            菜单树
             一个空的菜单数据  查询  meunAllInfo 返回数据仅填充

             菜单数据的数据结构:
             每个节点可以包括下列属性：
            id：节点的 id，它对于加载远程数据很重要。
            text：要显示的节点文本。
            state：节点状态，'open' 或 'closed'，默认是 'open'。当设置为 'closed' 时，该节点有子节点，并且将从远程站点加载它们。
            attributes：给一个节点添加的自定义属性。
--%>
            <ul id="menuTree" class="easyui-tree" data-options="url:'menu/meunAllInfo.do'"></ul>
        </div>
    </div>

</div>


</body>
</html>
