<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
        人元添加
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../css/main.css" media="all">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <script type="text/javascript" src="../lib/loading/okLoading.js"></script>
    <style>
        .imgs{display: none;}
    </style>

</head>
<body>

<div class="x-body">
    <form class="layui-form layui-form-pane" action="" id="add">
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">

            <div class="layui-tab-content" >
                <div class="layui-tab-item layui-show">
                    <input type="hidden" name="id" value="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>所属小区
                        </label>
                        <div class="layui-input-block">
                            <select name="zid" id="zid">

                                <option value="0">---请选择---</option>
                                <c:forEach var="community" items="${communityInfo}">
                                    <option value="${community.id}">${community.name}</option>
                                </c:forEach>

<%--                                <option value="1" >东湖小区</option>--%>
<%--                                <option value="2" >金华万府</option>--%>
                            </select>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>车位编号
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="parkNum" autocomplete="off" placeholder="车位编号"
                                   class="layui-input" value="">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>车位名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="parkName" autocomplete="off" placeholder="空制在80个汉字，160个字符以内"
                                   class="layui-input" value="">
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>状态
                        </label>
                        <div class="layui-input-block">
                            <input type="radio" name="state" value="1" title="使用中" >
                            <div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon layui-anim-scaleSpring"></i>
                                <div>使用中</div>
                            </div>
                            <input type="radio" name="state" value="0" title="闲置中" checked="checked">
                            <div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i>
                                <div>闲置中</div>
                            </div>
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
    UE.getEditor('content',{initialFrameWidth:1000,initialFrameHeight:400,});
</script>
<script>
    layui.use(['element','layer','form'], function(){
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层
        form = layui.form()
        okLoading.close($);


        //监听提交
        form.on('submit(add)', function(data){
            var parkName=$("input[name='parkName']").val();
            var parkNum=$("input[name='parkNum']").val();
            var state=$("input[name='state']:checked").val();
            var zid=$('#zid option:selected') .val();//所属栏目ID

            if(zid==""){
                layer.msg('小区名称不能为空',{icon:5,time:2000});return false;
            }
            if(parkName==""){
                layer.msg('车位名称不能为空',{icon:5,time:2000});return false;
            }
            if(parkNum==""){
                layer.msg('车位编号不能为空',{icon:5,time:2000});return false;
            }
            if(state==""){
                layer.msg('请选择状态！',{icon:5,time:2000});return false;
            }
            // var data= data.field;
            var data ={
                "zid":zid,
                "parkName":parkName,
                "state":state,
                "parkNum":parkNum,
            };

            $.ajax({
                type:"post",
                url:"parkInsert",
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
                    }
                    else{
                        layer.msg(data.info,{icon:5,time:2000});return false;
                    }
                }

            });

        });

    })
</script>


<!--栏目缩略图上传-->
<script>
    function upload()
    {
        var formData = new FormData();
        formData.append('images', $('#previewImg')[0].files[0]);
        //console.log(formData);
        layer.msg('图片上传中', {icon: 16});
        $.ajax({
            type:"post",
            processData: false,
            contentType: false,
            url:"xxxx",
            data:formData,
            success:function(data){
                if(data.status == 1){
                    console.log(data.image_name);
                    layer.closeAll('loading');
                    //layer.msg(data.info,{icon:1,time:1000});
                    $("#pimages").attr('src',data.image_name);
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
