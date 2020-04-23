<%-- 
    Document   : VisualiserCommande
    Created on : 1 mars 2020, 17:34:56
    Author     : Justin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des commandes</title>
    </head>
    <body>
        <h1>Commandes pour le client ${client.societe}</h1>
        <table border='1'>
            <tr><th>Numéro</th><th>Saisie le</th><th>Port</th><th>Destinataire</th><th>nb. lignes</th></tr>
            <c:forEach var="commande" items="${client.commandeCollection}">
                <tr>
                    <td>${commande.numero}</td>
                    <td>${commande.saisieLe}</td>
                    <td>${commande.port}</td>
                    <td>${commande.destinataire}</td>
                    <td>${commande.ligneCollection.size()}</td>
                     

                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="../client.html">Retour</a>
    </body>
</html>
