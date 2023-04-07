<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${path}/assets/images/favicon.ico" rel="icon">
    <title>用户注册-EasyWeb</title>
    <link rel="stylesheet" href="${path}/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="${path}/assets/module/admin.css?v=318">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        body {
            background-image: url("${path}/assets/images/bg-login.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            min-height: 100vh;
        }

        body:before {
            content: "";
            background-color: rgba(0, 0, 0, .2);
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }

        .login-wrapper {
            max-width: 420px;
            padding: 20px;
            margin: 0 auto;
            position: relative;
            box-sizing: border-box;
            z-index: 2;
        }

        .login-wrapper > .layui-form {
            padding: 25px 30px;
            background-color: #fff;
            box-shadow: 0 3px 6px -1px rgba(0, 0, 0, 0.19);
            box-sizing: border-box;
            border-radius: 4px;
        }

        .login-wrapper > .layui-form > h2 {
            color: #333;
            font-size: 18px;
            text-align: center;
            margin-bottom: 25px;
        }

        .login-wrapper > .layui-form > .layui-form-item {
            margin-bottom: 25px;
            position: relative;
        }

        .login-wrapper > .layui-form > .layui-form-item:last-child {
            margin-bottom: 0;
        }

        .login-wrapper > .layui-form > .layui-form-item > .layui-input {
            height: 46px;
            line-height: 46px;
            border-radius: 2px !important;
        }

        .login-wrapper .layui-input-icon-group > .layui-input {
            padding-left: 46px;
        }

        .login-wrapper .layui-input-icon-group > .layui-icon {
            width: 46px;
            height: 46px;
            line-height: 46px;
            font-size: 20px;
            color: #909399;
            position: absolute;
            left: 0;
            top: 0;
            text-align: center;
        }

        .login-wrapper > .layui-form > .layui-form-item.login-captcha-group {
            padding-right: 135px;
        }

        .login-wrapper > .layui-form > .layui-form-item.login-captcha-group > .login-captcha {
            height: 46px;
            width: 120px;
            cursor: pointer;
            box-sizing: border-box;
            border: 1px solid #e6e6e6;
            border-radius: 2px !important;
            position: absolute;
            right: 0;
            top: 0;
        }

        .login-wrapper > .layui-form > .layui-form-item > .layui-form-checkbox {
            margin: 0 !important;
            padding-left: 25px;
        }

        .login-wrapper > .layui-form > .layui-form-item > .layui-form-checkbox > .layui-icon {
            width: 15px !important;
            height: 15px !important;
        }

        .login-wrapper > .layui-form .layui-btn-fluid {
            height: 48px;
            line-height: 48px;
            font-size: 16px;
            border-radius: 2px !important;
        }

        .login-wrapper > .layui-form > .layui-form-item.login-oauth-group > a > .layui-icon {
            font-size: 26px;
        }

        .login-copyright {
            color: #eee;
            padding-bottom: 20px;
            text-align: center;
            position: relative;
            z-index: 1;
        }

        @media screen and (min-height: 550px) {
            .login-wrapper {
                margin: -250px auto 0;
                position: absolute;
                top: 50%;
                left: 0;
                right: 0;
                width: 100%;
            }

            .login-copyright {
                position: absolute;
                bottom: 0;
                right: 0;
                left: 0;
            }
        }

        .layui-btn {
            background-color: #5FB878;
            border-color: #5FB878;
        }

        .layui-link {
            color: #5FB878 !important;
        }
    </style>
</head>
<body>
<div class="login-wrapper layui-anim layui-anim-scale layui-hide">
    <form class="layui-form">
        <h2>用户注册</h2>
        <div class="layui-form-item layui-input-icon-group">
            <i class="layui-icon layui-icon-username"></i>
            <input class="layui-input" name="username" placeholder="请输入登录账号" autocomplete="off"
                   lay-verType="tips" lay-verify="required" required/>
        </div>
        <div class="layui-form-item layui-input-icon-group">
            <i class="layui-icon layui-icon-password"></i>
            <input class="layui-input" name="password" placeholder="请输入登录密码" type="password"
                   lay-verType="tips" lay-verify="required" required/>
        </div>
        <div class="layui-form-item">
            <a href="login.jsp" class="layui-link">返回登录</a>
        </div>
        <div class="layui-form-item" style="margin-bottom: 20px;">
            <button class="layui-btn layui-btn-fluid" lay-filter="regSubmit" lay-submit>注册</button>
        </div>
    </form>
</div>
<div class="login-copyright">copyright © 2020 easyweb.vip all rights reserved.</div>

<!-- js部分 -->
<script type="text/javascript" src="${path}/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="${path}/assets/js/common.js?v=318"></script>
<script>
    layui.use(['layer', 'form', 'formX'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        $('.login-wrapper').removeClass('layui-hide');

        /* 表单提交 */
        form.on('submit(regSubmit)', function (obj) {
                                                                    // res是从后端响应的注册结果
            $.post('/user/register',obj.field,function (res) {

                //处理结果
                if(res.code==0){
                    // 这里可以设置弹出时间   默认3秒
                    layer.msg(res.msg,{ icon:1,time:1},function () {
                        //跳转登录页  进行回调
                        window.location.href = '${path}/login.jsp'
                    })
                }else{
                    layer.msg(res.msg,{icon:1})
                }

            },'json')

            return false;
        });
    });
</script>
</body>
</html>
