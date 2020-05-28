<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@attribute name="pageTitle" required="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${pageTitle}<</title>
    </head>
    <body>
        <div id="page-header">
            <p>
                <s:set value="user.id" var="userID"/>
                <a href="<s:url action='perform_logout'/>">Logout</a> |
                <a href="<s:url action='member/view/%{#userID}'/>">My Account</a> |
            </p>
        </div>
        <div id="page-body">
            <jsp:doBody/>
        </div>
        <div id="page-footer">
            StableManager
        </div>
    </body>
</html>