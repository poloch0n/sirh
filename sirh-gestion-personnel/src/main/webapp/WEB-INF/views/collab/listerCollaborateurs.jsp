<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.js">
<title>SGP - App</title>
</head>
<body>
	<h1>Les collaborateurs</h1>
	<ul>
		<%
			List<Collaborateur> listCollaborateur = (List<Collaborateur>) request.getAttribute("collaborateurs");
			for (Collaborateur collaborateur : listCollaborateur) {
		%><li><%=collaborateur.getNom()%></li>
		<%}%>
	</ul>
</body>
</html>