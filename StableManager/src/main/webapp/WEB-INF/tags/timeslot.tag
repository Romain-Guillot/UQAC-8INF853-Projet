<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="timeslot" required="true" type="com.uqac.stablemanager.utils.TimeSlot" %>

<fmt:formatDate value="${timeslot.begin}" pattern="yyyy-MM-dd HH:mm:ss" />
 -
<fmt:formatDate value="${timeslot.end}" pattern="yyyy-MM-dd HH:mm:ss" />

