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

    /********添加菜单*****/
    $(function () {

        // 添加菜单点击事件
        $("#adddMenu").click(function () {

            // 1. 判断你的tree 是否选中  提交pid
            // 如果没有选中 pid = 0
            // 选中 tree 的节点 返回 node
            var node = $("#menuTree").tree("getSelected");
            console.log(node);
            if (node != null) { // 选中了节点
                //把这个节点的id 作为添加菜单的节点的pid
                $("#pid").val(node.id);
            }
            // 2. 把添加菜单按钮展示出来
            $("#addMenuDialog").dialog('open');
        });

        // 3 提交数据
        $("#btnAddMenu").click(function () {

            // 表单提交数据
            $("#addMenuForm").form('submit', {
                url: 'menu/addMenu.do',
                success: function (data) {

                    var d = JSON.parse(data);
                    if (d.success) {
                        //提示
                        $.messager.alert("提示", d.msg, "info");

                        //清空 表单
                        $("#addMenuForm").form('reset');
                        // 菜单刷新
                        $("#menuTree").tree('reload');
                    } else {
                        $.messager.alert("提示", d.msg, "error");
                    }
                    //关闭 dialog
                    $("#addMenuDialog").dialog('close');
                }
            });
        });

    });

    /*********编辑菜单********/

    $(function () {

        //编辑菜单
        $("#editMenu").click(function () {

            // 1 判断是否选中了菜单
            var node = $("#menuTree").tree('getSelected');

            if (node != null) {
                // 2  数据回显
                // 选中的 菜单 的数据和 form 的属性不能对应 需要手动映射
                $("#editMenuForm").form('load', {
                    mid: node.id,
                    mname: node.text,
                    url: node.attributes.url,
                    mdesc: node.attributes.mdesc,
                });
                // 3  显示编辑对话框
                $("#editMenuDialog").dialog('open');
            } else {
                //提示
                $.messager.alert("提示", "编辑菜单必须要选中一个菜单进行编辑", "error")
            }
        });

        // 编辑菜单提交数据
        $("#btnEditMenu").click(function () {

            //拿到表单提交数据
            $("#editMenuForm").form("submit", {
                url: 'menu/editMenu.do',
                success: function (data) {
                    var d = JSON.parse(data);
                    if (d.success) {
                        //提示信息
                        $.messager.alert("提示", d.msg, "info");

                        // 关闭对话框
                        $("#editMenuDialog").dialog('close');
                        // 表单数据清空
                        $("#editMenuForm").form('reset');
                        // 刷新菜单
                        $("#menuTree").tree('reload');
                    } else {
                        $.messager.alert("提示", d.msg, "error");
                    }
                }
            })
        });
    });

    $(function () {

        //给 删除菜单添加点击事件
        $("#removeMenu").click(function () {

            // 1 判断 实现选中了 tree 菜单
            var node = $("#menuTree").tree('getSelected');

            console.log(node)
            if (node != null) {

                // 参数1   title
                // 参数2   msg
                // 参数3   fn
                $.messager.confirm("删除菜单", "确认删除吗", function (r) {

                    // 点击确认  出入 boolean = true
                    if (r) {
                        // 发送ajax进行删除
                        // 2. ajax 把 删除的菜单 mid pid发送到服务器
                        $.post("menu/menuDel.do", {
                            mid: node.id,
                            pid: node.attributes.pid
                        }, function (data) {
                            if (data.success) {
                                // 3 提示
                                $.messager.alert("提示", data.msg, "info");
                                // 刷新菜单数
                                $("#menuTree").tree('reload');
                            }else{
                                $.messager.alert("提示", data.msg, "error");
                            }
                        }, "json");
                    }
                })
            } else {
                $.messager.alert("提示", "必须选中一个菜单", "error");
            }
        });
    });


</script>

<%-- 编辑菜单的 dialog--%>
<div id="editMenuDialog" class="easyui-dialog" title="编辑菜单" style="width:320px;height:260px;"
     data-options="top:10,iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <%--        编辑菜单表单 --%>
    <form id="editMenuForm" method="post">

        <input type="hidden" id="mid" name="mid">

        <div style="text-align: center;margin-top: 20px">
            <input name="mname" class="easyui-textbox" prompt="菜单的名称" style="width:180px">
        </div>

        <div style="text-align: center;margin-top: 20px">
            <input name="url" class="easyui-textbox" prompt="菜单的url" style="width:180px">
        </div>

        <div style="text-align: center;margin-top: 20px">
            <input name="mdesc" class="easyui-textbox" prompt="菜单的描述" style="width:180px">
        </div>

        <div style="text-align: center;margin-top: 20px">
            <a id="btnEditMenu" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">编辑完成</a>
        </div>
    </form>
</div>


<%--添加菜单的 dialog--%>
<div id="addMenuDialog" class="easyui-dialog" title="添加菜单信息" style="width:320px;height:260px;"
     data-options="top:10,iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <%--        添加菜单的表单 --%>
    <form id="addMenuForm" method="post">

        <input type="hidden" id="pid" name="pid">

        <div style="text-align: center;margin-top: 20px">
            <input name="mname" class="easyui-textbox" prompt="菜单的名称" style="width:180px">
        </div>

        <div style="text-align: center;margin-top: 20px">
            <input name="url" class="easyui-textbox" prompt="菜单的url" style="width:180px">
        </div>

        <div style="text-align: center;margin-top: 20px">
            <input name="mdesc" class="easyui-textbox" prompt="菜单的描述" style="width:180px">
        </div>

        <div style="text-align: center;margin-top: 20px">
            <a id="btnAddMenu" href="javascript:void(0)" class="easyui-linkbutton"
               data-options="iconCls:'icon-ok'">添加完成</a>
        </div>
    </form>
</div>

<%-- 面板--%>
<div id="p" class="easyui-panel"
     style="width:99%;height:99%;background:#fafafa;"
     data-options="fit:true,iconCls:'icon-save',closable:false,
        collapsible:false,minimizable:false,maximizable:false">

    <div id="cc" class="easyui-layout" style="width:99%;height:99%">
        <div data-options=" collapsible:false,minimizable:false,maximizable:false,region:'west',title:'操作',split:true"
             style="width:180px;">

            <div style="margin:20px 0;text-align: center">
                <a id="adddMenu" href="javascript:void(0)" class="easyui-linkbutton c1"
                   style="width:120px;margin-top: 20px">添加菜单</a>
                <a id="editMenu" href="javascript:void(0)" class="easyui-linkbutton c2"
                   style="width:120px;margin-top: 20px">编辑菜单</a>
                <a id="removeMenu" href="javascript:void(0)" class="easyui-linkbutton c3"
                   style="width:120px;margin-top: 20px">删除菜单</a>
            </div>
        </div>
        <div data-options=" collapsible:false,minimizable:false,maximizable:false,region:'center',title:'当前系统菜单'"
             style="width:100%;padding:5px;background:#eee;">

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
