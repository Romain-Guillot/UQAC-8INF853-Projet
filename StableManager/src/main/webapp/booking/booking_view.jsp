<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Locations > ${booking.id}" />
    </jsp:attribute>


    <jsp:body>

        <table>
            <tr><th>#ID</th>            <td>${booking.id}</td>             </tr>
            <tr><th>Member</th>         <td><a href="<s:url action='view/%{booking.member.id}"' namespace="/member"/>">${booking.member}</a></td>         </tr>
            <tr><th>Resource</th>       <td>${booking.resource}</td>       </tr>
            <tr><th>Plage horaire</th>  <td><t:timeslot timeslot="${booking.timeSlot}"/></td>       </tr>
        </table>

<%--        <s:if test="%{user.id == member.id || #hasPrivilege == true}">--%>
<%--            <a href="<s:url action='edit/%{member.id}' namespace="/member"/>" class="waves-effect waves-light btn">--%>
<%--                Modifier--%>
<%--            </a>--%>
<%--            <a href="<s:url action='perform_delete/%{member.id}' namespace="/member"/>" class="waves-effect waves-light btn btn-error">--%>
<%--                Supprimer--%>
<%--            </a>--%>
<%--        </s:if>--%>
<%--        <s:else>--%>
<%--            <sec:authorize access="hasAuthority('WRITE_ALL_PROFILES')">--%>
<%--                <div>--%>
<%--                    Vous avez les droits suffisants pour supprimer ou modifier le profil de cet utilisateur !--%>
<%--                </div>--%>
<%--                <a href="<s:url action='edit/%{member.id}' namespace="/member"/>" class="waves-effect waves-light btn">--%>
<%--                    Modifier--%>
<%--                </a>--%>
<%--                <a href="<s:url action='perform_delete/%{member.id}' namespace="/member"/>" class="waves-effect waves-light btn btn-error">--%>
<%--                    Supprimer--%>
<%--                </a>--%>
<%--            </sec:authorize>--%>
<%--        </s:else>--%>
    </jsp:body>
</t:basepage>