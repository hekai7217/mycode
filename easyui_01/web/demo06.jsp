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
        $("#tt").tree({
            onClick: function (node) {

                // 点击 菜单的 二级节点
               var cs = node.children;
               if(!cs){ // 不是父节点
                   // 操作 选项卡
                   // 判断 选项卡是否存在  node.text (选项卡的标题)
                  var flag = $("#tab").tabs('exists',node.text);
                  if(flag){  //存在我们选中
                      $("#tab").tabs('select',node.text)
                  }else{ // 不存在 创建一个选项卡 添加到tabs中
                        $('#tab').tabs('add',
                            {
                                title:node.text ,
                                selected: true,
                                closable:true,
                                content:node.text
                            });
                  }
               }
            }
        });
    });

</script>

<div id="cc" class="easyui-layout" style="width:800px;height:600px;">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'west',title:'菜单',split:true,collapsible:false,disabled:true" style="width:240px;">

        <ul id="tt" class="easyui-tree">
            <%-- 一级菜单 --%>
            <li><span>天猫</span>

                <ul>
                    <%-- 二级菜单--%>
                    <li><span>天猫商城</span></li>
                    <li><span>聚划算</span></li>
                    <li><span>退货</span></li>
                </ul>

            </li>
            <%--一级菜单 --%>
            <li><span>京东</span>

                <ul>
                    <%--二级菜单--%>
                    <li><span>6-18活动</span></li>
                    <li><span>家电</span></li>
                    <li><span>生鲜</span></li>
                </ul>
            </li>
        </ul>

    </div>
    <div data-options="region:'center',title:'内容中心',collapsible:false,disabled:true"
         style="padding:5px;background:#eee;">
        <div id="tab" class="easyui-tabs" data-options="fit:true" style="width:500px;height:250px;">
            <div title="Tab1" style="padding:20px;display:none;"> tab1</div>
        </div>

    </div>
</div>

</body>
</html>
