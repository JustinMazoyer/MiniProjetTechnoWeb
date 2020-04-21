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
        <form method='POST' action="PanierClient">
        <table border='1'>
            <tr><th>Prix Unitaire</th><th>Nom du produit</th>><th>Quantité</th><th>Modifier</th><th>Supprimer</th></tr>
                    <c:forEach var="ligne" items="${panier.lignesPanier}">
                <tr>
                    <td>${ligne.produit.prixUnitaire}</td>
                    <td>${ligne.produit.nom}</td>
                    <td>                         
                        <input type="number" name="quantité" value="${ligne.quantite}">
                        
                    </td>
                     <td>                         
                        <input type="submit"  value="Modifier quantité" formaction="ModifierQuantite">
                        <input type="hidden" name="modifier" value="${ligne.produit.reference}">
                        
                    </td>
                    <td>
                        <input type="submit"  value="Supprimer du panier" formaction="SupprimerLigneCommande">
                        <input type="hidden" name="supprimer" value="${ligne.produit.reference}">
                    </td>
                </tr>
            </c:forEach>
        </table>
            
        <br>
        <input type="submit" value="Valider le panier">
        <br>
        <a href="../client.html">Retour</a>
    </body>
</html>
