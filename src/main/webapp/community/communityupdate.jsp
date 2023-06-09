<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        小区管理
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
    <script src="../ueditor/ueditor.config.js"></script>
    <script src="../ueditor/ueditor.all.min.js"></script>
    <script src="../ueditor/lang/zh-cn/zh-cn.js"></script>

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
              <a><cite>小区管理</cite></a>
              <a><cite>编辑小区</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon"
                                                                        style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <form class="layui-form layui-form-pane" action="" id="add">
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
            <!--<ul class="layui-tab-title">
                <li class="layui-this">基本信息</li>
                <li>SEO信息</li>
                <li>栏目内容</li>
            </ul>-->

            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <!--<form class="layui-form layui-form-pane" action="" id="add">-->
                    <input type="hidden" name="id" value="">
<%--                    <div class="layui-form-item">--%>
<%--                        <label class="layui-form-label">--%>
<%--                            <span class='x-red'>*</span>小区管理员--%>
<%--                        </label>--%>
<%--                        <div class="layui-input-block">--%>
<%--                            <select name="user_id" id="user_id">--%>

<%--                                <option value="4">admin</option>--%>
<%--                                <option value="5">admin</option>--%>
<%--                                <option value="6">admin</option>--%>
<%--                                <option value="7">admin</option>--%>
<%--                                <option value="8">ADMIN</option>--%>
<%--                            </select>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <div class="layui-form-item" hidden="hidden">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>小区id
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="cid" readonly="readonly" autocomplete="off" placeholder="小区id"
                                   class="layui-input" value="${comm.id}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>小区编号
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="communityNum" autocomplete="off" placeholder="小区编号"
                                   class="layui-input" lay-verify="required" value="${comm.communityNum}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>小区名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="community_name" autocomplete="off" placeholder="小区名称"
                                   class="layui-input" required="" lay-verify="required" value="${comm.name}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>坐落地址
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="cell_address" autocomplete="off" placeholder="坐落地址"
                                   class="layui-input" lay-verify="required" value="${comm.address}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>占地面积
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="area_covered" autocomplete="off" placeholder="占地面积"
                                   class="layui-input" lay-verify="required" value="${comm.communityArea}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>开发商名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="developers" autocomplete="off" placeholder="开发商名称"
                                   class="layui-input" lay-verify="required" value="${comm.developerName}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>物业公司名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="property" autocomplete="off" placeholder="物业公司名称"
                                   class="layui-input" lay-verify="required" value="${comm.propertyName}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>绿化率
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="afforestation_rate" autocomplete="off" placeholder="绿化率"
                                   class="layui-input" lay-verify="required" value="${comm.greeningRate}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>总栋数
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="tung" autocomplete="off" placeholder="总栋数"
                                   class="layui-input" lay-verify="required" value="${comm.buildingNum}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>总户数
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="household" autocomplete="off" placeholder="总户数"
                                   class="layui-input" lay-verify="required" value="${comm.roomNum}">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>状态
                        </label>
                        <div class="layui-input-block" id="IsPurchased">
                            <input type="radio" name="status" value="1" title="显示" <c:if test="${comm.state==1}">checked="checked"</c:if>>
                            <div class="layui-unselect layui-form-radio layui-form-radioed"><i
                                    class="layui-anim layui-icon layui-anim-scaleSpring"></i>
                                <div>显示</div>
                            </div>
                            <input type="radio" name="status" value="0" title="隐藏" <c:if test="${comm.state==0}">checked="checked"</c:if>>
                            <div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i>
                                <div>隐藏</div>
                            </div>
                        </div>
                    </div>
<%--                                        <div class="layui-input-inline">--%>
<%--                                            <input class="layui-input" name="hiredate" placeholder="开始日" id="LAY_demorange_s">--%>
<%--                                        </div>--%>
                    <div class="layui-form-item">
                        <label for="link" class="layui-form-label">
                            <span class="x-red">*</span>小区缩略图
                        </label>
                        <div class="layui-input-inline">
                            <div class="site-demo-upbar">
                                <div class=" layui-upload-button" style="border:#FFFFFF ;">
                                    <button type="button" class="layui-btn" id="test1">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>
                                    <input class="layui-upload" type="file" accept="undefined" id="previewImg"
                                           name="images" onchange="upload(this,)">
                                </div>

                            </div>
                        </div>

                        <!--<a href="javascript:;" style="" class="layui-btn " id="cancel"><i class="layui-icon">ဂ</i>撤销上传</a>-->
                    </div>
                    <div class="layui-form-item imgs" id="imgshow" style="display: block;">
                        <label class="layui-form-label">小区缩略图展示
                        </label>
                        <img src="${pageContext.request.contextPath}/images/${comm.img}" id="pimages" name="pimages" style="width: 400px;height: 200px;"/>

<%--                        <input id="avatar" name="image" required="" type="hidden" value="">--%>
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
            var cid = $("input[name='cid']").val();
            var communityNum = $("input[name='communityNum']").val();
            var community_name = $("input[name='community_name']").val();
            var developers = $("input[name='developers']").val();
            var cell_address = $("input[name='cell_address']").val();
            var area_covered = $("input[name='area_covered']").val();
            var property = $("input[name='property']").val();
            var afforestation_rate = $("input[name='afforestation_rate']").val();
            var tung = $("input[name='tung']").val();
            var household = $("input[name='household']").val();
            var status = $("input[name='status']:checked").val();
            if (community_name == "") {
                layer.msg('小区名称不能为空', {icon: 5, time: 2000});
                return false;
            }
            if (developers == "") {
                layer.msg('小区开发商不能为空', {icon: 5, time: 2000});
                return false;
            }
            if (property == "") {
                layer.msg('物业公司不能为空', {icon: 5, time: 2000});
                return false;
            }

            var data = {
                "id": cid,
                "communityNum": communityNum,
                "name": community_name,
                "developerName": developers,
                "address": cell_address,
                "communityArea": area_covered,
                "propertyName": property,
                "greeningRate": afforestation_rate,
                "buildingNum": tung,
                "roomNum": household,
                "state": status,
            };

            $.ajax({
                type: "post",
                url: "updateCommunity",
                data: data,
                dataType: "json",
                success: function (data) {
                    //alert(1);
                    if (data.status == 200) {
                        layer.msg(data.info, {icon: 6, time: 2000}, function () {
                            window.parent.location.reload();
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                            layer.closeAll();
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


<!--栏目缩略图上传-->
<script>
    function upload(obj, id) {
        var formData = new FormData();
        formData.append('img', $('#previewImg')[0].files[0]);
        // formData.append('id', id);
        layer.msg('图片上传中', {icon: 16});
        $.ajax({
            type: "post",
            processData: false,
            contentType: false,
            // url:"/xiyuan/community/upload.html",
            url: "communityImgInsert",
            data: formData,
            success: function (data) {
                if (data.status == 200) {
                    //console.log(data.image_name);
                    layer.closeAll('loading');
                    //layer.msg(data.info,{icon:1,time:1000});
                    let src = data.url;
                    $("#pimages").attr('src', src);
                    $("#avatar").val(data.image_name);
                    $(".imgs").show();
                    return false;
                } else {
                    layer.msg(data.info, {icon: 2, time: 1000});
                }
            }
        });
    }

</script>

</body>
</html>
