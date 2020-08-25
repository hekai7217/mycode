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

    <%--        datagrid的初始化  --%>
    $(function () {

        $("#hostDataGird").datagrid({
            url: 'host/hostInfo.do',  //请求的url
            pagination: true,  // 有分页工具栏
            rownumbers: true,  // 行号
            pageNumber: 1,    // 初始化页面 第一页
            pageSize: 3,       // 每页的数据大小
            pageList: [3, 6],  // 设置页面的大小
            checkOnSelect: false,  // 选中复选框才可以选中一行
            title: '查询结果',
            toolbar: '#hostToolBar',
            columns: [[
                // field 每一行 通过key 获取value的值进行填充
                // title 类名
                //初始化datagrid
                // 默认选中一个点 会选中一行
                // 给他一个 checkbox  设置checkbox才可以选中的
                {field: 'aa', checkbox: true},
                // 权限用input 展示数据 可以进行编辑修改
                //失去焦点 发送ajax 修改数据
                {
                    field: 'strong', title: '权重', width: 70,
                    formatter: function (value, rowData, index) {
                        return "<input type='text' value='" + value + "'style='width: 40px'" +
                            " onblur='changeStrong(this," + rowData.hid + "," + value + ")'/>";
                    }
                },
                {field: 'hname', title: '姓名', width: 80},
                {field: 'hphone', title: '手机号', width: 100},
                {
                    field: 'starttime', title: '开通时间', width: 120,
                    formatter: function (value, rowData, index) {
                        // 格式化时间
                        return value.year + "-" + value.monthValue + "-" + value.dayOfMonth
                            + " " + value.hour + ":" + value.minute;
                    }
                },

                {
                    field: 'hpprice', title: '价格', width: 50,
                    // value 字段的值
                    // rowData 行的数据
                    // index 下标
                    formatter: function (value, rowData, index) {

                        if (rowData.hostPower) {
                            // 可以拿到价格
                            // 返回到 datagrid 中展示数据
                            return rowData.hostPower.hpprice;
                        } else {
                            return "";
                        }
                    }
                },
                {field: 'ordernumber', title: '订单量', width: 50},
                {
                    field: 'hpdiscount', title: '折扣', width: 50,
                    formatter: function (value, rowData, index) {

                        if (rowData.hostPower) {
                            // 可以拿到折扣
                            // 返回到 datagrid 中展示数据
                            return rowData.hostPower.hpdiscount;
                        } else {
                            return "";
                        }
                    }
                },
                {
                    field: 'hpstar', title: '星推荐', width: 70,
                    formatter: function (value, rowData, index) {

                        if (rowData.hostPower) {
                            // 可以拿到推荐
                            // 返回到 datagrid 中展示数据
                            return rowData.hostPower.hpstar == "1" ? "推荐" : "不推荐";
                        } else {
                            return "";
                        }
                    }
                },
                {
                    field: 'status', title: '账号状态', width: 70,
                    formatter: function (value, rowData, index) {
                        return value == 1 ? "正常" : "禁用";
                    }
                }

            ]]
        });

    });

    /*******失去焦点 发送ajax 修改权重 ********/
    /**
     *
     * @param inp   input标签
     * @param hid   hid    修改的时候需要host的id
     * @param value  之前的strong的值
     */
    function changeStrong(inp, hid, value) {
        // 拿到 inp的编辑的数据
        // value 之前的数据
        // 判断 inp编辑的数据和value数据是否不相等
        // 拿到iup的编辑数据
        var newStrong = inp.value;
        // 判断数据是否发送了变化
        if (newStrong != value) {
            // 发送ajax
            $.post("host/hostStrongUp.do",
                {
                    hid: hid,
                    strong: newStrong
                },
                function (data) { // 请求执行的成功函数
                    //判断是否请求成成功
                    if (data.success) {
                        //提示 修改成功
                        $.messager.alert("修改权重", data.msg, "info");
                        // 数据要刷新 dataGrid  reload
                        $("#hostDataGird").datagrid('reload');

                    } else {
                        $.messager.alert("修改权重", data.msg, "error");
                    }
                }, "json");
        }
    }

    /********条件查询host*********/
    $(function () {

        // 给查查询添加点击按钮
        $("#search").click(function () {

            //发送请求数据
            // 发送请求数据 ?  不是表单发送的
            // datagrid 的发送这些请求数据
            // datagrid 请求数据    load 方法  这个方法可以设置 参数
            // 如果 queryParams 属性 会把 这个数据参数给覆盖点
            // load的调用不需要 设置url. 初始化的时候已经设置了

            $("#hostDataGird").datagrid(
                'load', {  // 设置参数
                    hname: $("#hname").val(),
                    status: $("#status").val(),
                    strong: $("#strong").val(),
                    hpstar: $("#hpstar").val(),
                    hpdiscount: $("#hpdiscount").val(),
                });

        });
    });

    /***********添加主持人操作*************/
    $(function(){

        // 点击 addHost 把 添加host的 dialog展示出来
        $("#addHost").click(function () {
            $("#addHostDialog").dialog('open');
        });

        // 编辑完毕后  表单提交数据
        // 点击 表单的 完成按钮提交数据
        $("#btnAddHost").click(function(){
            // 表单提交数据
            $("#addHostFrom").form(
                'submit',{
                    url:'host/addHost.do',
                    success:function (data) {  // 请求成功的指定函数
                        // data的数据类型是字符串
                        // 转成json
                        var obj = JSON.parse(data);
                        if(obj.success){ // 成功
                            // 信息提示
                            $.messager.alert("添加成功",obj.msg,"info");
                            // 表单的数据清理
                            $("#addHostFrom").form('clear');
                            //  dialog 隐藏
                            $("#addHostDialog").dialog('close');
                            // datagrid 重新加载
                            $("#hostDataGird").datagrid('reload');
                        }else{ // 失败操作
                            $.messager.alert("添加失败",obj.msg,"error");
                        }
                    }
                }
            )
        });
    });


