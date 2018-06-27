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

public class AccessControllerUpdate extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String id = req.getParameter("id2");
		
		

		String query2 = "select from " + Role.class.getName();
		String query3 = "select from " + Resource.class.getName();

		List<Role> roles = (List<Role>) pm.newQuery(query2).execute();
		List<Resource> resources = (List<Resource>) pm.newQuery(query3).execute();
		Resource re= null;
		Role r = null;
		for(int i = 0; i< roles.size();i++){
			r = roles.get(i);
			if(r.getName().equals(req.getParameter("role"))){
				break;
			}
		}
		for(int i = 0; i< resources.size();i++){
			re = resources.get(i);
			if(re.getName().equals(req.getParameter("resource"))){
				break;
			}
		}
		String idR = Long.toString(r.getId());
		String idRe = Long.toString(re.getId());

		

		
		
		
		
		String query = "select from " + Acces.class.getName();
		@SuppressWarnings("unchecked")
		List<Acces> events = (List<Acces>) pm.newQuery(query).execute();
		boolean status = true;
		if (req.getParameter("accesStatus").equals("true")) {
			status = true;
		} else {
			status = false;
		}

		
		String iddd = null;
		for (int i = 0; i < events.size(); i++) {
			iddd = events.get(i).getId().toString();
			if (iddd.equals(id)) {

				events.get(i).setRole(idR);
				events.get(i).setResource(idRe);
				events.get(i).setStatus(status);

			}
			res.sendRedirect("/access");
		}

	}
}
