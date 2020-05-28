<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@attribute name="title" required="true"%>

<div id="page-description">
    <h1>${title}</h1>
    <jsp:doBody/>
</div>