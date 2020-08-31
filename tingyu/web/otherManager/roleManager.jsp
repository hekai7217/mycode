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

            toolbar: '#roleToolBar',
            columns: [[
                {field: 'aa', checkbox:true},
                {field: 'rid', title: '角色编号', width: 100},
                {field: 'rname', title: '角色名称', width: 100},
                {field: 'rdesc', title: '角色描述', width: 100}
            ]]
        })

    });

    /*********添加角色********/

    $(function () {

        // 点击 添加节点的按钮 展示添加角色的 dialog
        $("#addRole").click(function () {
            $("#addRoleDialog").dialog('open');
        });

        // 编辑后提交数据
        $("#btnAddRole").click(function () {

            // 1 拿到 你选中的 菜单id
            // getChecked 是否需要添加模糊 选择 根据具体的文档操作
            var nodes = $("#menuTree").tree('getChecked',['checked']);
            // 2 把这个菜单id通过 隐藏标签 提交到服务器
            var mids = "";
            // 把选中的菜单的id 拼接成字符串
            if(nodes != null){
                for (var i = 0 ; i < nodes.length ; i ++){
                    mids+=nodes[i].id +",";
                }
            }
            console.log(mids)
            // 通过 隐藏把选中的mids 提交到服务器
            $("#mids").val(mids);
            // 3 表单提交
            $("#addRoleForm").form('submit',{
               url:'role/addRole.do',
               success:function (data) {
                   var  d = JSON.parse(data);
                   if (d.success){
                       // 4 判断
                       // 成功提示
                       $.messager.alert("提示",d.msg,"info");
                       // 关闭对话框
                       $("#addRoleDialog").dialog('close');
                       // 表单的数据清空
                       $("#addRoleForm").form('reset');
                       // datagrid 重新加载
                       $("#roleDatagrid").datagrid('reload');
                       $("#menuTree").tree('reload');
                   }else{
                       $.messager.alert("提示",d.msg,"error");
                   }
               }
            })
        });
    });


    /*********修改角色**********/
    $(function () {

        $("#editRole").click(function () {

            // 选中角色
           var  tr =  $("#roleDatagrid").datagrid('getChecked');
           if (tr.length == 1){

               // 数据回显
               var obj = tr[0];
               // 表单的数据回显
                $("#editRoleForm").form('load',tr[0]);
                // 选择1   ajax 查询 父亲 找 当前的角色的mids 对应的菜单

               // 查询 role的时候直接给 role赋值 给mids 属性 对应的菜单id集合
               // 回显树形 菜单
               var mids = tr[0].mids;

               // 拿到 tree 对应的节点  find方法
               for(var i = 0 ; i < mids.length ; i++ ){
                  var node =  $("#menuEditTree").tree('find',mids[i]);
                  if (node != null){
                      $("#menuEditTree").tree('check',node.target)
                  }
               }
               // 编辑
               //展示编辑框
               $("#editRoleDialog").dialog('open');
           }else if(tr.length > 1){
               $.messager.alert("提示","只能选择一个角色进行编辑","error");
           }else{
               $.messager.alert("提示","必须选中一个角色才能编辑","error");
           }
        });
        // 提交数据
        $("#btneditRole").click(function () {

            // 把 表单的数据提交

            // 把tree 选中的菜单进行隐藏标签的提交
            // 1 拿到 你选中的 菜单id
            var nodes = $("#menuEditTree").tree('getChecked',['checked']);
            var mids = "";
            // 把选中的菜单的id 拼接成字符串
            if(nodes != null){
                for (var i = 0 ; i < nodes.length ; i ++){
                    mids+=nodes[i].id +",";
                }
            }
            console.log(mids)
            // 通过 隐藏把选中的mids 提交到服务器
            $("#editmids").val(mids);

            // 表单提交数据
            $("#editRoleForm").form('submit',{
                url:'role/editRole.do',
                success:function (data) {
                    var  d = JSON.parse(data);
                    if (d.success){
                        // 4 判断
                        // 成功提示
                        $.messager.alert("提示",d.msg,"info");
                        // 关闭对话框
                        $("#editRoleDialog").dialog('close');
                        // 表单的数据清空
                        $("#addRoleForm").form('reset');
                        // datagrid 重新加载
                        $("#roleDatagrid").datagrid('reload');
                        $("#menuTree").tree('reload');
                    }else{
                        $.messager.alert("提示",d.msg,"error");
                    }
                }
            })
        });
    });

    /***********删除角色**********/

    $(function () {

        // 删除角色 给按钮添加点击事件
        $("#removeRole").click(function () {

            //  1 判断datagrid是否选中了 角色

            var trs = $("#roleDatagrid").datagrid("getChecked");

            if (trs.length > 0 ){
                    // 2 通过ajax 把选中的 角色的id发送到服务器
                // 把选中的 角色的id 收集 拼接成一个字符串
                var rids = "";
                for (var i = 0 ; i < trs.length; i++){
                    rids += trs[i].rid+",";
                }
                // 给个确认框 删除操作

                // titil, msg ,func
                $.messager.confirm("删除角色","确认删除角色吗?",function (r) {

                    if (r){
                        // 发送ajax
                        $.post("role/roleDel.do",{rids:rids},function (data) {

                            if (data.success){
                                // 提示
                                $.messager.alert("提示",data.msg,"info");
                                // 刷新数据
                                $("#roleDatagrid").datagrid('reload');
                            }else{
                                $.messager.alert("提示",data.msg,"info");
                            }

                        },"json")
                    }

                });


            }else{
                $.messager.alert("提示","必须选中一个角色进行删除","error");
            }



        });


    });



