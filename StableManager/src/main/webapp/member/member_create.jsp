<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:basepage pageTitle="StableManager">
    <jsp:attribute name="pageHeader">
        <t:pagedescription title="Employés > Création" />
    </jsp:attribute>


    <jsp:body>
        <h2>Information générales</h2>
        <s:form action="perform_create" namespace="/member">
            <div class="input-field">
                <s:textfield name="member.firstName" label="Prénom" id="firstname"/>
                <label for="firstname">Prénom</label>
            </div>
            <div class="input-field">
                <s:textfield name="member.lastName" label="Nom" id="lastname"/>
                <label for="lastname">Nom</label>
            </div>
            <div class="input-field">
                <s:textfield name="member.email" label="Email" id="email" />
                <label for="email">Email</label>
            </div>
            <div class="input-field">
                <s:textfield name="member.postalAddress" label="Adresse postale" id="postal-address"/>
                <label for="postal-address">Adresse postale</label>
            </div>
            <div class="input-field">
                <s:textfield name="member.birthDate" label="Date de naissance" id="birthdate"/>
                <label for="birthdate">Date de naissance</label>
            </div>
            <div class="input-field">
                <s:password name="member.password" label="Mot de passe" id="passwd"/>
                <label for="passwd">Mot de passe</label>
            </div>
            <div class="input-field">
                <s:password name="passwordConfirmation" label="Confirmer votre mot de passe" id="confirm-passwd"/>
                <label for="confirm-passwd">Confirmer votre mot de passe</label>
            </div>
            <button class="btn waves-effect waves-light" type="submit">
                Submit
                <i class="material-icons right">send</i>
            </button>
        </s:form>
    </jsp:body>




</t:basepage>