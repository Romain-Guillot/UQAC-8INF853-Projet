<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="horses" required="true" type="java.util.List<com.uqac.stablemanager.horse.model.HorseModel>" %>


<ul>
    <c:forEach items="${horses}" var="horse">
        <li>
            <p><a href="<c:url value='/horse/view/${horse.id}"'/>">${horse.name}</a> (${horse.birthDate})</p>
        </li>
    </c:forEach>
</ul>