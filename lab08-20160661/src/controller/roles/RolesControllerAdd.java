package controller.roles;

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
import model.entity.Role;

import javax.jdo.PersistenceManager;

public class RolesControllerAdd extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
		if (req.getParameter("action").equals("roleCreate")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/add.jsp");
			try {
				dispatcher.forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// process the new account creation and send the user to the account
			// display page
		} else if (req.getParameter("action").equals("roleCreatedDo")) {
			// create the new account
			
				Role g = new Role(req.getParameter("name"),true, null);
				// persist the entity
				try {
					pm.makePersistent(g);
				} finally {
					pm.close();
				}
				res.sendRedirect("/roles");

			
			
			
			
		}
		
	}
}
