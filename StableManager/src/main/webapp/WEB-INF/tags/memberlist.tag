<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="members" required="true" type="java.util.List<com.uqac.stablemanager.member.model.MemberModel>" %>


<c:choose>
    <c:when test="${members.isEmpty()}">
        <p class="empty-indicator">Aucun membre</p>
    </c:when>
    <c:otherwise>
        <ul class="collection">
            <li class="collection-item collection-header row collection-item-content">
                <span class="col s6">Prénom Nom</span>
                <span class="col s3">Type de compte</span>
                <span class="col s3">Rôle</span>
            </li>
            <c:forEach items="${members}" var="member">
                <li class="collection-item">
                    <a href="<c:url value='/member/view/${member.id}"'/>" class="row collection-item-content">
                        <span class="col s6">${member.firstName} ${member.lastName}</span>
                        <span class="col s3">${member.accountType}</span>
                        <span class="col s3">${member.role.name}</span>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>