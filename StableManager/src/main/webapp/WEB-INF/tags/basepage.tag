<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@attribute name="pageTitle" required="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${pageTitle}</title>
    </head>
    <body>
        <div id="page-header">
            <div>
                <p><a href="<s:url action='index' namespace="/"/>">StableManager</a></p>
            </div>
            <p>
                <a href="<s:url action='perform_logout' namespace="/auth"/>">Logout</a> |
                <a href="<s:url action='role/view/%{user.role.name}' namespace="/security"/>">${user.role.name}</a> |
                <a href="<s:url action='view/%{user.id}' namespace="/member"/>">My Account</a> |
            </p>
        </div>

        <div id="page-body">
            <s:if test="hasActionErrors()">
                <div class="errors">
                    <s:actionerror/>
                </div>
            </s:if>
            <jsp:doBody/>
        </div>
        <div id="page-footer">
            StableManager
        </div>
    </body>
</html>