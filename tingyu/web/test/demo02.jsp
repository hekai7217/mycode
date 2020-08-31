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

<script>
    $(function(){

           // 初始化 tree 菜单
          $("#tt").tree({
              url:'test/tree_data2.json',
              checkbox:true,  //复选框
              lines:true,    // 节点分割线
              onClick:function (data) {
                console.log(data);
              }
          });

          $("#cb").click(function(){
              /**
               *   tree的选中的方法 :
               *     getChecked 获取选中的
               *       只能拿到选中的节点
               *
               *     indeterminate  获取模糊选中的
               *       可以拿到选中的节点和 模糊的节点
               */
              // var nodes = $("#tt").tree('getChecked',['checked']);
              var nodes = $("#tt").tree('getChecked',['checked','indeterminate']);
              // var nodes = $("#tt").tree('getChecked',['checked','indeterminate']);
              // var nodes = $("#tt").tree('getChecked',['checked','indeterminate']);
              console.log(nodes);
          });


          $("#sb").click(function(){
              //找到id是12 的  设置 他选中
              // var ids = [12,13,14,15];
              // 12 下面的所有的子菜单都会打钩

              var ids = [12,121,122];
              /**
               *   find 找到指定的节点并返回该节点对象。 通过id 拿到指定的节点
               *
               *   check 指定的节点打钩    node.target 节点的dom对象
               *
               *   $('#tt').tree('check', node.target);
               */
              for(var i = 0 ; i < ids.length ; i++ ){
                  var node = $('#tt').tree('find',ids[i]);
                  // $('#tt').tree('select', node.target);
                  $('#tt').tree('check', node.target);
              }

          });

    });
</script>

<body>
        <ul id="tt" class="easyui-tree"></ul>
        <br>
        <button id="cb">获取选中的属性菜单</button> <br>
        <button id="sb">设置选中的属性菜单</button> <br>
</body>
</html>
