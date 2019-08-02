<%--
  Created by IntelliJ IDEA.
  User: adityakumar
  Date: 31/07/19
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Welcome to your profile....
    Name : <%=request.getAttribute("name")%> session id is <%=request.getSession().getId()%> & token id is <%=request.getSession().getAttribute("token")%>
    <form action="logout">
        <input type="submit" value="Log Out">
    </form>
</body>
</html>
