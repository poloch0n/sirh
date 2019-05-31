package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListerCollaborateursController extends HttpServlet {
	private static final long serialVersionUID = 3155850309813211995L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String avecPhotoParam = req.getParameter("avecPhoto");
		// recupere la valeur d'un
		// parametre dont le nom est departementString departement
		String departementParam = req.getParameter("departement");
		resp.setContentType("text/html");
		
		// code HTML
		resp.getWriter().write("<h1>Liste des collaborateurs</h1>"+ "<ul>"+ "<li>avecPhoto="+ avecPhotoParam + "</li>"+ "<li>departement="+ departementParam + "</li>"+ "</ul>");
	}
}
