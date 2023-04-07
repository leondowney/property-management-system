<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        管理员信息编辑
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/main.css" media="all">
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
              <a><cite>管理员列表</cite></a>
              <a><cite>编辑管理员信息</cite></a>
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
                    <input type="hidden" name="id" value="${admin.id}">
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>用户名
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="username" autocomplete="off" placeholder="用户名" disabled="disabled"
                                   class="layui-input" lay-verify="required" value="${admin.username}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>真实名字
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="realname" autocomplete="off" placeholder=""
                                   class="layui-input" lay-verify="required" value="${admin.realname}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>联系方式
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="phone" autocomplete="off" placeholder=""
                                   class="layui-input" lay-verify="required" value="${admin.phone}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>邮箱地址
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="email" autocomplete="off" placeholder=""
                                   class="layui-input" lay-verify="required" value="${admin.email}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>登记日期
                        </label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="hiredate" placeholder="登记时间" id="LAY_demorange_s" value="<fmt:formatDate value="${admin.hiredate}" pattern="yyyy-MM-dd"></fmt:formatDate> ">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>管理员身份
                        </label>
                        <div class="layui-input-block">
                            <select name="type" id="type"  lay-filter="test" >
                                <option value="${admin.type}">${admin.rolename}</option>
                                <c:forEach var="role" items="${rolelist}">
                                    <c:if test="${role.rolename != admin.rolename }">
                                        <option value="${role.id}">${role.rolename}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>权限状态
                        </label>
                        <div class="layui-input-block" >
                            <input type="radio" name="available" value="1" title="允许访问" <c:if test="${admin.available==1}">checked="checked"</c:if>>
                            <div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon layui-anim-scaleSpring"></i>
                                <div>允许访问</div>
                            </div>
                            <input type="radio" name="available" value="0" title="禁止访问" <c:if test="${admin.available==0}">checked="checked"</c:if>>
                            <div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i>
                                <div>禁止访问</div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-form-item">
                            <label class="layui-form-label">
                                <span class='x-red'>*</span>重置密码
                            </label>
                            <div class="layui-input-block" >
                                <input type="radio" name="password" value="123456" title="是" checked="checked">
                                <div class="layui-unselect layui-form-radio layui-form-radioed"><i
                                        class="layui-anim layui-icon layui-anim-scaleSpring"></i>
                                    <div>是</div>
                                </div>
                                <input type="radio" name="password" value="${admin.password}" title="否" >
                                <div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i>
                                    <div>否</div>
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                        <button class="layui-btn" type="button" lay-filter="add" lay-submit="">
                            保存
                        </button>
                    </div>
                    <!--</form>-->
                    <%--                    <div style="height:100px;"></div>--%>
                </div>
            </div>

        </div>
    </form>
</div>
<script src="../lib/layui/layui.js" charset="utf-8"></script>
<script src="../js/x-layui.js" charset="utf-8"></script>
<script type="text/javascript">
    // UE.getEditor('content', {initialFrameWidth: 700, initialFrameHeight: 200,});
</script>
<script>
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
            }
        };
        document.getElementById('LAY_demorange_s').onclick = function () {
            start.elem = this;
            laydate(start);
        };

        form.on('submit(add)', function (data) {
            var id = $("input[name='id']").val();
            var realname = $("input[name='realname']").val();
            var phone = $("input[name='phone']").val();
            var email = $("input[name='email']").val();
            var hiredate = $("input[name='hiredate']").val().replaceAll("-","/");
            var type= $("select[name='type']").val();
            var available= $("input[name='available']:checked").val();
            var password= $("input[name='password']:checked").val();
            var dt = {
                "id": id,
                "realname": realname,
                "phone": phone,
                "email": email,
                "hiredate": hiredate,
                "type": type,
                "available": available,
                "password": password,
            };
            console.log(dt)
            $.ajax({
                type: "post",
                url: "updateAdmin",
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

