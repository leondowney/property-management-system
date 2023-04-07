<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        宠物添加
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="css/main.css" media="all">
    <script type="text/javascript" src="lib/loading/okLoading.js"></script>
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
<%--                    <div class="layui-form-item">--%>
<%--                        <label class="layui-form-label">--%>
<%--                            <span class='x-red'>*</span>所属小区--%>
<%--                        </label>--%>
<%--                        <div class="layui-input-block">--%>
<%--                            <select name="community_id" id="community_id" lay-filter="aihao">--%>

<%--                                <option value="0">顶级栏目</option>--%>
<%--                                <option value="1" >东湖小区</option>--%>
<%--                                <option value="2" >金华万府</option>--%>
<%--                            </select>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>所属成员
                        </label>
                        <div class="layui-input-block">
                            <select name="oid" id="oid">
                                <c:forEach var="ownerInfo" items="${ownerInfo}">
                                    <option value="${ownerInfo.id}">${ownerInfo.oname}</option>
                                </c:forEach>
<%--                                <option value="1">人名</option>--%>
                            </select>
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>宠物名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="name" autocomplete="off" placeholder="控制在80个汉字，160个字符以内"
                                   class="layui-input" value="">
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>宠物颜色
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="color" autocomplete="off" placeholder="控制在80个汉字，160个字符以内"
                                   class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>收养时间
                        </label>

                        <div class="layui-input-inline">
                            <input class="layui-input" name="adoptTime" placeholder="收养时间" id="LAY_demorange_s" value="">
                        </div>

                    </div>

                    <div class="layui-form-item">
                        <%--@declare id="link"--%><label for="link" class="layui-form-label">
                            <span class="x-red">*</span>宠物缩略图
                        </label>
                        <div class="layui-input-inline">
                            <div class="site-demo-upbar">
                                <div class=" layui-upload-button" style="border:#FFFFFF ;">

                                    <button type="button" class="layui-btn" id="test1">
                                        <i class="layui-icon">&#xe67c;</i>上传图片
                                    </button>
                                    <input class="layui-upload" type="file" accept="undefined" id="previewImg" name="images" onchange="petupload(this,)">
                                </div>

                            </div>
                        </div>

<%--                        <a href="javascript:;" style="" class="layui-btn " id="cancel">
                                <i class="layui-icon">ဂ</i>撤销上传</a>--%>
                    </div>

                    <div class="layui-form-item imgs" id="imgshow">
                        <label  class="layui-form-label">宠物缩略图展示
                        </label>

                        <img src="" id="pimages" name="pimages" style="width: 400px;height: 200px;"/>
                        <input id="avatar"   name="image" required="" type="hidden"  value="">
                    </div>


                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>备注
                        </label>
                        <div class="layui-input-block">
                            <textarea placeholder="请输入内容" name="remark" class="layui-textarea"></textarea>
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

<script>
    layui.use(['laydate','element','layer','form'], function(){
        $ = layui.jquery;//jquery
        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层
        form = layui.form();
        okLoading.close($);

        form.render();
        var start = {
            min: laydate.now()
            ,max: '2099-06-16 23:59:59'
            ,istoday: false
            ,choose: function(datas){
                //end.min = datas; //开始日选好后，重置结束日的最小日期
                //end.start = datas //将结束日的初始值设定为开始日
            }
        };

        document.getElementById('LAY_demorange_s').onclick = function(){
            start.elem = this;
            laydate(start);
        };

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
            var name=$("input[name='name']").val();
            var color=$("input[name='color']").val();
            var image=$("input[name='image']").val();
            var adoptTime=$("input[name='adoptTime']").val();
            // var community_id=$('#community_id option:selected') .val();//所属栏目ID
            var oid=$('#oid option:selected') .val();//所属栏目ID
            var remark = $("textarea[name='remark']").val();

            // if(community_id==""){
            //     layer.msg('所属小区不能为空',{icon:5,time:2000});return false;
            // }
            if(oid==""){
                layer.msg('所属成员不能为空',{icon:5,time:2000});return false;
            }
            if(name==""){
                layer.msg("宠物名称不能为空！",{icon:5,time:2000});return false;
            }
            // if(color==""){
            //     layer.msg("宠物颜色不能为空！",{icon:5,time:2000});return false;
            // }
            // if(image==""){
            //     layer.msg("宠物照片不能为空！",{icon:5,time:2000});return false;
            // }
            if(adoptTime==""){
                layer.msg("收养时间不能为空！",{icon:5,time:2000});return false;
            }
            var data = {
                "name": name,
                "oid": oid,
                // "picture": picture,
                "color": color,
                "remark": remark,
                "adoptTime": adoptTime,
            }

            $.ajax({
                type:"post",
                url:"./petInsert",
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

                    $("#oid").html(str);
                    form.render('select', 'aihao');

                }
            })
        }

    })
</script>

<!--栏目缩略图上传-->
<%--<script>--%>
<%--    function petupload(obj,id){--%>
<%--        var formData = new FormData();--%>
<%--        formData.append('images', $('#previewImg')[0].files[0]);--%>
<%--        formData.append('id', id);--%>
<%--        layer.msg('图片上传中', {icon: 16});--%>
<%--        $.ajax({--%>
<%--            type:"post",--%>
<%--            processData: false,--%>
<%--            contentType: false,--%>
<%--            url:"xxx",--%>
<%--            data:formData,--%>
<%--            success:function(data){--%>
<%--                if(data.status == 1){--%>
<%--                    layer.closeAll('loading');--%>
<%--                    //layer.msg(data.info,{icon:1,time:1000});--%>
<%--                    $("#pimages").attr('src',data.image_name);--%>
<%--                    $("#avatar").val(data.image_name);--%>
<%--                    $(".imgs").show();--%>
<%--                    return false;--%>
<%--                }else{--%>
<%--                    layer.msg(data.info,{icon:2,time:1000});--%>
<%--                }--%>
<%--            }--%>
<%--        });--%>
<%--    }--%>
<%--</script>--%>

<!--栏目缩略图上传-->
<script>
    function petupload(obj, id) {
        var formData = new FormData();
        formData.append('images', $('#previewImg')[0].files[0]);
        formData.append('id', id);//将id追加再id中
        console.log(formData);
        layer.msg('图片上传中', {icon: 16});
        $.ajax({
            type: "post",
            processData: false,
            contentType: false,
            url: "./petImgInsert",
            data: formData,
            success: function (data) {
                if (data.status == 200) {
                    console.log(data.image_name);
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
