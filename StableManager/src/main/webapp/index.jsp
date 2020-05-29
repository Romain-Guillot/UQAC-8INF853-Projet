<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

  <t:pagedescription title="Dashboard">
    Gérer votre écurie
  </t:pagedescription>

  <h2>Employés</h2>
  <ul>
    <li><a href="">Voir tous</a></li>
    <li><a href="">Secretariat</a></li>
    <li><a href="">Palfeniers</a></li>
    <li><a href="">Manager</a></li>
    <li><a href="<s:url action='create' namespace="/member"/>">Création</a></li>
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
