<%-- 
    Document   : PanierClient
    Created on : 3 mars 2020, 19:40:50
    Author     : Justin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <h1>Votre panier</h1>
            <table border='1'>
                <tr><th>Référence</th><th>Nom du produit</th><th>Quantité</th></tr>
                <c:forEach var="ligne" items="${panier.lignesPanier}">
                    <tr>
                    <td>${ligne.produit.reference}</td>
                    <td>${ligne.produit.nom}</td>
                    <td>
                        <input type="number" value="${ligne.quantite}" name="quantite">
                    </td>
                    <td>
                        <input type="submit"  value="Supprimer du panier">
                    </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
                    <input type="submit" value="Valider le panier">
    </body>
</html>