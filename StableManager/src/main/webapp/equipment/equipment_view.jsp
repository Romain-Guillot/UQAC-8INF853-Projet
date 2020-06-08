<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Matériel > ${equipment.id}"/>
    </jsp:attribute>

    <jsp:body>
        <div>
            <a href="<s:url action='edit/%{equipment.id}' namespace="/equipment"/>" class="waves-effect waves-light btn">Modifier</a>
            <a href="<s:url action='perform_delete/%{equipment.id}' namespace="/equipment"/>" class="waves-effect waves-light btn btn-error">Supprimer</a>
        </div>

        <h2>Informations</h2>

        <table>
            <tr><th>ID</th>                 <td>${equipment.id}</td>        </tr>
            <tr><th>Type</th>                <td>${equipment.type}</td>         </tr>
            <tr><th>Modèle</th>       <td>${equipment.model}</td>            </tr>
            <tr><th>Propriétaire</th>  <td>${owner}</td>       </tr>
        </table>

    </jsp:body>
</t:basepage>