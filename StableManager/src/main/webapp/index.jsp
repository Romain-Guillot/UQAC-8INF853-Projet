<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Dashboard">
            Gérer votre écurie
        </t:pagedescription>
    </jsp:attribute>


    <jsp:body>
        <h2>Membres</h2>
        <ul class="list-actions">
            <li><a href="<s:url action='list' namespace="/member"/>">Voir tous</a></li>
            <li><a href="<s:url action='create' namespace="/member"/>">Création</a></li>
        </ul>

        <h2>Sécurité</h2>
        <ul class="list-actions">
            <li><a href="<s:url action='role/list' namespace="/security"/>">Tous les rôles</a></li>
            <s:iterator value="roles" var="role">
                <li><a href="<s:url action="view/%{name}" namespace="/security/role"/>">${role.name}</a></li>
            </s:iterator>
            <li><a href="<s:url action='role/edition' namespace="/security"/>">Créer un nouveau rôle</a></li>
        </ul>

        <h2>Ressources</h2>
        <ul class="list-actions">
            <li><a href="<s:url action='list' namespace="/horse"/>">Les chevaux</a></li>
            <li><a href="<s:url action='list' namespace="/equipment"/>">Le matériel</a></li>
            <li><a href="">Les corrals</a></li>
        </ul>

        <h2>Cours et locations</h2>
        <ul class="list-actions">
            <li><a href="<s:url action='list' namespace="/booking"/>">Locations</a></li>
            <li><a href="">Cours <span class="badge">Bientôt</span></a></li>
        </ul>

        <h2>Actualités de l'écurie</h2>
        <ul class="list-actions">
            <li><a href="">Actualités <span class="badge">Bientôt</span></a></li>
            <li><a href="">Activités <span class="badge">Bientôt</span></a></li>
        </ul>
    </jsp:body>
</t:basepage>
