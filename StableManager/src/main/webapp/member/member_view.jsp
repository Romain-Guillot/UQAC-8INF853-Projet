<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Employés > ${member.id}" />
    </jsp:attribute>


    <jsp:body>
        <h2>Informations</h2>
        <table>
            <tr><th>First name</th>     <td>${member.firstName}</td>        </tr>
            <tr><th>Last name</th>      <td>${member.lastName}</td>         </tr>
            <tr><th>Email</th>          <td>${member.email}</td>            </tr>
            <tr><th>Birth date</th>     <td><s:date name="member.birthDate" format="dd/MM/yyyy"/></td>       </tr>
            <tr><th>Postal address</th> <td>${member.postalAddress}</td>    </tr>
        </table>

        <s:if test="%{user.id == member.id || #hasPrivilege == true}">
            <a href="<s:url action='edit/%{member.id}' namespace="/member"/>" class="waves-effect waves-light btn">
                Modifier
            </a>
            <a href="<s:url action='perform_delete/%{member.id}' namespace="/member"/>" class="waves-effect waves-light btn btn-error">
                Supprimer
            </a>
        </s:if>
        <s:else>
            <sec:authorize access="hasAuthority('WRITE_ALL_PROFILES')">
                <div>
                    Vous avez les droits suffisants pour supprimer ou modifier le profil de cet utilisateur !
                </div>
                <a href="<s:url action='edit/%{member.id}' namespace="/member"/>" class="waves-effect waves-light btn">
                    Modifier
                </a>
                <a href="<s:url action='perform_delete/%{member.id}' namespace="/member"/>" class="waves-effect waves-light btn btn-error">
                    Supprimer
                </a>
            </sec:authorize>
        </s:else>

        <h2>Réservations</h2>
        <t:bookinglist bookings="${bookings}"/>

    </jsp:body>
</t:basepage>