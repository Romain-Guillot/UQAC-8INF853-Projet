<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Basic Struts 2 Application - Welcome</title>
  </head>
  <body>
    <h1>StableManager</h1>
    <p><a href="<s:url action='login'/>">Login</a></p>
    <p><a href="<s:url action='perform_logout'/>">Logout</a></p>
  </body>
</html>
