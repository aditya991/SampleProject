<%--
  Created by IntelliJ IDEA.
  User: adityakumar
  Date: 25/7/19
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title></title>
</head>
<body>
    Successfully logged in...
    Name is : <%= request.getAttribute("name")%> & email is <%=request.getAttribute("email")%>
    <br/>
    <form action="${pageContext.request.contextPath}/profile">
        <input type="submit" value="Go to your profile">
    </form>
    <br/>
    <form action="${pageContext.request.contextPath}/logout">
        <input type="submit"  value="logout">
    </form>
</body>
</html>
