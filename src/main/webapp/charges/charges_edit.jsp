<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        编辑收费项目
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
              <a><cite>收费项目管理</cite></a>
              <a><cite>编辑收费项目</cite></a>
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
                    <input type="hidden" name="id" value="${chargeOne[0].id}">
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>小区名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="communituName" autocomplete="off" placeholder="小区名称"
                                   class="layui-input" lay-verify="required" value="${chargeOne[0].communituName}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>收费项目编号
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="chargeNum" autocomplete="off" placeholder=""
                                   class="layui-input" required="" lay-verify="required" value="${chargeOne[0].chargeNum}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>收费项目名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="chargeName" autocomplete="off" placeholder=""
                                   class="layui-input" lay-verify="required" value="${chargeOne[0].chargeName}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>登记日期
                        </label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="createDateTime" placeholder="购买时间" id="LAY_demorange_s" value="<fmt:formatDate value="${chargeOne[0].createDateTime}" pattern="yyyy-MM-dd"></fmt:formatDate> ">
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
    layui.use(['element', 'layer', 'form','laydate'], function () {
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层
        form = layui.form();
        laydate = layui.laydate;//日期插件
        var start = {
            max: '2099-06-16 23:59:59'
            , istoday: false
            , choose: function (datas) {
                //end.min = datas; //开始日选好后，重置结束日的最小日期
                //end.start = datas //将结束日的初始值设定为开始日
            }
        };
        document.getElementById('LAY_demorange_s').onclick = function () {
            start.elem = this;
            laydate(start);
        };
        //监听提交
        form.on('submit(add)', function (data) {
            var id = $("input[name='id']").val();
            var communituName = $("input[name='communituName']").val();
            var chargeNum = $("input[name='chargeNum']").val();
            var chargeName = $("input[name='chargeName']").val();
            var createDateTime = $("input[name='createDateTime']").val().replaceAll("-","/");
            if (communituName == "") {
                layer.msg('小区名称不能为空', {icon: 5, time: 2000});
                return false;
            }
            if (chargeNum == "") {
                layer.msg('收费项目编号不能为空', {icon: 5, time: 2000});
                return false;
            }
            if (chargeName == "") {
                layer.msg('收费项目不能为空', {icon: 5, time: 2000});
                return false;
            }

            var dt = {
                "id": id,
                "communituName": communituName,
                "chargeNum": chargeNum,
                "chargeName": chargeName,
                "createDateTime": createDateTime,
            };

            console.log(dt);
            $.ajax({
                type: "post",
                url: "updateCharge",
                data: dt,
                dataType: "json",
                success: function (res) {
                    //alert(1);
                    if (res.code == 200) {
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