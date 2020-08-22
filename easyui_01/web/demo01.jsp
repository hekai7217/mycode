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

     写一个简单组件:

    class 组件的样式
      属性:
        title  标题
        style 样式
        data-options  数据的配置:
        iconCls 图标
        closable: 定义是否显示关闭按钮。 true 有关闭按钮
        collapsible 定义是否显示折叠按钮。  true 有折叠按钮
        minimizable 最小    true 有
        maximizable 最大    true 有

        组件可以 html 初始化也可以 js初始化
 --%>

<script>

    // js 初始化 组件
    $(function () {

        $("#p").panel({
            height:300,
            width:200,
            title:'今天适合写代码',
            iconCls:'icon-ok',
            closable:true
        })

    });


</script>

<div id="p" class="easyui-panel"
     style="width:500px;height:200px;padding:10px;background:#fafafa;"
     data-options="collapsible:false,minimizable:false,maximizable:false">
    <p>panel content.</p>
    <p>panel content.</p>
    <div>
        <h1>这么厉害</h1>
    </div>
</div>

</body>
</html>
