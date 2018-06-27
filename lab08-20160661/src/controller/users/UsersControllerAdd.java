package controller.users;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF.PMF;
import model.entity.Role;
import model.entity.User;

import javax.jdo.PersistenceManager;

public class UsersControllerAdd extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
		if (req.getParameter("action") == null) {
			String query = "select from " + Role.class.getName();
			List<Role> access = (List<Role>) pm.newQuery(query).execute();
			req.setAttribute("roles", access);
			req.getRequestDispatcher("/WEB-INF/Views/Users/add.jsp").forward(req, res);
			
		} else {
			// create the new account
			
			if(req.getParameter("gender").equals("hombre")){
				String query = "select from " + Role.class.getName();
				List<Role> access = (List<Role>) pm.newQuery(query).execute();
				Role r = null;
				for(int i = 0; i< access.size();i++){
					r = access.get(i);
					if(r.getName().equals(req.getParameter("role"))){
						break;
					}
				}
				String idR = Long.toString(r.getId());
				
				User g = new User(req.getParameter("email"), idR,
						 true, true, req.getParameter("age"), null);
				// persist the entity
				try {
					pm.makePersistent(g);
				} finally {
					pm.close();
				}
				res.sendRedirect("/users");

			}
			else{
				String query = "select from " + Role.class.getName();
				List<Role> access = (List<Role>) pm.newQuery(query).execute();
				Role r = null;
				for(int i = 0; i< access.size();i++){
					r = access.get(i);
					if(r.getName().equals(req.getParameter("role"))){
						break;
					}
				}
				String idR = Long.toString(r.getId());
				
				User g = new User(req.getParameter("email"), req.getParameter("role"),
						 false, true, req.getParameter("age"), null);
				// persist the entity	
				try {
					pm.makePersistent(g);
				} finally {
					pm.close();
				}
				res.sendRedirect("/users");

			}
			
			
			
		}
		
	}
}
