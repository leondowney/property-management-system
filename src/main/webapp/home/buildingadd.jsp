<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        添加栋数
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
                    <input type="hidden" name="id" value="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>所属小区
                        </label>
                        <div class="layui-input-block">
                            <select name="cid" id="cid">
                            <c:forEach var="comInfo" items="${communityInfo}">
                                <option value="${comInfo.id}">${comInfo.name}</option>
                            </c:forEach>
                        </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>栋数编号
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="buildingNum" autocomplete="off" placeholder="请输入编号"
                                   class="layui-input" required="" lay-verify="required" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>栋数名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="buildings_name" autocomplete="off" placeholder="空制在80个汉字，160个字符以内"
                                   class="layui-input" required="" lay-verify="required" value="">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>总户数
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="households" autocomplete="off" placeholder="请输入数字"
                                   class="layui-input" required="number" lay-verify="number" value="">
                        </div>
                    </div>
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>描述
                        </label>
                        <div class="layui-input-block">
                            <textarea placeholder="请输入内容" name="desc" class="layui-textarea"></textarea>
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
    layui.use(['element', 'layer', 'form'], function () {
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层
        form = layui.form();
        // okLoading.close($);

        //监听提交
        form.on('submit(add)', function (data) {
            var cid = $("select[name='cid']").val();
            var buildingNum = $("input[name='buildingNum']").val();
            var buildings_name = $("input[name='buildings_name']").val();
            var households = $("input[name='households']").val();
            var desc = $("textarea[name='desc']").val();
            if (buildings_name == "") {
                layer.msg('栋数名称不能为空！', {icon: 5, time: 2000});
                return false;
            }
            if (households == "") {
                layer.msg('总户数不能为空！', {icon: 5, time: 2000});
                return false;
            }
            var data = {
                "cid": cid
                , "buildingNum": buildingNum
                // , "community": community_name
                , "bname": buildings_name
                , "roomNum": households
                , "buildingDesc": desc

            };
            $.ajax({
                type: "post",
                url: "./buildingInsert",
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