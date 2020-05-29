<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

  <t:pagedescription title="Dashboard">
    Gérer votre écurie
  </t:pagedescription>

  <h2>Employés</h2>
  <ul>
    <li><a href="<s:url action='list' namespace="/member"/>">Voir tous</a></li>
    <s:iterator value="roles">
      <s:url action="list"  var="url"
             includeParams="get" namespace="/member">
        <s:param name="selectedRole">${name}</s:param>
      </s:url>
      <li><a href="${url}" >${name}</a></li>
    </s:iterator>
    <li><a href="<s:url action='create' namespace="/member"/>">Création</a></li>
  </ul>

  <h2>Sécurité</h2>
  <ul>
    <li><a href="<s:url action='role/list' namespace="/security"/>">Rôles</a></li>
    <li><a href="">Créer un nouveau rôle</a></li>
  </ul>

  <h2>Ressources</h2>
  <ul>
    <li><a href="">Voir tous</a></li>
    <li><a href="">Les chevaux</a></li>
    <li><a href="">Le matériel</a></li>
    <li><a href="">Les corrals</a></li>
  </ul>

  <h2>Actualités de l'écurie</h2>
  <ul>
    <li><a href="">Voir tous</a></li>
    <li><a href="">Actualités</a></li>
    <li><a href="">Activités</a></li>
  </ul>

  <h2>Autres</h2>
  <ul>
    <li><a href="">Cours</a></li>
    <li><a href="">Locations</a></li>
  </ul>
</t:basepage>
