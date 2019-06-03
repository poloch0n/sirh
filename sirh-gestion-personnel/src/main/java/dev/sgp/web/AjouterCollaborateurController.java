package dev.sgp.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.*;

public class AjouterCollaborateurController extends HttpServlet implements Constantes{

	private static final long serialVersionUID = -5858141110469728715L;

	// recuperation du service
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/collab/ajouterCollaborateur.jsp").forward(req, resp);
	}		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// generate "unique" matricule from timestamp
		// since there is only one session at a time
		Date date = new Date();
		String matricule = "" + date.getTime();
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		LocalDate dateNaissance = LocalDate.parse(req.getParameter("dateNaissance")); // TODO : case dateNaissance not filled care
		String adresse = req.getParameter("adresse");
		String numero_securite_social = req.getParameter("numero_securite_social");
		String emailPro;
//		String photo = req.getParameter("photo");
		ZonedDateTime dateHeureCreation = ZonedDateTime.now();
		boolean actif = false;

		// TODO : to escape variable
//		//load application.properties
//		Properties appProps = new Properties();
		Properties properties = new Properties();
		InputStream resource = null;
		resource = AjouterCollaborateurController.class.getResourceAsStream("/application.properties");
		properties.load(resource);
//		
		// to validate
		String error ="";
		if (Fonctions.isNullOrEmpty(nom)) {
			error += " Veuillez remplir le nom";
		}	
		if (Fonctions.isNullOrEmpty(prenom)) {
			error += " Veuillez remplir le prenom";
		}
		if (dateNaissance == null) {
			error += " Veuillez remplir la date de naissance";
		}
		if(Fonctions.isNullOrEmpty(numero_securite_social)) {

			error += " Veuillez remplir le numero securite social";
		}
		
		if ( !(""+numero_securite_social.length()).equals(properties.getProperty("numero_securite_social.length"))) {
			error += " Le numero de securité social n'a pas le bon format, il doit faire '"+properties.getProperty("numero_securite_social.length")+"' de long alors qu'il en fait '"+numero_securite_social.length()+"'";
		}

		if(Fonctions.isNullOrEmpty(adresse)) {

			error += " Veuillez remplir l'adresse";
		}
		
		if(error != "") {
			req.setAttribute("error",error);
//			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			req.setAttribute("nom", nom);
			req.setAttribute("prenom", prenom);
			req.setAttribute("dateNaissance", dateNaissance);
			req.setAttribute("adresse", adresse);
			req.setAttribute("numero_securite_social", numero_securite_social);
			req.getRequestDispatcher("/WEB-INF/views/collab/ajouterCollaborateur.jsp").forward(req, resp);
			
		} else {
//			resp.setStatus(HttpServletResponse.SC_CREATED );
			emailPro = prenom+nom+"@"+properties.getProperty("baseMail");
			actif = true;
			
			//generate Collaborateurs
			Collaborateur collaborateur = new Collaborateur();
			collaborateur.setMatricule(matricule);
			collaborateur.setNom(nom);
			collaborateur.setPrenom(prenom);
//			collaborateur.setDateNaissance(date_de_naissance);
			collaborateur.setAdresse(adresse);
			collaborateur.setNumero_securite_social(numero_securite_social);
			collaborateur.setEmailPro(emailPro);
			collaborateur.setDateHeureCreation(dateHeureCreation);
			collaborateur.setActif(actif);
//			LocalDate date_de_naissance;
//			String photo;

			COLLAB_SERVICE.sauvegarderCollaborateur(collaborateur);

			resp.sendRedirect("http://localhost:8080/sirh/collaborateurs/lister");
		}
		

	}

}
