<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="bookings" required="true" type="java.util.List<com.uqac.stablemanager.booking.model.BookingModel>" %>


<c:choose>
    <c:when test="${bookings.isEmpty()}">
        <p class="empty-indicator">Aucune réservation</p>
    </c:when>
    <c:otherwise>
        <ul class="collection">
            <li class="collection-item collection-header row collection-item-content">
                <span class="col s1">#ID</span>
                <span class="col s4">Membre</span>
                <span class="col s4">Ressource</span>
                <span class="col s3">Plage horaire</span>
            </li>
            <c:forEach items="${bookings}" var="booking">
                <li class="collection-item">
                    <a href="<c:url value='/booking/view/${booking.id}"'/>" class="row collection-item-content">
                        <span class="col s1">${booking.id}</span>
                        <span class="col s4">${booking.member}</span>
                        <span class="col s4">${booking.resource}</span>
                        <span class="col s3"><t:timeslot timeslot="${booking.timeSlot}"/></span>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>