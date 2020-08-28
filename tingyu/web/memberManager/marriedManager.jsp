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
    $(function () {

        /*********初始化datagrid *********/
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
</script>

<div id="p" class="easyui-panel"
     style="width:100%;height: 100%;background:#fafafa;"
     data-options="fit:true,iconCls:'icon-save',closable:false,
    collapsible:false,minimizable:false,maximizable:false">


    <table id="marriedPersionDatagrid"></table>

</div>

</body>
</html>
