<%--
  Created by IntelliJ IDEA.
  User: ob
  Date: 5/26/20
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Login</h1>

    <s:form action="perform_login">
        <s:textfield name="credential.email" label="Email" />
        <s:textfield name="credential.password" label="Password" />
        <s:submit/>
    </s:form>
</body>
</html>
