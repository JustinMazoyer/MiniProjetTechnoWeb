<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<title>Produits vendus par catégorie</title>
	<meta charset="UTF-8">
	<!-- On charge JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<!-- On charge l'API Google -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		// cf. https://developers.google.com/chart/interactive/docs/gallery/piechart
		google.charts.load('current', {'packages': ['corechart']});

		// On fait l'appel AJAX dès le chargement de la page
		google.charts.setOnLoadCallback(doAjax);

		function drawPiechart(result) {
			// On met le résultat au format attendu par google
			var data = [['Produit', 'Unités vendues']];
			result.forEach( ligne => data.push([ligne.libelle, ligne.unites]));
			var dataTable = google.visualization.arrayToDataTable(data);

			var chart = new google.visualization.PieChart(document.getElementById('piechart'));
			var options = {title: 'Chiffre affaire par categorie'};
			chart.draw(dataTable, options);
		}

		// Afficher les unités vendues pour la catégorie choisie
		function doAjax() {
			$.ajax({
				url: "service/unitesVendues/chiffreaffaire",
				// Les données saisies dans le formlaire
				data : $('#formulaireCommande').serialize(),
				dataType: "json",
				success: drawPiechart, // La fonction qui traite les résultats
				error: showError
			});
		}

		// Fonction qui traite les erreurs de la requête
		function showError(xhr, status, message) {
			alert("Erreur: " + status + " : " + message);
		}

	</script>
</head>
<body>
	<h1>Chiffre d'affaire par categorie d'article</h1>
	<%--<p>Illustre le passage de paramètres dans un appel AJAX</p>--%>
	<%-- Un formulaire pour choisir la catégorie à afficher --%>
	<%-- On pourrait également faire un appel AJAX pour aller chercher la liste des catégories --%>
         <form id="formulaireCommande">
            <select name='saisieLe' onchange='doAjax()'>
                <c:forEach var="commande" items="${commandes}">
                    <option value='${commande.sasieLe}'>${commande.saisieLe}</option>
                </c:forEach>
            </select>
            <%-- Pas de 'submit', on fait un appel AJAX --%>
            </form>	
       
	<!-- Le graphique apparaît ici -->
	<div id="piechart" style="width: 1000px; height: 500px;"></div>
	<hr>
	 <a href="../Admin.html">Retour</a>
</body>