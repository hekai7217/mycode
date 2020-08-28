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

    /*********stuDataGird 组件的初始化************/
    $(function () {
        // pageSize 一定要是 pageList中存在的数据
        $("#stuDataGird").datagrid({
            url: 'student/stuAll.do',  // 请求数据的路径
            pagination: true, // 底部显示分页工具栏
            rownumbers: true, //每行显示行号
            pageNumber: 1,    //初始化页面
            pageSize: 3,       // 每页数据的大小
            pageList: [3, 6],
            toolbar: '#stuToolBar', // 工具bar
            columns: [[
                // 发送过来的数据的key   title 列名  width 宽  (你返回的数据是json 数据 组件会自动给你转成想要的数据进行填充)
                {field: 'aa', checkbox: true}, //展示一行数据
                {field: 'sid', title: 'id', width: 80}, //展示一行数据
                {field: 'sName', title: '姓名', width: 80},
                {field: 'sage', title: '年龄', width: 80},
                {field: 'ssex', title: '性别', width: 80},
                {field: 'sphone', title: '手机', width: 80}
            ]]
        });
    });

    /***************添加功能****************/
    $(function () {

        $("#btn_add").click(function () {
            // 展示 添加对话框
            $("#addStuDialog").dialog('open');
        });

        //点击完成才提交数据
        $("#btnAddFrom").click(function () {
            // 发送数据
            $("#addStuForm").form(
                'submit', // 数据提交
                {
                    url:"student/addStu.do" , // 提交的地址
                    success:function(data){
                        // 把字符串转成json对象
                        console.log(data);
                        var d = JSON.parse(data);
                        if (d.success){
                            // 提示信息
                            $.messager.alert("添加提示",d.msg,"info");
                            // 关闭  对话框
                            $("#addStuDialog").dialog('close');
                            // dataGrid的数据要更新 (重新加载数据)
                            $("stuDataGird").datagrid('reload');

                        }else{
                            $.messager.alert("添加提示",d.msg,"error");
                        }

                    }
                });
        });

    });

    /***************修改操作**********************/

    $(function () {

        $("#btn_edit").click(function () {

            //判断 datagrid是否选中了数据
            // 返回选中 的所有的行
           var trs = $("#stuDataGird").datagrid('getChecked');
           console.log(trs);
           // 判断 只能选中一个数据
            if (trs.length > 1){ // 不能太多了
                $.messager.alert("修改提示","只能选一条数据","info");
            }else if(trs.length == 1){

                // 拿到数据
               var obj =  trs[0];
               // 表单填充数据 load
                // 填充数据要注意  数据源和 表单的字段要一致
                $("#editStuForm").form('load',obj);

                // 对话框展示
                $("#editStuDialog").dialog('open');

            }else{  // 不能选数据
                $.messager.alert("修改提示","敢不敢选择一条数据","info");
            }
        });

        //提交数据
        $("#btnEditFrom").click(function(){
               $("#editStuForm").form('submit',{
                   url:'student/editStu.do',
                   success:function(data){
                       var d = JSON.parse(data);
                       if (d.success){
                           // 提示信息
                           $.messager.alert("修改提示",d.msg,"info");
                           // 关闭  对话框
                           $("#editStuDialog").dialog('close');
                           // dataGrid的数据要更新 (重新加载数据)
                           $("#stuDataGird").datagrid('reload');

                       }else{
                           $.messager.alert("修改提示",d.msg,"error");
                       }
                   }
               })
        });

    });

</script>

<%--修改的编辑对话框--%>
<div id="editStuDialog" class="easyui-dialog" title="修改学生" style="width:400px;height:280px;"
     data-options="iconCls:'icon-save',resizable:false,modal:true,left:200,top:50,closed:true">

    <form id="editStuForm" method="post">

<%--        修改的时候 要有id --%>
        <input type="hidden"  name="sid"/>

        <div style="text-align: center;margin-top: 10px">
            <label for="sName">姓名:</label>
            <input class="easyui-textbox" type="text" name="sName" />
        </div>
        <div style="text-align: center;margin-top: 10px">
            <label for="sage">年龄:</label>
            <input class="easyui-textbox" type="text" name="sage"/>
        </div>
        <div style="text-align: center;margin-top: 10px">
            <label for="ssex">性别:</label>
            <input class="easyui-textbox" type="text" name="ssex"/>
        </div>
        <div style="text-align: center;margin-top: 10px">
            <label for="sphone">手机:</label>
            <input class="easyui-textbox" type="text" name="sphone"/>
        </div>

        <div style="text-align: center;margin-top: 10px">
            <a id="btnEditFrom" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">完成修改</a>
        </div>

    </form>

</div>

<%--添加学生的对话框--%>
<div id="addStuDialog" class="easyui-dialog" title="添加学生" style="width:400px;height:280px;"
     data-options="iconCls:'icon-save',resizable:false,modal:true,left:200,top:50,closed:true">

    <form id="addStuForm" method="post">
        <div style="text-align: center;margin-top: 10px">
            <label for="sName">姓名:</label>
            <input class="easyui-textbox" type="text" name="sName" />
        </div>
        <div style="text-align: center;margin-top: 10px">
            <label for="sage">年龄:</label>
            <input class="easyui-textbox" type="text" name="sage"/>
        </div>
        <div style="text-align: center;margin-top: 10px">
            <label for="ssex">性别:</label>
            <input class="easyui-textbox" type="text" name="ssex"/>
        </div>
        <div style="text-align: center;margin-top: 10px">
            <label for="sphone">手机:</label>
            <input class="easyui-textbox" type="text" name="sphone"/>
        </div>

        <div style="text-align: center;margin-top: 10px">
            <a id="btnAddFrom" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">完成添加</a>
        </div>

    </form>

</div>

<%--展示数据的面板--%>
<div id="p" class="easyui-panel" title="学生数据展示"
     style="width:500px;height:300px;padding:10px;background:#fafafa;"
     data-options="iconCls:'icon-save',closable:false,
    collapsible:false,minimizable:false,maximizable:false">
    <%--    展示数据网格组件--%>
    <table id="stuDataGird"></table>
</div>

<div id="stuToolBar">
    <%--linkbutton组件效果--%>
    <a id="btn_add" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加学生</a>
    <a id="btn_edit" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改学生</a>
    <a id="btn_delete" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除学生</a>

</div>

</body>
</html>
