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

    /*******添加主持人操作*********/
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

    /******账号禁用操作*******/
    $(function () {

        // 给账号禁用添加点击事件

        $("#hostAccount").click(function () {

            // 你判断 选中的host数据
            var trs = $("#hostDataGird").datagrid("getChecked");
            console.log(trs);

            // 判断  选中了 数据
            if (trs.length >=1){

                // 获取主持人的 hid / statuss
                var hids = "";
                var statuss = "";
                for(var i = 0 ; i < trs.length ; i ++){
                    hids+=trs[i].hid + ",";
                    statuss+=trs[i].status + ",";
                }
                //console.log(hids);
                //console.log(statuss);

                // 把数据发送到服务器
                $.post("host/hostAccountUp.do",
                    {
                        hids:hids,
                        statuss:statuss
                    },function (data) {
                        if(data.success){

                            //提示信息
                            $.messager.alert("提示",data.msg,"info");

                            // datagrid 重写加载数据
                            $("#hostDataGird").datagrid('reload');
                        }else{
                            $.messager.alert("提示",data.msg,"info");
                        }
                    },"json");
            }else{
                $.messager.alert("提示","选择需要设置权限的主持人","info");
            }
        });
    });

    /******编辑host的power********/

    $(function () {
         // 展示数据权限数据的回显
        $("#editPower").click(function () {
              // 拿到选中的数据 判断
             var  trs = $("#hostDataGird").datagrid('getChecked');
            console.log(trs);
             if(trs.length == 1){
                 // 修改power
                 //  判断  host是否有power
                 var hostPower = trs[0].hostPower;

                 // 权限表中需要提交 hostid
                 // 设置hostid提交到 服务器
                 $("#hostid").val(trs[0].hid);

                 if (hostPower){

                     // 如果存在 hpid 修改权限
                     // 如果没有这个hpid  添加权限
                     $("#hpid").val(hostPower.hpid);

                    // 有 进行回显
                    // 拿到控件 设置数据
                     hostPower.hpstar == "1" ? $("#hpstart_yes").radiobutton({checked:true}):$("#hpstart_no").radiobutton({checked:true});
                     //星推荐日期的修改
                     $("#hpstar_begindate").datebox("setValue",jsonToDate(hostPower.hpstartBegindate));
                     $("#hpstar_enddate").datebox("setValue",jsonToDate(hostPower.hpstarEnddate));
                     // 星推荐的时间
                     $("#hpstar_begintime").timespinner("setValue",jsonToTime(hostPower.hpstarBegintime));
                     $("#hpstar_endtime").timespinner("setValue",jsonToTime(hostPower.hpstarEndtime));

                     // 自填订单数据
                     hostPower.hpOrderPower== "1" ? $("#hpOrderPower_yes").radiobutton({checked:true}):
                         $("#hpOrderPower_no").radiobutton({checked:true});

                     // 折扣
                     $("#hp_discount").textbox("setValue",hostPower.hpdiscount);

                     // 折扣日期
                     $("#hp_dis_starttime").datebox("setValue",jsonToDate(hostPower.hpDisStarttime));
                     $("#hp_dis_endtime").datebox("setValue",jsonToDate(hostPower.hpDisEndtime));
                     // 价格
                     $("#hpprice").textbox("setValue",hostPower.hpprice);
                     // 收费
                     $("#hpcosts").textbox("setValue",hostPower.hpcosts);
                 }
                 // 如果没有就直接 编辑power
                // 提交power的数据
                // 展示  power
                $("#hostPowerDialog").dialog('open');
             }else if(trs.length > 1){
                 $.messager.alert("提示", "只能选择一个", "error");
             }else{
                 $.messager.alert("提示", "敢不敢选择一个host", "error");
             }

        });

        // 权限数据的提交
        $("#hostPowerFromSubmit").click(function () {
            // 提交数据
            $("#hostPowerForm").form('submit',
                {
                    url:'hostPower/hostPowerSet.do',
                    success:function (data) {

                        var obj = JSON.parse(data);

                        if(obj.success){
                            //提示信息
                            $.messager.alert("提示",obj.msg,"info");
                            // 清空form表单的数据
                            $("#hostPowerForm").form("clear");
                            // 对话框关闭
                            $("#hostPowerDialog").dialog('close');
                            // datagrid 重写加载数据
                            $("#hostDataGird").datagrid('reload');
                        }else{
                            $.messager.alert("提示",obj.msg,"info");
                        }
                    }
                });
        });

    });


</script>

