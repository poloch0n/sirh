package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.sgp.util.*;

public class EditerCollaborateurController  extends HttpServlet {
	private static final long serialVersionUID = -2796943719061702802L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String matricule = req.getParameter("matricule");

		// code HTML

		resp.setContentType("text/html");
		if(Fonctions.isNullOrEmpty(matricule)) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("un matricule est attendu");
		} else {
			resp.getWriter().write("<h1>Edition de collaborateur</h1>");
			resp.getWriter().write("<h2> Matricule : "+matricule+"</h2");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matricule = req.getParameter("matricule");
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");

		resp.setContentType("text/html");
		if(Fonctions.isNullOrEmpty(matricule) || Fonctions.isNullOrEmpty(titre) || Fonctions.isNullOrEmpty(nom) || Fonctions.isNullOrEmpty(prenom)) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("Les paramètres suivants sont incorrects:");
			resp.getWriter().write("<ul>");
			
			if(Fonctions.isNullOrEmpty(matricule)) {
				resp.getWriter().write("<li>matricule</li>");
			}
			if(Fonctions.isNullOrEmpty(titre)) {
				resp.getWriter().write("<li>titre</li>");
			}
			if(Fonctions.isNullOrEmpty(nom)) {
				resp.getWriter().write("<li>nom</li>");
			}
			if(Fonctions.isNullOrEmpty(prenom)) {
				resp.getWriter().write("<li>prenom</li>");
			}
			resp.getWriter().write("</ul>");
			
		} else {
			resp.setStatus(HttpServletResponse.SC_CREATED );
			resp.getWriter().write("Creation d’un collaborateur avec les informations suivantes :");

			resp.getWriter().write("<ul>");
			resp.getWriter().write("<li>matricule="+matricule+",titre="+titre+",prenom="+prenom+",nom="+nom+"</li>");
			resp.getWriter().write("</ul>");
		}
		
	}
}
