<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        车辆添加
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="css/main.css" media="all">
<%--    <script type="text/javascript" src="lib/loading/okLoading.js"></script>--%>
    <style>
        .imgs{display: none;}
        .picture{display: none;}
    </style>

</head>
<body>

<div class="x-body">
    <form class="layui-form layui-form-pane" action="" id="add">
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
            <div class="layui-tab-content" >
                <div class="layui-tab-item layui-show">
                    <input type="hidden" name="id" value="">
                    <div class="layui-form-item" hidden>
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>ID
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="carid" autocomplete="off" placeholder="车辆id"
                                   class="layui-input" value="${carInfo.id}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>所属成员
                        </label>
                        <div class="layui-input-block">
                            <select name="personnel_id" id="personnel_id">
                                <c:forEach var="ownerInfo" items="${ownerInfo}">

                                    <c:if test="${carInfo.oid == ownerInfo.id}">
                                        <option value="${ownerInfo.id}" selected>${ownerInfo.oname}</option>
                                    </c:if>

                                    <c:if test="${carInfo.oid != ownerInfo.id}">
                                        <option value="${ownerInfo.id}">${ownerInfo.oname}</option>
                                    </c:if>
<%--下拉框渲染重复--%>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>车牌号码
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="veh_hphm" autocomplete="off" placeholder="控制在80个汉字，160个字符以内"
                                   class="layui-input" value="${carInfo.carNumber}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>车辆颜色
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="veh_color" autocomplete="off" placeholder="控制在80个汉字，160个字符以内"
                                   class="layui-input" value="${carInfo.color}">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <%--@declare id="link"--%><label for="link" class="layui-form-label">
                            <span class="x-red">*</span>车辆缩略图
                        </label>
                        <div class="layui-input-inline">
                            <div class="site-demo-upbar">
                                <div class=" layui-upload-button" style="border:#FFFFFF ;">

                                    <button type="button" class="layui-btn" id="test1">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>
                                    <input class="layui-upload" type="file" accept="undefined" id="previewImg" name="images" onchange="upload(this,)">
                                </div>

                            </div>
                        </div>

<%--                        <a href="javascript:;" style="" class="layui-btn " id="cancel"><i class="layui-icon">ဂ</i>撤销上传</a>--%>
                    </div>
                    <div class="layui-form-item imgs" id="imgshow" style="display: block;">
                        <label  class="layui-form-label">车辆缩略图展示
                        </label>

                        <img src="${pageContext.request.contextPath}/images/${carInfo.picture}" id="pimages" name="pimages" style="width: 400px;height: 200px;"/>
                        <input id="avatar"   name="image" required="" type="hidden"  value="">
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>描述
                        </label>
                        <div class="layui-input-block">
                            <textarea placeholder="请输入内容" name="desc" class="layui-textarea">${carInfo.remark}</textarea>
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
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script src="js/x-layui.js" charset="utf-8"></script>
<script src="js/jquery.min.js" charset="utf-8"></script>

<script>
    layui.use(['element','layer','form'], function(){
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层
        form = layui.form();
        // okLoading.close($);
        form.render();



        //图片上传接口
        /*layui.upload({
          url: './upload.json' //上传接口
          ,success: function(res){ //上传成功后的回调
              console.log(res);
            $('#LAY_demo_upload').attr('src',res.url);
          }
        });*/


        //监听提交
        form.on('submit(add)', function(data){
            var carid=$("input[name='carid']").val();
            var veh_hphm=$("input[name='veh_hphm']").val();
            var veh_color=$("input[name='veh_color']").val();
            var desc=$("textarea[name='desc']").val();
            var personnel_id=$('#personnel_id option:selected') .val();//所属栏目ID

            if(personnel_id==""){
                layer.msg('所属成员不能为空',{icon:5,time:2000});return false;
            }
            if(veh_hphm==""){
                layer.msg("车牌号码不能为空！",{icon:5,time:2000});return false;
            }
            if(veh_color==""){
                layer.msg("号牌颜色不能为空！",{icon:5,time:2000});return false;
            }
            var data={
                "id":carid,
                "carNumber":veh_hphm,
                "color":veh_color,
                "remark":desc,
                "oid":personnel_id
            }
            $.ajax({
                type:"post",
                url:"./carUpdate",
                data:data,
                dataType:"json",
                success:function(data){
                    if(data.status==200){
                        layer.msg(data.info, {icon: 6,time:2000},function () {
                            window.parent.location.reload();
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                        });
                        return false;

                    }else{
                        layer.msg(data.info,{icon:5,time:2000});return false;
                    }
                }

            });

        });

        form.on('select(aihao)', function(data){
            communidy();
        });
        $(function () {
            communidy();
        });
        //communidy();
        function communidy() {
            var communidy = $("#community_id").val();
            $.ajax({
                url:"xxx",
                type:"post",
                dataType:"json",
                data:{communidy:communidy},
                success:function (data) {
                    var dlen =data.length;
                    var str='';
                    if(dlen>0){
                        for (var i=0;i<dlen;i++){
                            var dt=data[i];
                            str +='<option value="' + dt.id + '">';
                            str +=dt.member_name;
                            str +='</option>';
                        }
                    }else {
                        str +='<option value="">----暂无数据----</option>';
                    }

                    $("#personnel_id").html(str);
                    form.render('select', 'aihao');

                }
            })
        }


    })
</script>
<!--栏目缩略图上传-->
<script>
    function upload(obj,id)
    {
        var formData = new FormData();
        formData.append('images', $('#previewImg')[0].files[0]);
        formData.append('id', id);//将id追加再id中
        //console.log(formData);
        layer.msg('图片上传中', {icon: 16});
        $.ajax({
            type:"post",
            processData: false,
            contentType: false,
            url:"./carImgInsert",
            data:formData,
            success:function(data){
                if(data.status == 200){
                    layer.closeAll('loading');
                    //layer.msg(data.info,{icon:1,time:1000});
                    let src = data.url;
                    $("#pimages").attr('src', src);
                    $("#avatar").val(data.image_name);
                    $(".imgs").show();
                    return false;
                }else{
                    layer.msg(data.info,{icon:2,time:1000});
                }
            }
        });
    }
</script>

</body>
</html>