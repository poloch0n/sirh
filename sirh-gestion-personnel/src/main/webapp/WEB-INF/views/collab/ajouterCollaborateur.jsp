<%@page import="java.util.List"%>
<%@ page language="java"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.js">
<title>SGP - App</title>
</head>
<body>
	<h1>Ajouter collaborateur</h1><%
	String error = (String) request.getAttribute("error") ;
	String nom = (String) request.getAttribute("nom");
	nom = (nom == null) ? "" : nom;
	String prenom = (String) request.getAttribute("prenom");
	prenom = (prenom == null)? "" : prenom;
	String adresse = (String) request.getAttribute("adresse");
	adresse = (adresse == null)? "" : adresse;
	String numero_securite_social = (String) request.getAttribute("numero_securite_social");
	numero_securite_social = (numero_securite_social == null)? "" : numero_securite_social;
%>
		<li><%=error%></li>
	<form action="/sirh/collaborateurs/ajouter" method="post">
		nom : <input type="text" name="nom" value="<%=nom%>"> <br>
		prenom : <input type="text" name="prenom" value="<%=prenom%>"> <br>
		date de naissance : <input type="date" name="dateNaissance" value=""> <br>
		adresse: <input type="text" name="adresse" value="<%=adresse%>"> <br>
		Numero de sécurité social : <input type="text" name="numero_securite_social" value="<%=numero_securite_social%>"> <br>
		<br> <input type="submit" value="Créer">
	</form>
</body>
</html>