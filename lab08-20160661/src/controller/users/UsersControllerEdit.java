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

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF.PMF;
import model.entity.User;
import model.entity.Role;

import javax.jdo.PersistenceManager;

public class UsersControllerEdit extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
			String name = req.getParameter("id");
			String iddd = null;
			User elegido = null;

			String query2 = "select from " + Role.class.getName();
			List<Role> roles = (List<Role>) pm.newQuery(query2).execute();
			req.setAttribute("roles", roles);
			
			
			String id = req.getParameter("id");
			User g = pm.getObjectById(User.class, Long.parseLong(id));

			String query = "select from " + User.class.getName();
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) pm.newQuery(query).execute();
			for (int i = 0; i < users.size(); i++) {
				iddd = users.get(i).getId().toString();
				if (iddd.equals(name)) {
					elegido = users.get(i);
					req.setAttribute("users", elegido);
					
				}
				
			}	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/update.jsp");
			dispatcher.forward(req, res);
		}
		
		
			
}