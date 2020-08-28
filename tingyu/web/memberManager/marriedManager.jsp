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
    /*********初始化datagrid *********/
    $(function () {
        $("#marriedPersionDatagrid").datagrid({
            url:"marriedPerson/marriedPersonInfo.do",
            pagination:true, // 分页工具栏
            pageNumber:1,
            rownumbers:true, // datagrid 展示数据有行号
            fitColumns:true,
            pageSize:3,
            pageList:[3,6],
            columns:[[

                {field:'pname',title:'新人名称',width:80},
                {field:'phone',title:'新人手机号',width:80},
                {field:'pmail',title:'新人邮箱',width:80},
                {field:'marrydate',title:'新人婚期',width:80,
                    formatter:function (value,rows,index) {
                        return value.year + "-" + value.monthValue+"-" + value.dayOfMonth
                    }
                },
                {field:'status',title:'新人婚期',width:80,
                    formatter:function (value,rows,index) {
                        return value == "1"?"正常":"禁用";
                    }
                }

            ]]
        });

    });

    /****新人的条件查询************/

    $(function () {

        // 给查询按钮添加点击事件
        $("#search").click(function () {
            // datagrid 发送添加 查询数据
            $("#marriedPersionDatagrid").datagrid("load",{
                pname:$("#pname").val(),
                phone:$("#phone").val()
            });
        });

    });


</script>

<div id="p" class="easyui-panel"
     style="width:100%;height: 100%;background:#fafafa;"
     data-options="fit:true,iconCls:'icon-save',closable:false,
    collapsible:false,minimizable:false,maximizable:false">

    <div style="margin: auto;width:700px;text-align: center;margin-top: 5px;margin-bottom: 5px">

        <%--  新人条件查询条件 --%>
        <input id="pname" class="easyui-textbox" prompt="新人姓名" style="width:100px">
        <input id="phone" class="easyui-textbox" prompt="新人手机号" style="width:100px">

        <a id="search" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>

    </div>

    <table id="marriedPersionDatagrid"></table>

</div>

</body>
</html>