</script>


<%--    修改角色的dialog --%>
<div id="editRoleDialog" class="easyui-dialog" title="添加角色" style="width:700px;height:600px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <div class="easyui-layout" data-options="fit:true" style="width:99%;height:99%">
        <div data-options="collapsible:false,minimizable:false,maximizable:false,region:'west',title:'角色添加',split:false"
             style="width:300px;">
            <form id="editRoleForm" method="post">
                <input id="editmids" type="hidden" name="mids">
                <input id="rid" type="hidden" name="rid">
                <div style="text-align: center;margin-top: 30px">
                    <input name="rname" class="easyui-textbox" prompt="角色名称" style="width:150px">
                </div>

                <div style="text-align: center;margin-top: 30px">
                    <input name="rdesc" class="easyui-textbox" prompt="角色描述" style="width:150px">
                </div>

                <div style="text-align: center;margin-top: 30px">
                    <a id="btneditRole" href="javascript:void(0)" class="easyui-linkbutton"
                       data-options="iconCls:'icon-ok'">修改完成</a>
                </div>
            </form>

        </div>
        <div data-options=" collapsible:false,minimizable:false,maximizable:false,region:'center',title:'当前系统菜单'"
             style="width:100%;padding:5px;background:#eee;">

            <ul id="menuEditTree" class="easyui-tree" data-options="checkbox:true,url:'menu/meunAllInfoChildren.do'"></ul>
        </div>
    </div>
</div>

<%--    添加角色的dialog --%>
<div id="addRoleDialog" class="easyui-dialog" title="添加角色" style="width:700px;height:600px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <div id="cc" class="easyui-layout" data-options="fit:true" style="width:99%;height:99%">
        <div data-options="collapsible:false,minimizable:false,maximizable:false,region:'west',title:'角色添加',split:false"
             style="width:300px;">
            <form id="addRoleForm" method="post">
                <input id="mids" type="hidden" name="mids">
                <div style="text-align: center;margin-top: 30px">
                    <input name="rname" class="easyui-textbox" prompt="角色名称" style="width:150px">
                </div>

                <div style="text-align: center;margin-top: 30px">
                    <input name="rdesc" class="easyui-textbox" prompt="角色描述" style="width:150px">
                </div>

                <div style="text-align: center;margin-top: 30px">
                    <a id="btnAddRole" href="javascript:void(0)" class="easyui-linkbutton"
                       data-options="iconCls:'icon-ok'">添加完成</a>
                </div>
            </form>

        </div>
        <div data-options=" collapsible:false,minimizable:false,maximizable:false,region:'center',title:'当前系统菜单'"
             style="width:100%;padding:5px;background:#eee;">

            <ul id="menuTree" class="easyui-tree" data-options="checkbox:true,url:'menu/meunAllInfoChildren.do'"></ul>
        </div>
    </div>
</div>

<div id="p" class="easyui-panel"
     style="width:500px;height:150px;padding:10px;background:#fafafa;"
     data-options="fit:true,iconCls:'icon-save',closable:false,
    collapsible:false,minimizable:false,maximizable:false">
    <table id="roleDatagrid"></table>
</div>

<div id="roleToolBar">
    <a id="addRole" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加角色</a>
    <a id="editRole" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑角色</a>
    <a id="removeRole" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除角色</a>
</div>

</body>
</html>
