<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        资产管理
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/main.css" media="all">
    <%--    <script type="text/javascript" src="lib/loading/okLoading.js"></script>--%>
    <!--百度编辑器-->
    <script src="ueditor/ueditor.config.js"></script>
    <script src="ueditor/ueditor.all.min.js"></script>
    <script src="ueditor/lang/zh-cn/zh-cn.js"></script>

</head>
<style>
    .imgs {
        display: none;
    }

    .picture {
        display: none;
    }
</style>
<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>资产管理</cite></a>
              <a><cite>编辑资产</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon"
                                                                        style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form layui-form-pane" action="" id="add">
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <!--<form class="layui-form layui-form-pane" action="" id="add">-->
                    <input type="hidden" name="id" value="${device.id}">
<%--                    <div class="layui-form-item" hidden="hidden">--%>
<%--                        <label class="layui-form-label">--%>
<%--                            <span class='x-red'>*</span>id--%>
<%--                        </label>--%>
<%--                        <div class="layui-input-block">--%>
<%--                            <input type="text" name="cid" readonly="readonly" autocomplete="off" placeholder="id"--%>
<%--                                   class="layui-input" value="${device.id}">--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>小区名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="conmunityName" autocomplete="off" placeholder="小区名称"
                                   class="layui-input" lay-verify="required" value="${device.conmunityName}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>资产编号
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="deciveNum" autocomplete="off" placeholder="资产编号"
                                   class="layui-input" required="" lay-verify="required" value="${device.deciveNum}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>资产名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="deciveName" autocomplete="off" placeholder="资产名称"
                                   class="layui-input" lay-verify="required" value="${device.deciveName}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>品牌
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="brand" autocomplete="off" placeholder="品牌"
                                   class="layui-input" lay-verify="required" value="${device.brand}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>价格
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="price" autocomplete="off" placeholder="价格"
                                   class="layui-input" lay-verify="required" value="${device.price}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>数量
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="number" autocomplete="off" placeholder="数量"
                                   class="layui-input" lay-verify="required" value="${device.number}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>购买日期
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="purchaseDate" autocomplete="off" placeholder="购买日期"
                                   class="layui-input" lay-verify="required" value="<fmt:formatDate value="${device.purchaseDate}" pattern="yyyy-MM-dd"></fmt:formatDate>">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>服务年限
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="durationService" autocomplete="off" placeholder="服务年限"
                                   class="layui-input" lay-verify="required" value="${device.durationService}" >
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>录入日期
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="createTime" autocomplete="off" placeholder="录入日期"
                                   class="layui-input" lay-verify="required" value="<fmt:formatDate value="${device.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate> ">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <button class="layui-btn" type="button" lay-filter="add" lay-submit="">
                            保存
                        </button>
                    </div>
                    <!--</form>-->
                    <div style="height:100px;"></div>
                </div>


            </div>

        </div>
    </form>
</div>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script src="../js/x-layui.js" charset="utf-8"></script>
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    UE.getEditor('content', {initialFrameWidth: 700, initialFrameHeight: 200,});
</script>
<script>
    // document.getElementById('LAY_demorange_s').onclick = function () {
    //     start.elem = this;
    //     laydate(start);
    // }
    layui.use(['element', 'layer', 'form'], function () {
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层
        form = layui.form();
        // okLoading.close($);

        //监听提交
        form.on('submit(add)', function (data) {
            var id = $("input[name='id']").val();
            var conmunityName = $("input[name='conmunityName']").val();
            var deciveNum = $("input[name='deciveNum']").val();
            var deciveName = $("input[name='deciveName']").val();
            var brand = $("input[name='brand']").val();
            var price = $("input[name='price']").val();
            var number = $("input[name='number']").val();
            var purchaseDate = $("input[name='purchaseDate']").val().replaceAll("-","/");
            var durationService = $("input[name='durationService']").val();
            var createTime = $("input[name='createTime']").val().replaceAll("-","/");
            if (conmunityName == "") {
                layer.msg('小区名称不能为空', {icon: 5, time: 2000});
                return false;
            }
            if (deciveName == "") {
                layer.msg('设备名称不能为空', {icon: 5, time: 2000});
                return false;
            }
            if (purchaseDate == "") {
                layer.msg('购买日期不能为空', {icon: 5, time: 2000});
                return false;
            }

            var dt = {
                "id": id,
                "conmunityName": conmunityName,
                "deciveNum": deciveNum,
                "deciveName": deciveName,
                "brand": brand,
                "price": price,
                "number": number,
                "purchaseDate": purchaseDate,
                "durationService": durationService,
                "createTime": createTime,
            };

            console.log(dt);
            $.ajax({
                type: "post",
                url: "updateDecive",
                data: dt,
                dataType: "json",
                success: function (res) {
                    //alert(1);
                    if (res.status == 200) {
                        layer.msg(res.info, {icon: 6, time: 2000}, function () {
                            window.parent.location.reload();
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                            layer.closeAll();
                        });
                        return false;

                    } else {
                        layer.msg(res.info, {icon: 5, time: 2000});
                        return false;
                    }
                }

            });

        });

    })
</script>
</body>
</html>