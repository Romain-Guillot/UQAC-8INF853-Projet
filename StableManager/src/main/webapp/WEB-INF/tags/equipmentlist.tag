<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="equipments" required="true" type="java.util.List<com.uqac.stablemanager.equipment.model.EquipmentModel>" %>


<ul>
    <c:forEach items="${equipments}" var="equipment">
        <li>
            <p><a href="<c:url value='/equipment/view/${equipment.id}"'/>">${equipment.model}</a> (${equipment.type})</p>
        </li>
    </c:forEach>
</ul>