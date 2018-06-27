package controller.guests;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF.PMF;
import model.entity.Guest;

import javax.jdo.PersistenceManager;

public class AddController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
		if (req.getParameter("action").equals("guestCreate")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Guests/add.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// process the new account creation and send the user to the account
			// display page
		} else if (req.getParameter("action").equals("guestCreatedDo")) {
			// create the new account
			
			if(req.getParameter("gender").equals("hombre")){
				Guest g = new Guest(req.getParameter("name"), req.getParameter("city"), req.getParameter("phone"),
						req.getParameter("dni"), true, true, req.getParameter("age"), req.getParameter("email"), null);
				// persist the entity
				try {
					pm.makePersistent(g);
				} finally {
					pm.close();
				}
				res.sendRedirect("/guests");

			}
			else{
				Guest g = new Guest(req.getParameter("name"), req.getParameter("city"), req.getParameter("phone"),
						req.getParameter("dni"), false, true, req.getParameter("age"), req.getParameter("email"), null);
				// persist the entity	
				try {
					pm.makePersistent(g);
				} finally {
					pm.close();
				}
				res.sendRedirect("/guests");

			}
			
			
			
		}
		
	}
}
