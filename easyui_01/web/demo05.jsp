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

<div id="aa" class="easyui-accordion" style="width:300px;height:200px;">
    <div title="Title1" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;"><h3
            style="color:#0099FF;">Accordion for jQuery</h3>
        <p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web page
            more easily.</p></div>
    <div title="Title2" data-options="iconCls:'icon-reload'," style="padding:10px;"> content2</div>
    <div title="Title3"> content3</div>
</div>

</body>
</html>
