<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Produits dans la catégorie '${selected.libelle}'</title>
	</head>

	<body>
            <a href="PanierClient">Voir Panier</a>
		<h3>Choisissez la catégorie à afficher</h3>
		<form> 	<%-- L'action par défaut est de revenir à l'URL du contrôleur --%>
			<%-- Une liste de choix pour le paramètre 'code' --%>
			<select name='code' onchange='this.form.submit()'>
				<%-- On parcourt la liste des catégories en mettant une option pour chaque catégorie --%>
				<c:forEach var="categorie" items="${categories}">
					<%-- la valeur de l'option c'est le code de la catégorie --%>
					<option value='${categorie.code}' 
						<%--On détermine quelle et l'option sélectionnée dans la liste --%>
						<c:if test="${categorie.code eq selected.code}">
							selected
						</c:if>
					> <%-- le texte affiché pour l'opton c'est le libellé de la catégorie --%>
						${categorie.libelle}
					</option>
				</c:forEach>
			</select>
			<input type='submit'>
		</form>
		<h2>Produits dans la catégorie ${selected.libelle}</h2>
		<%-- On montre la liste des produits dans la catégorie sélectionnée sous la forme d'une table HTML --%>		
		<table border='1'>
                    <tr><th>Référence</th><th>Nom</th><th>Prix</th><th>Quantité</th><th>Disponible</th><th>Quantité</th><th>Validation</th></tr>
			<%-- Une ligne dans la table pour chaque produit --%>				
			<c:forEach var="produit" items="${selected.produitCollection}">
				<tr>
					<td>${produit.reference}</td>
					<td>${produit.nom}</td>
                                        <td>${produit.prixUnitaire}</td>
                                        <td>${produit.quantiteParUnite}</td>
					<td>
						<input type="checkbox"
						       <c:if test="${produit.indisponible eq 0}">checked</c:if>
						>
					</td>
                                        <form method="POST" action="">
                                        <input type="hidden" name="produit" value="${produit.reference}">
                                        <td>  <c:if test="${produit.indisponible eq 0}">
                                            <input type="number" value="1" name="quantite">
                                            </c:if>
					</td>
                                        <td>
                                            <c:if test="${produit.indisponible eq 0}">
                                        <input type="submit" value="Ajouter au panier">
                                        </c:if>
                                        </td>
                                        </form>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<a href="../client.html">Retour</a>
	<hr>
        </body>
</html>