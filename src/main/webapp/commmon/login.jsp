
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="${pageContext.request.contextPath}/user/loginuser">
   用户名: <input type="text" name="userName"></br>
    密码:<input type="password" name="password"></br>
    <input type="submit" value="点击">
  </form>
  </body>
</html>
