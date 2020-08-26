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

    /********初始化 companyDataGird**********/


    $(function () {

        $("#companyDataGird").datagrid({
            url:"company/companyInfo.do",
            pagination:true, // 分页工具栏
            rownumbers:true,
            fitColumns:true,  // 设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
            pageNumber:1,
            pageSize:3,
            pageList:[3,6], // pageSize 和 pageList 要 一起使用
            checkOnSelect:false,
            title:"查询结果",

            columns:[[
                // 一列的数据  field展示数据的key (从json获取数据的key )
                {field:'aa',checkbox:true},
                {field:'cid',title:'编号',width:80},
                {field:'cname',title:'公司名称',width:80},
                {field:'ceo',title:'公司法人',width:80},
                {field:'cphone',title:'手机号',width:80},
                {field:'starttime',title:'开通时间',width:80,
                    formatter:function (value,rows,index) {
                        return value.year + "-" + value.monthValue+"-" + value.dayOfMonth
                        + " " + value.hour + ":" + value.minute
                    }
                },
                {field:'ordernumber',title:'订单量',width:80},
                {field:'status',title:'账号状态',width:80,
                    formatter:function (value,rows,index) {
                        return value =="0" ? "禁用":"正常";
                    }
                },
            ]]
        });
    });

    /*********条件查询*********/
    $(function () {
        // 给查询添加点击事件
        $("#search").click(function () {
            // 发送数据
            // datagrid 发送数据
            $("#companyDataGird").datagrid('load',{
                cname:$("#cname").val(),
                status:$("#status").val(),
                ordernumber:$("#ordernumber").val(),
            })
        });
    });


</script>
<div id="p" class="easyui-panel"
     style="width:100%;height:75%;padding:10px;background:#fafafa;"
     data-options="iconCls:'icon-save',closable:true,
        collapsible:false,minimizable:false,maximizable:false,fit:true">

    <div style="margin: auto;width:700px;text-align: center;margin-bottom:10px">

        <%--  公司的查询条件 --%>
        <input id="cname" class="easyui-textbox" prompt="公司名称" style="width:100px">

        <select id="status" class="easyui-combobox" data-options="editable:true,value:'账号状态',panelHeight:'auto'"
                style="width:100px;">
            <option value="0">禁用</option>
            <option value="1">正常</option>
        </select>

        <select id="ordernumber" class="easyui-combobox" data-options="editable:true,value:'订单排序',panelHeight:'auto'"
                style="width:100px;">
            <%--          订单排序  --%>
            <option value="asc">升序</option>
            <option value="desc">降序</option>
        </select>
        <a id="search" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>

    </div>

    <%--        展示company 表格数据 --%>
    <table id="companyDataGird"></table>
</div>


</body>
</html>
