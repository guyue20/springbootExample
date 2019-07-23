
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <shiro:authenticated>
    你好<shiro:principal></shiro:principal><a href="${pageContext.request.contextPath}/user/loginout">退出</a>
  </shiro:authenticated>
  <shiro:notAuthenticated>
    <a href="${pageContext.request.contextPath}/common/login.jsp">999999999</a>

  </shiro:notAuthenticated>
  <ul>
    <li>11</li>
    <li>22</li>
    <li>33</li>
    <shiro:hasPermission name="user:add">
      增
    </shiro:hasPermission>
    <shiro:hasPermission name="user:delete">
      删
    </shiro:hasPermission>
    <shiro:hasRole name="super">
      <li>管理员</li>
    </shiro:hasRole>
    <shiro:hasRole name="admin">
      <li>admin</li>
    </shiro:hasRole>
  </ul>
  </body>
</html>
