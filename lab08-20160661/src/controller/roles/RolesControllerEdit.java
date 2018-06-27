package controller.roles;

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

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF.PMF;
import model.entity.Role;
import javax.jdo.PersistenceManager;

public class RolesControllerEdit extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
			String name = req.getParameter("id");
			String iddd = null;
			Role elegido = null;

			String id = req.getParameter("id");
			Role g = pm.getObjectById(Role.class, Long.parseLong(id));

			String query = "select from " + Role.class.getName();
			@SuppressWarnings("unchecked")
			List<Role> roles = (List<Role>) pm.newQuery(query).execute();
			for (int i = 0; i < roles.size(); i++) {
				iddd = roles.get(i).getId().toString();
				if (iddd.equals(name)) {
					elegido = roles.get(i);
					req.setAttribute("roles", elegido);
					
				}
				
			}	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/update.jsp");
			dispatcher.forward(req, res);
		}
		
		
			
}