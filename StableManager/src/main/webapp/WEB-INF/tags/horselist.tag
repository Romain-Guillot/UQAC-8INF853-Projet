<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="horses" required="true" type="java.util.List<com.uqac.stablemanager.horse.model.HorseModel>" %>


<c:choose>
    <c:when test="${horses.isEmpty()}">
        <p class="empty-indicator">Aucun cheval</p>
    </c:when>
    <c:otherwise>
        <ul class="collection">
            <li class="collection-item collection-header row collection-item-content">
                <span class="col s3">ID</span>
                <span class="col s3">Nom</span>
                <span class="col s3">Propriétaire</span>
                <span class="col s3">Date de naissance</span>
            </li>
            <c:forEach items="${horses}" var="horse">
                <li class="collection-item">
                    <a href="<c:url value='/horse/view/${horse.id}"'/>" class="row collection-item-content">
                        <span class="col s3">${horse.id}</span>
                        <span class="col s3">${horse.name}</span>
                        <span class="col s3">${horse.owner}</span>
                        <span class="col s3">${horse.birthDate}</span>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>