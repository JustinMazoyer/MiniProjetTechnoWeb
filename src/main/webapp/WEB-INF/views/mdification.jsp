<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Modification du profil de ${player.code}</title>
    </head>

    <body>
        <body>
        <h1>Les informations personnelles du client ${client.contact}</h1>
        <form method="POST">
            Code: <input name="code" value="${client.code}"></br>
            <br> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('code')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </br>
            Société: <input name="societe" value="${client.societe}"></br>
            <br> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('société')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </br>
            Contact: <input name="contact" value="${client.contact}"></br>
            <br> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('contact')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </br>
            Fonction: <input name="fonction" value="${client.fonction}"></br>
            <br> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('fonction')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </br>
            Adresse: <input name="adresse" value="${client.adresse}"></br>
            <br> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('adresse')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </br>
            Ville: <input name="ville" value="${client.ville}"></br>
            <br> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('ville')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </br>
            Région: <input name="region" value="${client.region}"></br>
            <br> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('region')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </br>
            Code Postal: <input name="codePostal" value="${client.codePostal}"></br>
            <br> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('codePostal')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </br>
            Pays: <input name="pays" value="${client.pays}"></br>
            <br> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('pays')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </br>
            Téléphone: <input name="telephone"value="${client.telephone}"></br>
            <br> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('telephone')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </br>
            Fax: <input name="fax" value="${client.fax}"></br>
            <br> <%-- On montre les erreurs de saisie éventuelles --%>
                <c:forEach var="error" items="${validationErrors.getErrors('fax')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>
            </br>
            <input type="submit" value="Envoyer">
        </form>
        <c:if test="${not empty databaseErrorMessage}">
            <span style="color: red;">${databaseErrorMessage}</span>
        </c:if>
        <hr>
        <a href="../client.html">Retour à la plateforme Client</a>
    </body>
</html>
