<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        添加管理员
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
                            <span class='x-red'>*</span>用户名
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="username" id="usernameCheck" autocomplete="off" placeholder="用户名" onchange="check()"
                                   class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>真实名字
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="realname" autocomplete="off" placeholder="真实名字"
                                   class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>联系方式
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="phone" autocomplete="off" placeholder="联系方式"
                                   class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>邮箱地址
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="email" autocomplete="off" placeholder="邮箱地址"
                                   class="layui-input"  value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>登记日期
                        </label>
                        <div class="layui-input-inline">
                            <input class="layui-input"  name="hiredate" placeholder="登记日期" id="LAY_demorange_s" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>管理员身份
                        </label>
                        <div class="layui-input-block" >
                            <select name="type" id="type" >
                                <c:forEach var="role" items="${rolelist}">
                                    <option value="${role.id}">${role.rolename}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <button class="layui-btn" type="button" lay-filter="add" lay-submit="" id="submitAdmin">
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
    function check(){
        var usernameCheck = document.getElementById('usernameCheck');
        var name = usernameCheck.value;
        $.ajax({
            type: "post",
            url: "usernameCheck?name="+name,
            dataType: "json",
            success: function (reg) {
                if (reg.code == 200) {
                    layer.msg(reg.info, {icon: 5, time: 2000});
                    $("#submitAdmin").attr("disabled",true)
                    $("#submitAdmin").attr("class",'layui-btn layui-btn-danger')
                    $(".layui-input").attr("disabled",true)
                    $("#usernameCheck").attr("disabled",false)
                    return false;
                } else {
                    layer.msg(reg.info, {icon: 6, time: 2000});
                    $("#submitAdmin").attr("disabled",false)
                    $("#submitAdmin").attr("class",'layui-btn')
                    $(".layui-input").attr("disabled",false)
                    return false;
                }
            }
        })
    }
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

        //监听提交
        form.on('submit(add)', function (data) {
            var username = $("input[name='username']").val();
            var realname = $("input[name='realname']").val();
            var phone = $("input[name='phone']").val();
            var email = $("input[name='email']").val();
            var hiredate = $("input[name='hiredate']").val().replaceAll("-","/");
            var type = $("select[name='type']").val();
            if (username == "") {
                layer.msg('用户名不能为空', {icon: 5, time: 2000});
                return false;
            }
            if (realname == "") {
                layer.msg('真实名字不能为空', {icon: 5, time: 2000});
                return false;
            }
            var dt = {
                "username": username
                , "realname": realname
                , "phone": phone
                , "email": email
                , "hiredate": hiredate
                , "type": type
            };
            $.ajax({
                type: "post",
                url: "adminInsert",
                data: dt,
                dataType: "json",
                success: function (reg) {
                    //alert(1);
                    if (reg.code == 200) {
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
    })
</script>
</body>
</html>

