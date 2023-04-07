<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        添加资产信息
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/main.css" media="all">
    <%--    <script type="text/javascript" src="lib/loading/okLoading.js"></script>--%>

    <style>
        .imgs {
            display: none;
        }
    </style>
</head>
<body>
<div class="x-body">
    <form class="layui-form layui-form-pane" action="" id="add">
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <input type="hidden" name="id" value=""/>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>所属小区
                        </label>
                        <div class="layui-input-block">
                            <select name="conmunityName" id="conmunityName">
                                <c:forEach var="comInfo" items="${communities}">
                                    <option value="${comInfo.name}">${comInfo.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>资产编码
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="deciveNum" autocomplete="off" placeholder="资产编码"
                                   class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>资产名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="deciveName" autocomplete="off" placeholder="资产名称"
                                   class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>品牌
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="brand" autocomplete="off" placeholder=""
                                   class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>价格
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="price" autocomplete="off" placeholder="价格"
                                   class="layui-input"  value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>数量
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="number" autocomplete="off" placeholder=""
                                   class="layui-input" lay-verify="required|number" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>购买时间
                        </label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="purchaseDate" placeholder="购买时间" id="LAY_demorange_s" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>使用年限
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="durationDate" autocomplete="off" placeholder=""
                                   class="layui-input"  value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>入库时间
                        </label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="createTime" placeholder="入库时间" id="LAY_demorange_ss" value="">
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
<script src="../js/jquery.min.js" charset="utf-8"></script>
<!--<script src="/static/xiyuan/js/jquery.js" charset="utf-8"></script>-->
<script>

    layui.use(['laydate', 'element', 'layer', 'form'], function () {
        $ = layui.jquery;//jquery

        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层

        form = layui.form();
        // okLoading.close($);
        // form.render();

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
        document.getElementById('LAY_demorange_ss').onclick = function () {
            start.elem = this;
            laydate(start);
        };

        //监听提交
        form.on('submit(add)', function (data) {
            var conmunityName = $("select[name='conmunityName']").val();
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
                layer.msg('资产名称不能为空', {icon: 5, time: 2000});
                return false;
            }
            var dt = {
                "conmunityName": conmunityName
                , "deciveNum": deciveNum
                , "deciveName": deciveName
                , "brand": brand
                , "price": price
                , "number": number
                , "purchaseDate": purchaseDate
                , "durationService": durationService
                , "createTime": createTime
            };
            $.ajax({
                type: "post",
                url: "deciveInsert",
                data: dt,
                dataType: "json",
                success: function (reg) {
                    //alert(1);
                    if (reg.status == 200) {
                        layer.msg(reg.info, {icon: 6, time: 2000}, function () {
                            window.parent.location.reload();
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                        });
                        return false;

                    } else {
                        layer.msg(reg.info, {icon: 5, time: 2000});
                        return false;
                    }
                }

            });

        });
        // form.on('select(aihao)', function (data) {
        //     communidy();
        // });
        // $(function () {
        //     communidy();
        // });
    })
</script>
</body>
</html>
