<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" media="all">
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/loading/okLoading.js"></script>
    <style>
        .imgs{display: none;}
    </style>
    <!--百度编辑器-->
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
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
                            <select name="xiaoQu" id="community_id">

                                <option value="">---请选择小区---</option>
                                <option value="东湖小区" >东湖小区</option>
                                <option value="金华万府" >金华万府</option>
                            </select>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>投诉人员
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="complainPersonnel" autocomplete="off" placeholder="空制在80个汉字，160个字符以内"
                                   class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>投诉名称
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="complainName" autocomplete="off" placeholder="空制在80个汉字，160个字符以内"
                                   class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>投诉事由
                        </label>
                        <div class="layui-input-block">
                            <input type="text" name="complainDescription" autocomplete="off" placeholder="空制在80个汉字，160个字符以内"
                                   class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class='x-red'>*</span>状态
                        </label>
                        <div class="layui-input-block">
                            <select name="state1" id="stateId">
                                <option value="">---请选择状态---</option>
                                <option value="0" >未读</option>
                                <option value="1" >已读</option>
                            </select>
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
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script>
<script type="text/javascript">
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    UE.getEditor('content',{initialFrameWidth:750,initialFrameHeight:400,});
</script>
<script>
    layui.use(['laydate','element','layer','form'], function(){
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        layer = layui.layer;//弹出层
        form = layui.form();
        laydate = layui.laydate;//日期插件
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
            var xiaoQu=$('#community_id option:selected').val();//所属栏目ID
            var complainPersonnel=$("input[name='complainPersonnel']").val();
            var complainName=$("input[name='complainName']").val();
            var complainDescription=$("input[name='complainDescription']").val();
            var state=$("#stateId option:selected").val();
            let complainEntity = {
                "xiaoQu": xiaoQu,
                "complainPersonnel":complainPersonnel,
                "complainName":complainName,
                "complainDescription":complainDescription,
                "state":state
            };
            if(complainPersonnel==""){
                layer.msg('投诉人不能为空',{icon:5,time:2000});return false;
            }
            if(complainName==""){
                layer.msg('投诉标题不能为空',{icon:5,time:2000});return false;
            }
            if(complainDescription==""){
                layer.msg('投诉描述不能为空',{icon:5,time:2000});return false;
            }
            if(xiaoQu==""){
                layer.msg('所属小区不能为空',{icon:5,time:2000});return false;
            }
            if(state==""){
                layer.msg('状态不能为空',{icon:5,time:2000});return false;
            }
            // var data=data.field;
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/complain_listAdd",
                // data:JSON.stringify(activeEntity),
                data:complainEntity,
                dataType:"json",
                success:function(data){
                    if(data.state = 1){
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