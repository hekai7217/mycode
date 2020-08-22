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

<%--
   引入 easyui:
     1. 导入 easyui主题  themes 文件
     2  导入 js   easyui/ jquery

     3. 页面引入 easy的样式


 --%>

<script>

    $(function(){
        $("#dd").datebox({
            formatter:function (date) {  // 格式化指定的日期
                var y = date.getFullYear();
                var m = date.getMonth()+1;
                var d = date.getDate();
                return y+"-"+m+"-"+d;  // 返回格式化的日期
            },
            parser:function (s) {   // 把原有的时间转成 datebox 认识的时间 才可以修改新的时间
                var t = Date.parse(s);
                if (!isNaN(t)){
                    return new Date(t);
                } else {
                    return new Date();
                }
            }
        })
    })

</script>

<select id="cc" class="easyui-combobox" data-options="panelHeight:'auto'" name="dept" style="width:200px;">
    <option value="aa">aitem1</option>
    <option>bitem2</option>
    <option>bitem3</option>
    <option>ditem4</option>
    <option>eitem5</option>
</select>

<br>
<br>
<br>
<br>
<input id="dd" type="text" class="easyui-datebox" required="required"
data-options="currentText:'放假日',closeText:'close',editable:false">

</body>
</html>
