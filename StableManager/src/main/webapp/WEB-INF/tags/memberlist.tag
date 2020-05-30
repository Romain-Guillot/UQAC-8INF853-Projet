<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="members" required="true" type="java.util.List<com.uqac.stablemanager.member.model.MemberModel>" %>


<ul>
    <c:forEach items="${members}" var="member">
        <li>
            <a href="<c:url value='/member/view/${member.id}"'/>">
                <p>${member.firstName} ${member.lastName}</p>
                <p>${member.accountType} - ${member.role.name}</p>
            </a>
        </li>
    </c:forEach>
</ul>