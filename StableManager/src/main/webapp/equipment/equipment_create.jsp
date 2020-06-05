<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basepage pageTitle="StableManager">

    <t:pagedescription title="Matériel > Création" ></t:pagedescription>
        <h2>Information générales</h2>
        <s:form action="perform_create" namespace="/equipment">
            <div class="input-field">
                <s:textfield name="equipment.type" label="Type" id="type"/>
                <label for="type">Type</label>
            </div>
            <div class="input-field">
                <s:textfield name="equipment.model" label="Modèle" id="model"/>
                <label for="model">Modèle</label>
            </div>
            <div class="input-field">
                <s:textfield name="equipment.price" label="Prix" id="price"/>
                <label for="price">Prix</label>
            </div>
            <div class="input-field">
                <s:textfield type="number" name="equipment.memberId" label="Propriétaire" id="owner"/>
                <label for="owner">Propriétaire</label>
            </div>
            <button class="btn waves-effect waves-light" type="submit">
                Submit
                <i class="material-icons right">send</i>
            </button>
        </s:form>
</t:basepage>