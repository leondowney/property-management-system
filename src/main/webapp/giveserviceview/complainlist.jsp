<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        报修管理
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/loading/okLoading.js"></script>
</head>
<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>服务管理</cite></a>
              <a><cite>报修列表</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form x-center" action="" style="width:800px">
        <div class="layui-form-pane" style="margin-top: 15px;">
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="text" name="complainName"  placeholder="投诉人" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline" style="width:80px">
                    <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                </div>
            </div>
        </div>
    </form>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()">
            <i class="layui-icon">&#xe640;</i>批量删除
        </button>
        <button class="layui-btn" onclick="complain_add('添加','${pageContext.request.contextPath}/giveserviceview/complainadd.jsp','1000','600')">
            <i class="layui-icon">&#xe608;</i>添加
        </button>
        <span class="x-right" style="line-height:40px">共有数据：<span class="layui-badge">${count}</span> 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <input type="checkbox" name="" value="">
            </th>
            <th>
                ID
            </th>
            <th>
                所属小区
            </th>
            <th>
                投诉人员
            </th>
            <th>
                投诉名称
            </th>
            <th>
                投诉事由
            </th>
            <th>
                创建时间
            </th>
            <th>
                状态
            </th>
            <th>
                操作
            </th>
        </tr>
        </thead>
        <c:forEach items="${complainEntityList}" var="complain">
            <tbody>
            <tr>
                <td>
                    <input type="checkbox" value="${complain.id}" name="boxId">
                </td>
                <td>
                        ${complain.id}
                </td>
                <td>
                        ${complain.xiaoQu}
                </td>
                <td >
                        ${complain.complainPersonnel}
                </td>
                <td >
                        ${complain.complainName}
                </td>
                <td >
                        ${complain.complainDescription}
                </td>
                <td >
                        <fmt:formatDate value="${complain.creatTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <c:if test="${complain.state==1}">
                    <td>
                        已读
                    </td>
                </c:if>
                <c:if test="${complain.state==0}">
                    <td>
                        未读
                    </td>
                </c:if>
                <td class="td-manage">
                    <a title="编辑" href="javascript:;" onclick="complain_edit('编辑','${pageContext.request.contextPath}/complain_selectId',800,600,${complain.id})"
                       class="ml-5">
                        <i class="layui-icon">&#xe642;</i>
                    </a>
                    <a title="删除" href="javascript:;" onclick="complain_del(this,${complain.id})"
                       style="text-decoration:none">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>

    <div id="page"></div>
</div>
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script>
<script>
    layui.use(['laydate','element','laypage','layer'], function(){
        $ = layui.jquery;//jquery
        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层
        okLoading.close($);
        //以上模块根据需要引入


        var start = {
            min: laydate.now()
            ,max: '2099-06-16 23:59:59'
            ,istoday: false
            ,choose: function(datas){
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            min: laydate.now()
            ,max: '2099-06-16 23:59:59'
            ,istoday: false
            ,choose: function(datas){
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

        document.getElementById('LAY_demorange_s').onclick = function(){
            start.elem = this;
            laydate(start);
        }
        document.getElementById('LAY_demorange_e').onclick = function(){
            end.elem = this
            laydate(end);
        }
    });

    //批量删除提交
    function delAll(obj, id) {
        //捉到所有被选中的，发异步进行删除
        var cid = $("input[name='boxId']:checked");
        if (cid.size() == 0) {
            alert("你还没有选中项无法删除！");
        } else {
            layer.confirm('确认要删除吗？', {icon: 3, title: '提示信息'}, function (index) {
                var ids = "";
                cid.each(function () {
                    ids = ids + $(this).val() + ",";
                });
                console.log(ids)
                $.ajax({
                    type: "delete",
                    data: JSON.stringify(ids),
                    // data:ids,
                    url: "${pageContext.request.contextPath}/complain_deleteMore",
                    dataType: "json",
                    success: function (data) {
                        console.log(data);
                        if (data.state == 1) {
                            //发异步删除数据
                            $(obj).parents("tr").remove();
                            layer.msg(data.info, {icon: 6, time: 1000});
                            setTimeout(function () {
                                window.location.reload();
                            }, 1000);
                            return false;
                        } else {
                            layer.msg(data.info, {icon: 5, time: 1000});
                            return false;
                        }
                    }
                });
                //发异步删除数据
                $(obj).parents("tr").remove();
                layer.msg('已删除!', {icon: 1, time: 1000});
            });
        }
    }

    function question_show (argument) {
        layer.msg('可以跳到前台具体问题页面',{icon:1,time:1000});
    }
    /*添加*/
    function complain_add(title,url,w,h){
        x_admin_show(title,url,w,h);
    }
    //编辑
    function complain_edit (title,url,w,h,id) {
        url =url+"?id="+id;
        x_admin_show(title,url,w,h);
    }

    /*删除*/
    function complain_del(obj,id){
        layer.confirm('确认要删除吗？',{icon:3,title:'提示信息'},function(index){
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/complain_listDeleteOne",
                data:{id:id},
                dataType:"json",
                success:function(data){
                    console.log(data);
                    if(data.status==1){
                        //发异步删除数据
                        $(obj).parents("tr").remove();
                        layer.msg(data.info,{icon:6,time:1000});
                        setTimeout(function(){
                            window.location.reload();
                        },1000);return false;
                    } else{
                        layer.msg(data.info,{icon:5,time:1000});return false;
                    }
                }
            });
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
</script>

</body>
</html>