</script>

<%-- 添加host的 dialog --%>

<div id="addHostDialog" class="easyui-dialog" title="添加主持人" style="width:400px;height:300px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <form id="addHostFrom" method="post">
        <div style="text-align: center;margin-top: 20px">
            <input name="hname" class="easyui-textbox" prompt="用户名" style="width:180px">
        </div>

        <div style="text-align: center;margin-top: 20px">
            <input name="hpwd" class="easyui-textbox" prompt="密码" style="width:180px">
        </div>

        <div style="text-align: center;margin-top: 20px">
            <input name="hphone" class="easyui-textbox" prompt="手机号码" style="width:180px">
        </div>

        <div style="text-align: center;margin-top: 20px">
            <a id="btnAddHost" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">添加完成</a>
        </div>
    </form>

</div>

<div id="p" class="easyui-panel"
     style="width:100%;height:75%;padding:10px;background:#fafafa;"
     data-options="iconCls:'icon-save',closable:true,
        collapsible:false,minimizable:false,maximizable:false,fit:true">

    <div style="margin: auto;width:700px;text-align: center;margin-bottom:10px">

        <%--  姓名的查询条件 --%>
        <input id="hname" class="easyui-textbox" prompt="姓名" style="width:100px">

        <select id="status" class="easyui-combobox" data-options="editable:true,value:'账号状态',panelHeight:'auto'"
                style="width:100px;">
            <option value="0">禁用</option>
            <option value="1">正常</option>
        </select>

        <select id="strong" class="easyui-combobox" data-options="editable:true,value:'权重排序',panelHeight:'auto'"
                style="width:100px;">
            <%--            升序降序 传入 配置规则  在服务器 代码中进行SQL的拼接 --%>
            <option value="asc">升序</option>
            <option value="desc">降序</option>
        </select>

        <%--            星推荐 --%>
        <select id="hpstar" class="easyui-combobox" data-options="editable:true,value:'星推荐',panelHeight:'auto'"
                style="width:100px;">
            <option value="0">不推荐</option>
            <option value="1">推荐</option>
        </select>

        <select id="hpdiscount" class="easyui-combobox" data-options="editable:true,value:'折扣',panelHeight:'auto'"
                style="width:100px;">
            <option value="9">9</option>
            <option value="8">8</option>
            <option value="7">7</option>
            <option value="6">6</option>
        </select>

        <a id="search" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
        <a id="#" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">导出</a>

    </div>

    <%--        展示 host的 表格数据 --%>
    <table id="hostDataGird"></table>
</div>

<div id="hostToolBar">
    <a id="addHost" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加主持人</a>
    <a id="hostAccount" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-no'">账号禁用</a>
    <a id="editPower" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">权限设置</a>
    <a id="batch" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cut'">批量操作</a>

</div>

</body>
</html>
