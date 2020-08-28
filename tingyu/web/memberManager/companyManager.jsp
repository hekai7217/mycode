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

    /******初始化 companyDataGird*****/
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
            toolbar:'#companyToolbar',
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

    /*****添加公司的操作********/
    $(function () {
        // 点击 添加按钮  展示 添加公司的dialog
        $("#addCompany").click(function () {

            //展示 添加公司的编辑dialog
            // open 展示 dialog
            $("#addCompanyDialog").dialog('open');
        });
        // 添加公司的表单提交数据
        $("#btnAddCompany").click(function () {
            //拿到表单
            $("#addCompanyForm").form(
                'submit',{
                    url:'company/addCompany.do', // 表单体数据的位置
                    success:function (data) {  // 成提交的函数
                        // 返回的data 是json字符串
                        var d = JSON.parse(data);
                        if(d.success){
                            // 添加成功的信息提示
                            $.messager.alert("提示",d.msg,"info")
                            // datagrid 重新加载数据
                            $("#companyDataGird").datagrid('reload');
                            // 把表单的数据重置(回到之前的状态) (清空 表单中没有数据)
                            $("#addCompanyForm").form('reset');
                        }else{
                            $.messager.alert("提示",d.msg,"error")
                        }
                        // 关闭 dialog
                        $("#addCompanyDialog").dialog('close');
                    }
                }
            );
        });
    });

    /********编辑公司*******/
    $(function () {

        /**
         *  1. 点击编辑公司按钮
         *
         *  2. 弹出 编辑公司的对话框(数据回显)
         *
         *  3. 提交数据
         *
         */

        $("#editCompany").click(function () {

            // 判断选中的数据
            // getChecked  选中 datagrid 的 数据
            var trs = $("#companyDataGird").datagrid('getChecked');

            if(trs.length == 1){ // 可以编辑
                // 在表单中进行回显
                var companyObj = trs[0];
                console.log(companyObj)
                /**
                 *   $("#editCompany").form('load',obj )
                 *   拿到表单 填充数据
                 *   obj 可以给对象可以给 json字符串,可以给 url(远程获取数据)
                 *  左边是表单的name   右边是表单填充的值
                 *   name:'name2',
                 *   email:'mymail@gmail.com',
                 *   subject:'subject2',
                 *   message:'message2'
                 *
                 *   如果表单的name和对象的属性名称一致 可以直接给对象
                 *   左边的表单的name可以直接省略
                 *
                 *   修改的时候 一定要给id 公司的id
                 */
                $("#editCompanyForm").form('load',companyObj);
                // 展示编辑修改的对话框
                $("#editCompanyDialog").dialog('open');
            }else if(trs.length >1) {
                $.messager.alert("提示","只能选中一个公司进行编辑");
            }else{
                $.messager.alert("提示","必须选中一个公司进行编辑");
            }
        });

        // 编辑完毕后 提交数据
        $("#btneditCompany").click(function () {

            $("#editCompanyForm").form('submit',{
                url:'company/companyUp.do',
                success:function (data) {

                    // 解析json字符串
                   var d =  JSON.parse(data);
                    if(d.success){
                        // 提示
                        $.messager.alert("提示",d.msg,"info");
                        // 重写加载 datagrid
                        $("#companyDataGird").datagrid('reload');

                    }else{
                        $.messager.alert("提示",d.msg,"error");
                    }
                    // 关闭对话框
                    $("#editCompanyDialog").dialog('close');
                }
            });

        });
    });

    /******查询公司的策划师*******/
    $(function () {
        // 公司的策划师 dataGrid 的初始化
        $("#plannerDatagrid").datagrid({
            url:'planner/plannerInfo.do',
            rownumbers:true , // 展示行 编号
            // pagination:true,
            fitColumns: true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,6],
            columns: [[
                {field:'nname',title:'策划师姓名',width:80},
                {field:'nphone',title:'电话',width:80},
                {field:'addtime',title:'开始时间',width:80,
                    formatter:function (value,row,index) {
                        return value.year + "-" + value.monthValue+"-" + value.dayOfMonth;
                    }
                },
                {field:'ordernumber',title:'订单数据',width:80},
                {field:'status',title:'状态',width:80,
                formatter:function (value,row,index) {
                    return value == "1" ? "正常":"禁用";
                }}
            ]]
        })

        // 点击策划师按钮 展示 datagrid的数据
        $("#planList").click(function () {

            // 选中一个公司
            var trs = $("#companyDataGird").datagrid('getChecked');
            if (trs.length == 1){
               // 通过cid 查询 策划师
               // 拿到cid
               var  cid = trs[0].cid;

               // datagrid 发送请求查询数据
              $("#plannerDatagrid").datagrid('load', {cid:cid});

              // 展示数据
                $("#planDialog").dialog('open');

            }else if(trs.length == 1){

            }else if (trs.length >1){
                $.messager.alert("提示","只能选中一个公司进行进行查询策划师列表");
            }else{
                $.messager.alert("提示","必须选中一个公司才可以查询策划师");
            }
        });
    });

    /*******账号的状态的修改********/
    $(function () {

        $("#accountCompanyUp").click(function () {
            //拿到选中的数据
            var trs = $("#companyDataGird").datagrid('getChecked');
            // 把公司数据的id 和 status 发送到服务器 进行更新操作
            if (trs.length >=1){
                // 把多个公司的 cid 和状态进行拼接
                var cids = "";
                var statuss = "";
                for(var i = 0 ;i < trs.length; i ++){
                    cids +=trs[i].cid+",";
                    statuss +=trs[i].status+",";
                }
                // ajax放数据
                $.post("company/accountCompanyUp.do",
                    {cids:cids,statuss:statuss},
                    function (data) {

                       //判断是否成功
                        if (data.success){
                            //更新成功
                            //提示
                            $.messager.alert("提示",data.msg,"info");
                            // datagrid 重新加载
                            $("#companyDataGird").datagrid('reload');
                        }else{
                            //更新失败
                            $.messager.alert("提示",data.msg,"info");
                        }
                    },"json");
            }else{
                $.messager.alert("提示","必须选中一个公司数据","info");
            }

        });


    });