<script>
    /************声明函数将json类型的时间转换为日期*********/
    //日期转换
    function jsonToDate(obj) {
        return obj.year + "-" + obj.monthValue + "-" + obj.dayOfMonth;
    }
    //时间转换
    function jsonToTime(obj) {
        //return "17:45:00"
        var h = obj.hour < 10 ? ("0" + obj.hour) : obj.hour;
        var m = obj.minute < 10 ? "0" + obj.minute : obj.minute;
        var s = obj.second < 0 ? "0" + obj.second : obj.second;
        return h + ":" + m + ":" + s;
    }
</script>

<%--设置日期框的格式--%>
<script type="text/javascript">
    //设置日期的格式
    function myformatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
    }
    function myparser(s) {
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0], 10);
        var m = parseInt(ss[1], 10);
        var d = parseInt(ss[2], 10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
            return new Date(y, m - 1, d);
        } else {
            return new Date();
        }
    }
</script>

<%--创建主持人权限设置的对话框--%>
<div id="hostPowerDialog" class="easyui-dialog" title="权限设置" style="width:600px;height:550px;"
     data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true,left:100,top:10">
    <%--创建主持人增加的表单--%>
    <form id="hostPowerForm" method="post">
        <%--创建隐藏标签存储要进行数据权限更新的ID--%>
        <input type="hidden" name="hpid" id="hpid" value="">
        <%--创建隐藏标签存储要进行数据权限更新的主持人的ID--%>
        <input type="hidden" name="hostid" id="hostid" value="">
        <%--创建表格--%>
        <table cellpadding="10px" style="margin: auto;margin-top: 20px;">
            <tr>
                <td>是否星推荐:</td>
                <td>
                    <input class="easyui-radiobutton" id="hpstart_yes" name="hpstar" value="1" label="是"
                           labelPosition="after">
                    <input class="easyui-radiobutton" id="hpstart_no" name="hpstar" value="0" label="否"
                           labelPosition="after">
                </td>
            </tr>

            <tr>
                <td>星推荐日期:</td>
                <td>
                    <input id="hpstar_begindate" data-options="formatter:myformatter,parser:myparser"
                           data-options="showSeconds:true" name="hpstartBegindate" type="text" class="easyui-datebox">
                    -
                    <input id="hpstar_enddate" data-options="formatter:myformatter,parser:myparser" name="hpstarEnddate"
                           type="text" class="easyui-datebox">
                </td>
            </tr>
            <tr>
                <td>星推荐时间:</td>
                <td>
                    <input id="hpstar_begintime" name="hpstarBegintime" type="text" data-options="showSeconds:true"
                           class="easyui-timespinner">
                    -
                    <input id="hpstar_endtime" name="hpstarEndtime" type="text" data-options="showSeconds:true"
                           class="easyui-timespinner">
                </td>
            </tr>
            <tr>
                <td>自填订单:</td>
                <td>
                    <input class="easyui-radiobutton" id="hpOrderPower_yes" name="hpOrderPower" value="1" label="是"
                           labelPosition="after">
                    <input class="easyui-radiobutton" id="hpOrderPower_no" name="hpOrderPower" value="0" label="否"
                           labelPosition="after">
                </td>
            </tr>
            <tr>
                <td>折扣:</td>
                <td>
                    <input class="easyui-textbox" id="hp_discount" name="hpdiscount" prompt="请输入折扣" iconWidth="28"
                           style="width:300px;height:34px;padding:10px;">
                </td>
            </tr>
            <tr>
                <td>折扣日期:</td>
                <td>
                    <input id="hp_dis_starttime" data-options="formatter:myformatter,parser:myparser"
                           name="hpDisStarttime" type="text" class="easyui-datebox">
                    -
                    <input id="hp_dis_endtime" data-options="formatter:myformatter,parser:myparser" name="hpDisEndtime"
                           type="text" class="easyui-datebox">
                </td>
            </tr>
            <tr>
                <td>价格:</td>
                <td>
                    <input class="easyui-textbox" id="hpprice" name="hpprice" prompt="请输入价格" iconWidth="28"
                           style="width:300px;height:34px;padding:10px;">
                </td>
            </tr>
            <tr>
            <td>管理费:</td>
            <td>
                <input class="easyui-textbox" id="hpcosts" name="hpcosts" prompt="请输入管理费" iconWidth="28"
                       style="width:300px;height:34px;padding:10px;">
            </td>
        </tr>
            <tr>
                <td colspan="2" align="center">
                    <a href="javascript:void(0)" id="hostPowerFromSubmit" class="easyui-linkbutton c3"
                       style="width:120px">点击完成</a>
                </td>
            </tr>
        </table>
    </form>
</div>

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
            <%--            升序降序 传入 排序规则  在服务器 代码中进行SQL的拼接 --%>
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
    <a id="hostAccount" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-no'">账号切换</a>
    <a id="editPower" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">权限设置</a>
    <a id="batch" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cut'">批量操作</a>
</div>

</body>
</html>
