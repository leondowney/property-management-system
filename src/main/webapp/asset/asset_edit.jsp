<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        明细编辑
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
<%--    <script src="../ueditor/ueditor.config.js"></script>--%>
<%--    <script src="../ueditor/ueditor.all.min.js"></script>--%>
<%--    <script src="../ueditor/lang/zh-cn/zh-cn.js"></script>--%>

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
              <a><cite>收费明细列表</cite></a>
              <a><cite>编辑明细</cite></a>
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
                    <input type="hidden" name="id" value="${asset.id}">
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>小区名称
                        </label>
                        <div class="layui-input-block">
                            <select name="communityName" id="communityName"  lay-filter="test" >
                                <option value="${asset.communityName}">${asset.communityName}</option>
                                <c:forEach var="charge" items="${charges}">
                                    <c:if test="${asset.communityName != charge.communituName }">
                                        <option value="${charge.communituName}">${charge.communituName}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>收费项目名称
                        </label>
                        <div class="layui-input-block">
                            <select name="rateName" id="rateName" >
                                <option value="${asset.rateName}">${asset.rateName}</option>
<%--                                <c:forEach var="ch" items="${cha}">--%>
<%--                                    <option value="${ch.chargeName}">${ch.chargeName}</option>--%>
<%--                                </c:forEach>--%>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>业主
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="owner" autocomplete="off" placeholder="业主"
                                   class="layui-input" lay-verify="required" value="${asset.owner}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>应付金额
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="amount" autocomplete="off" placeholder=""
                                   class="layui-input" lay-verify="required" value="${asset.amount}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>实付金额
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="figure" autocomplete="off" placeholder="实付金额"
                                   class="layui-input" lay-verify="required" value="${asset.figure}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>缴费日期
                        </label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="figureDate" placeholder="缴费日期" id="LAY_demorange_s" value="<fmt:formatDate value="${asset.figureDate}" pattern="yyyy-MM-dd"></fmt:formatDate>">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>实付金额
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="remark" autocomplete="off" placeholder="备注"
                                   class="layui-input" lay-verify="required" value="${asset.remark}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>登记日期
                        </label>
                        <div class="layui-input-inline">
                            <input class="layui-input" name="createDate" placeholder="登记时间" id="LAY_demorange_c" value="<fmt:formatDate value="${asset.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate> ">
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
        document.getElementById('LAY_demorange_c').onclick = function () {
            start.elem = this;
            laydate(start);
        };

        form.on('select(test)', function(data) {
            var cName = $("select[name='communityName']").val();
            $.ajax({
                type: "post",
                url: "selectRate?cName="+cName,
                dataType: "json",
                success: function (res) {
                    $("#rateName").children().remove()
                   console.log(res)
                    for (let i = 0; i <res.length ; i++) {
                      let ele  =   $('<option></option>').text(res[i].chargeName).attr("value",res[i].chargeName)
                        $('#rateName').append(ele)
                    }
                    form.render("select")
                }
            });
        });
        // $("").blur(function () {
          //     var cName = $("select[name='communityName']").val();
          //      console.log((cName))
          //     // $.ajax({
          //     //     type: "post",
          //     //     url: "selectRate",
          //     //     data: cName,
          //     //     dataType: "json",
          //     //     success: function (res){
          //     //         if(res.code==200){
          //     //             console.log("数据回显成功")
          //     //         }
          //     //     }
          //     // })
          // })
        form.on('submit(add)', function (data) {
            var id = $("input[name='id']").val();
            var communityName = $("select[name='communityName']").val();
            var rateName = $("select[name='rateName']").val();
            var owner = $("input[name='owner']").val();
            var amount = $("input[name='amount']").val();
            var figure = $("input[name='figure']").val();
            var figureDate = $("input[name='figureDate']").val().replaceAll("-","/");
            var remark = $("input[name='remark']").val();
            var createDate = $("input[name='createDate']").val().replaceAll("-","/");
            if (communityName == "") {
                layer.msg('小区名称不能为空', {icon: 5, time: 2000});
                return false;
            }
            if (rateName == "") {
                layer.msg('收费项目不能为空', {icon: 5, time: 2000});
                return false;
            }
            if (owner == "") {
                layer.msg('业主不能为空', {icon: 5, time: 2000});
                return false;
            }

            var dt = {
                "id": id,
                "communityName": communityName,
                "rateName": rateName,
                "owner": owner,
                "amount": amount,
                "figure": figure,
                "figureDate": figureDate,
                "remark": remark,
                "createDate": createDate,
            };

            $.ajax({
                type: "post",
                url: "updateAsset",
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
