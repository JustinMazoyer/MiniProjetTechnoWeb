%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Modification du profil de $(cleint.codeClient)</title>
    </head>

    <body>
        <h1>Modifiez votre profil</h1>

        <form method="GET"> 
            <input name="code" placeholder="Entrez votre code"><br>
            <ul> 
              <%--  <c:forEach var="error" items="${validationErrors.getErrors('code')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach>--%>
            </ul>
            <input name="societe" placeholder="Entrez votre societe"><br>
            <ul> 
               <%--  <c:forEach var="error" items="${validationErrors.getErrors('societe')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach> --%>
            </ul>

            <input name="adresse" placeholder="Entrez votre adresse"><br>
            <ul> 
                <%-- <c:forEach var="error" items="${validationErrors.getErrors('adresse')}">
                    <li><span style="color: red;">${mvc.encoders.html(error.message)}</span></li>
                    </c:forEach> --%>
            </ul>
            <input type="submit" value="Modifier information">
        </form>
        <%-- Est-ce qu'on a un message d'erreur à afficher ? --%>
        <%--  <c:if test="${not empty databaseErrorMessage}">
            <h2>Erreur !</h2>
            <span style="color: red;">${databaseErrorMessage}</span>
        </c:if>
        <table border='1'>
            <tr><th>Code</th><th>Societe</th><th>adresse</th></tr>

            <c:forEach var="client" items="${clients}">
                <tr>
                    <td>${client.code}</td>
                    <td>${mvc.encoders.html(client.socite)}</td>
                    <td>${mvc.encoders.html(client.adresse)}</td>
                </tr>
            </c:forEach>
        </table>--%>
        <hr>
        <a href="${pageContext.request.contextPath}/">Retour au menu</a>
    </body>
</html>