</script>

<%--展示公司的 策划师的对话框对话框--%>

<div id="planDialog" class="easyui-dialog" title="公司的策划师列表" style="width:480px;height:240px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <%-- 展示公司的策划师表格数据 --%>
    <table id="plannerDatagrid"></table>
</div>

<div>
    <%--    编辑公司的对话框 --%>
    <div id="editCompanyDialog" class="easyui-dialog" title="添加公司信息" style="width:500px;height:400px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

        <%--        添加编辑的表单 --%>
        <form id="editCompanyForm" method="post">

<%--            隐藏标签域  设置cid --%>
            <input type="hidden" name="cid">

            <div style="text-align: center;margin-top: 20px">
                <input name="cname" class="easyui-textbox" prompt="公司名称" style="width:180px">
            </div>

            <div style="text-align: center;margin-top: 20px">
                <input name="cpwd" class="easyui-textbox" prompt="公司的密码" style="width:180px">
            </div>

            <div style="text-align: center;margin-top: 20px">
                <input name="cphone" class="easyui-textbox" prompt="公司的手机号码" style="width:180px">
            </div>

            <div style="text-align: center;margin-top: 20px">
                <input name="ceo" class="easyui-textbox" prompt="公司的ceo" style="width:180px">
            </div>

            <div style="text-align: center;margin-top: 20px">
                <input name="cmail" class="easyui-textbox" prompt="公司的邮箱" style="width:180px">
            </div>

            <div style="text-align: center;margin-top: 20px">
                <a id="btneditCompany" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">添加完成</a>
            </div>
        </form>
    </div>
</div>
<div>
<%--    添加公司的对话框 --%>
    <div id="addCompanyDialog" class="easyui-dialog" title="添加公司信息" style="width:500px;height:400px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

<%--        添加公司的表单 --%>
        <form id="addCompanyForm" method="post">
            <div style="text-align: center;margin-top: 20px">
                <input name="cname" class="easyui-textbox" prompt="公司名称" style="width:180px">
            </div>

            <div style="text-align: center;margin-top: 20px">
                <input name="cpwd" class="easyui-textbox" prompt="公司的密码" style="width:180px">
            </div>

            <div style="text-align: center;margin-top: 20px">
                <input name="cphone" class="easyui-textbox" prompt="公司的手机号码" style="width:180px">
            </div>

            <div style="text-align: center;margin-top: 20px">
                <input name="ceo" class="easyui-textbox" prompt="公司的ceo" style="width:180px">
            </div>

            <div style="text-align: center;margin-top: 20px">
                <input name="cmail" class="easyui-textbox" prompt="公司的邮箱" style="width:180px">
            </div>

            <div style="text-align: center;margin-top: 20px">
                <a id="btnAddCompany" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">添加完成</a>
            </div>
        </form>
    </div>
</div>

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

<div id="companyToolbar">
    <a id="addCompany" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加公司</a>
    <a id="editCompany" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑公司</a>
    <a id="planList" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">策划师列表</a>
    <a id="accountCompanyUp" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cut'">账号状态切换</a>
</div>

</body>
</html>
