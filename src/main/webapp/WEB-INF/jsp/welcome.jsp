<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sso-login</title>
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
        function regist() {
            location.href="${pageContext.request.contextPath}/toRegist";
        }

        function KeyDown()
        {
            if (event.keyCode == 13)
            {
                event.returnValue=false;
                event.cancel = true;
                loginForm.btnsubmit.click();
            }
        }
    </script>
</head>
<body>
<div class="login-container">
    <h1>登 录</h1>

    <form action="./login" name="loginForm" method="post" id="loginForm">
        <div>
            <input type="text" name="loginname" class="username" placeholder="用户名" autocomplete="off" onkeydown="KeyDown();"/>
        </div>
        <div>
            <input type="password" name="loginpwd" class="password" id="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" onkeydown="KeyDown();"/>
        </div>
        <button  name="btnsubmit" id="submit" type="submit" >登 陆</button>
    </form>

    <a >
        <button type="button"  onclick="regist()" class="register-tis">还有没有账号？</button>
    </a>

</div>

</body>
</html>
