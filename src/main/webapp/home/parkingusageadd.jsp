<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        车位使用添加
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/main.css" media="all">
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
                    <input type="hidden" name="id" value="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>所属小区
                        </label>
                        <div class="layui-input-block">
                            <select name="cid" id="cid">
                                <option value="">请选择<option>
                                <c:forEach var="comInfo" items="${communityInfo}">

                                <option value="${comInfo.id}">${comInfo.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>车位编号
                        </label>
                        <div class="layui-input-block">
                            <select name="aid" id="aid">
                                <c:forEach var="ParkInfo" items="${dbParkInfo}">
                                    <option value="${ParkInfo.id}">${ParkInfo.parkNum}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>车牌号码
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="carNumber" autocomplete="off" placeholder="请输入车牌号码"
                                   class="layui-input" required="" lay-verify="required" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>车辆持有人
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="ownerName" autocomplete="off" placeholder="空制在80个汉字，160个字符以内"
                                   class="layui-input" required="" lay-verify="required" value="">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>联系方式
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="telephone" autocomplete="off" placeholder="请输入数字"
                                   class="layui-input" required="" lay-verify="required" value="">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>使用性质
                        </label>
                        <div class="layui-input-block">
                            <input type="radio" name="useType" value="1" title="租" >
                            <div class="layui-unselect layui-form-radio "><i class="layui-anim layui-icon "></i>
                                <div>租</div>
                            </div>
                            <input type="radio" name="useType" value="0" title="售" >
                            <div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i>
                                <div>售</div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>总费用(￥)
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="money" autocomplete="off" placeholder="请输入数字"
                                   class="layui-input" required="" lay-verify="required" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>开始时间
                        </label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="startTime" placeholder="开始时间" id="LAY_demorange_s"
                                   value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>截至时间
                        </label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="endTime" placeholder="开始时间" id="LAY_demorange_o" value="">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <button class="layui-btn" type="button" lay-filter="add" lay-submit="">
                            保存
                        </button>
                    </div>
                    <div style="height:100px;"></div>
                </div>

            </div>

        </div>
    </form>
</div>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script src="../js/x-layui.js" charset="utf-8"></script>
<script>
    layui.use(['laydate', 'element', 'layer', 'form'], function () {
        $ = layui.jquery;//jquery

        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层

        form = layui.form();

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
        document.getElementById('LAY_demorange_o').onclick = function () {
            start.elem = this;
            laydate(start);
        };


        //监听提交
        form.on('submit(add)', function (data) {
            var cid = $("select[name='cid']").val();
            var aid = $("select[name='aid']").val();
            var carNumber = $("input[name='carNumber']").val();
            var ownerName = $("input[name='ownerName']").val();
            var telephone = $("input[name='telephone']").val();
            var useType = $("input[name='useType']:checked").val();
            var money = $("input[name='money']").val();
            var startTime = $("input[name='startTime']").val().replaceAll("-", "/");
            var endTime = $("input[name='endTime']").val().replaceAll("-", "/");

            if (carNumber == "") {
                layer.msg('车牌号不能为空！', {icon: 5, time: 2000});
                return false;
            }
            if (ownerName == "") {
                layer.msg('车辆所有人不能为空！', {icon: 5, time: 2000});
                return false;
            }
            if (telephone == "") {
                layer.msg('联系电话不能为空！', {icon: 5, time: 2000});
                return false;
            }
            if (ownerName == "") {
                layer.msg('车辆所有人不能为空！', {icon: 5, time: 2000});
                return false;
            }
            if (startTime == "") {
                layer.msg('开始时间不能为空！', {icon: 5, time: 2000});
                return false;
            }
            if (endTime == "") {
                layer.msg('截止时间不能为空！', {icon: 5, time: 2000});
                return false;
            }
            var data = {
                "cid": cid,
                "aid": aid,
                "carNumber": carNumber,
                "ownerName": ownerName,
                "telephone": telephone,
                "useType": useType,
                "money": money,
                "startTime": startTime,
                "endTime": endTime,
            };
            console.log(data.useType)
            $.ajax({
                type: "post",
                url: "parkingusageInsert",
                data: data,
                dataType: "json",
                success: function (data) {
                    if (data.status == 200) {
                        layer.msg(data.info, {icon: 6, time: 2000}, function () {
                            window.parent.location.reload();
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                        });
                        return false;
                    } else {
                        layer.msg(data.info, {icon: 5, time: 2000});
                        return false;
                    }
                }
            });
        });


    })
</script>

</body>
</html>
