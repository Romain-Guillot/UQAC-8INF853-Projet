<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Login</h1>

    <s:form action="perform_login">
        <s:textfield name="credential.email" label="Email" value="ystave0@mapy.cz"/>
        <s:textfield name="credential.password" label="Password" value="pass" />
<%--        <s:password name="credential.password" label="Password" />--%>

        <s:submit/>
    </s:form>
</body>
</html>
