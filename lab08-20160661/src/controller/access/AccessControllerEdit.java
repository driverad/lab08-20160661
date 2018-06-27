package controller.access;

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
import model.entity.*;
import javax.jdo.PersistenceManager;

public class AccessControllerEdit extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
			String name = req.getParameter("id");
			String iddd = null;
			Acces elegido = null;
			
			
			
			String query2 = "select from " + Role.class.getName();
			List<Role> roles = (List<Role>) pm.newQuery(query2).execute();
			req.setAttribute("roles", roles);
			

			String query3 = "select from " + Resource.class.getName();
			List<Resource> resources = (List<Resource>) pm.newQuery(query3).execute();
			req.setAttribute("resources", resources);

			
			
			String id = req.getParameter("id");
			Acces g = pm.getObjectById(Acces.class, Long.parseLong(id));

			String query = "select from " + Acces.class.getName();
			@SuppressWarnings("unchecked")
			List<Acces> access = (List<Acces>) pm.newQuery(query).execute();
			for (int i = 0; i < access.size(); i++) {
				iddd = access.get(i).getId().toString();
				if (iddd.equals(name)) {
					elegido = access.get(i);
					req.setAttribute("access", elegido);
					
				}
				
			}	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/update.jsp");
			dispatcher.forward(req, res);
		}
		
		
			
}