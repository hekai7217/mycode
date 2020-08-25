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

            //初始化datagrid
            $("#hostDataGird").datagrid({
                url:'host/hostInfo.do',  //请求的url
                pagination:true,  // 有分页工具栏
                rownumbers:true,  // 行号
                pageNumber:1,    // 初始化页面 第一页
                pageSize:3,       // 每页的数据大小
                pageList:[3,6],  // 设置页面的大小
                title:'查询结果',
                columns:[[
                    // field 每一行 通过key 获取value的值进行填充
                    // title 类名
                    {field:'strong',title:'权重',width:70},
                    {field:'hname',title:'姓名',width:80},
                    {field:'hphone',title:'手机号',width:120},
                    {field:'starttime',title:'开通时间',width:120,
                        formatter:function(value,rowData,index){
                            // 格式化时间
                            return value.year + "-" + value.monthValue + "-" + value.dayOfMonth
                                + " " + value.hour + ":" + value.minute;
                        }
                    },

                    {field:'hpprice',title:'价格',width:50,
                        // value 字段的值
                        // rowData 行的数据
                        // index 下标
                        formatter:function(value,rowData,index){

                                if(rowData.hostPower){
                                    // 可以拿到价格
                                    // 返回到 datagrid 中展示数据
                                    return rowData.hostPower.hpprice;
                                }else{
                                    return "";
                                }
                        }
                    },
                    {field:'ordernumber',title:'订单量',width:50},
                    {field:'hpdiscount',title:'折扣',width:50,
                        formatter:function (value,rowData,index) {

                            if(rowData.hostPower){
                                // 可以拿到折扣
                                // 返回到 datagrid 中展示数据
                                return rowData.hostPower.hpdiscount;
                            }else{
                                return "";
                            }
                        }
                    },
                    {field:'hpstar',title:'星推荐',width:70,
                        formatter:function (value,rowData,index) {

                            if(rowData.hostPower){
                                // 可以拿到推荐
                                // 返回到 datagrid 中展示数据
                                return rowData.hostPower.hpstar == "1"?"推荐":"不推荐";
                            }else{
                                return "";
                            }
                        }
                    },
                    {field:'status',title:'账号状态',width:70,
                        formatter:function (value,rowData,index) {
                           return value == 1 ? "正常":"禁用";
                        }
                    }

                ]]
            });

        });


    </script>

    <div id="p" class="easyui-panel"
               style="width:100%;height:75%;padding:10px;background:#fafafa;"
               data-options="iconCls:'icon-save',closable:true,
        collapsible:false,minimizable:false,maximizable:false,fit:true">

<%--        展示 host的 表格数据 --%>
        <table id="hostDataGird"></table>
    </div>
</body>
</html>
