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

    /************ 菜单和选项卡的切换**********/
    $(function(){

        $("#menuTree").tree({
            //1 给tree 添加添加事件
            onClick:function (node) {
                console.log(node);
            //2 判断是否有子菜单
               var cs = node.children;
               if(!cs){
                    // 3判断 tabs 是否已存在
                   var flag =  $("#mainTabs").tabs('exists',node.text);
                    //    存在 选中
                   if (flag){
                       //选中选项卡
                       $("#mainTabs").tabs('select',node.text);
                   }
                   else{
                       //    不存在 新创建一个
                       $("#mainTabs").tabs('add',{
                           title: node.text,
                           selected:true,
                           closable:true,
                           content:node.text
                       });
                   }
               }
            }
        })
    });
</script>

<div id="cc" class="easyui-layout" style="width:1000px;height:700px;">
    <%--     网站的 头部 --%>
    <div data-options="region:'north',split:false" style="height:75px;">
        <%--使用layout的嵌套布局，将头部分为，西，中，东三部分--%>
        <div class="easyui-layout" data-options="fit:true">
            <div data-options="region:'west',border:false"
                 style="width:20%;text-align: center;background-image: url('static/images/bg.png');overflow: hidden">
                <%--显示网站的logo--%>
                <img src="static/images/logo.png"
                     style="margin-left: 10px;margin-top: 5px; display:block; width:90%; height:96%;padding: 12px 2px">
            </div>
            <div data-options="region:'center',border:false"
                 style="background-image: url('static/images/bg.png');text-align: center">
                <%--声明网站的标题--%>
                <span style="color: white;font-size: 25px;position: relative;top:17px;">
                        Ting&nbsp;&nbsp;&nbsp;域&nbsp;&nbsp;&nbsp;主&nbsp;&nbsp;&nbsp;持&nbsp;&nbsp;&nbsp;人&nbsp;&nbsp;&nbsp;
                        后&nbsp;&nbsp;&nbsp;台&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;理&nbsp;&nbsp;&nbsp;系&nbsp;&nbsp;&nbsp;统
                    </span>
            </div>
            <div data-options="region:'east',border:false"
                 style="width:20%;background-image: url('static/images/bg.png');">
                <%--设置网站登录信息--%>
                <span style="position: relative;top:40px;font-size:15px;">
                        <span style="color: white">您好，${sessionScope.admin.aname}</span>
                        &nbsp;&nbsp;&nbsp;
                        <span><a href="#" style="color: white">退出</a></span>
                    </span>
            </div>
        </div>
    </div>
    <%--     网站的底部 --%>
    <div data-options="region:'south',title:'网站底部',split:true" style="height:100px;">
        网站底部
    </div>
    <%--     网站的系统菜单 左边  --%>
    <div data-options="region:'west',title:'系统菜单',split:true,collapsible:false,disabled:true" style="width:220px;">
        <%--        异步数 加载 系统菜单 --%>
        <ul id="menuTree" class="easyui-tree" data-options="url:'menu/menuInfo.do'"></ul>
    </div>
    <%--     网站的 主页  --%>
    <div data-options="region:'center',title:'主页'" style="padding:5px;background:#eee;">
        <div id="mainTabs" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">
            <div title="Tab1" style="padding:20px;display:none;" data-options="closable:true"> tab1</div>
        </div>
    </div>
</div>

</body>
</html>
