<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sso-regist</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/logo.png" />
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/jquery.min.js"></script>
    <!--背景图片自动更换-->
    <script src="js/supersized.3.2.7.min.js"></script>
    <script src="js/supersized-init.js"></script>
    <!--表单验证-->
    <script src="js/jquery.validate.min.js?var1.14.0"></script>
    <script>
        function returnLogin() {
            location.href="${pageContext.request.contextPath}/index";
        }
    </script>
</head>
<body>
<div class="register-container">
    <h1>注 册</h1>

    <form action="./regist" method="post" id="registerForm">
        <div>
            <input type="text" name="accountname" class="accountname" placeholder="您的用户名" autocomplete="off"/>
        </div>
        <div>
            <input type="text" name="loginname" class="loginname" placeholder="您的账号名称" autocomplete="off"/>
        </div>
        <div>
            <input type="password" name="loginpwd" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
        </div>
        <div>
            <input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
        </div>
       <%-- <div>
            <input type="text" name="phonenumber" class="phone_number" placeholder="输入手机号码" autocomplete="off" id="number"/>
        </div>--%>
        <div>
            <input type="email" name="email" class="email" placeholder="输入邮箱地址" oncontextmenu="return false" onpaste="return false" />
        </div>

        <button id="submit" type="submit">注 册</button>
    </form>
    <a >
        <button type="button" onclick="returnLogin()" class="register-tis">已经有账号？</button>
    </a>

</div>
</body>
</html>
