<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Chevaux > ${horse.id}" />
    </jsp:attribute>

    <jsp:body>
        <sec:authorize access="hasAuthority('WRITE_ALL_PROFILES')">
            <a href="<s:url action='edit/%{horse.id}' namespace="/horse"/>" class="waves-effect waves-light btn">Modifier</a>
            <a href="<s:url action='perform_delete/%{horse.id}' namespace="/horse"/>" class="waves-effect waves-light btn btn-error">Supprimer</a>
        </sec:authorize>

        <h2>Informations</h2>

        <table>
            <tr><th>ID</th>                 <td>${horse.id}</td>        </tr>
            <tr><th>Nom</th>                <td>${horse.name}</td>         </tr>
            <tr><th>Propriétaire</th>       <td>${horse.owner}</td>            </tr>
            <tr><th>Data de naissance</th>  <td>${horse.birthDate}</td>       </tr>
        </table>
    </jsp:body>
</t:basepage>