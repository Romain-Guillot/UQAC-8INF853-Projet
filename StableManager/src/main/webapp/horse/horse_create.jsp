<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Chevaux > Création" ></t:pagedescription>
        <h2>Information générales</h2>
        <s:form action="perform_create" namespace="/horse">
            <div class="input-field">
                <s:textfield name="horse.name" label="Nom" id="name"/>
                <label for="name">Nom</label>
            </div>
            <div class="input-field">
                <s:textfield name="horse.birthDate" label="Date de naissance" id="birthdate"/>
                <label for="birthdate">Date de naissance</label>
            </div>
            <div class="input-field">
                <s:textfield type="number" name="horse.memberId" label="Propriétaire" id="owner"/>
                <label for="owner">Propriétaire</label>
            </div>
            <button class="btn waves-effect waves-light" type="submit">
                Submit
                <i class="material-icons right">send</i>
            </button>
        </s:form>
</t:basepage>