<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="equipments" required="true" type="java.util.List<com.uqac.stablemanager.equipment.model.EquipmentModel>" %>


<c:choose>
    <c:when test="${equipments.isEmpty()}">
        <p class="empty-indicator">Aucun équipement</p>
    </c:when>
    <c:otherwise>
        <ul class="collection">
            <li class="collection-item collection-header row collection-item-content">
                <span class="col s3">ID</span>
                <span class="col s3">Type</span>
                <span class="col s3">Modèle</span>
                <span class="col s3">Prix</span>
            </li>
            <c:forEach items="${equipments}" var="equipment">
                <li class="collection-item">
                    <a href="<c:url value='/equipment/view/${equipment.id}"'/>" class="row collection-item-content">
                        <span class="col s3">${equipment.id}</span>
                        <span class="col s3">${equipment.type}</span>
                        <span class="col s3">${equipment.model}</span>
                        <span class="col s3">${equipment.price}</span>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>
