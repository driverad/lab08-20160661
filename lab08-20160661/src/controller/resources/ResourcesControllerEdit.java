package controller.resources;

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
import model.entity.Resource;
import javax.jdo.PersistenceManager;

public class ResourcesControllerEdit extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
			String name = req.getParameter("id");
			String iddd = null;
			Resource elegido = null;

			String id = req.getParameter("id");
			Resource g = pm.getObjectById(Resource.class, Long.parseLong(id));

			String query = "select from " + Resource.class.getName();
			@SuppressWarnings("unchecked")
			List<Resource> resources = (List<Resource>) pm.newQuery(query).execute();
			for (int i = 0; i < resources.size(); i++) {
				iddd = resources.get(i).getId().toString();
				if (iddd.equals(name)) {
					elegido = resources.get(i);
					req.setAttribute("resources", elegido);
					
				}
				
			}	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Resources/update.jsp");
			dispatcher.forward(req, res);
		}
		
		
			
}