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

public class ResourcesControllerUpdate extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String id = req.getParameter("id2");
		String query = "select from " + Resource.class.getName();
		@SuppressWarnings("unchecked")
		List<Resource> events = (List<Resource>) pm.newQuery(query).execute();
		boolean status = true;
		if (req.getParameter("resourceStatus").equals("true")) {
			status = true;
		} else {
			status = false;
		}

		
		String iddd = null;
		for (int i = 0; i < events.size(); i++) {
			iddd = events.get(i).getId().toString();
			if (iddd.equals(id)) {
				events.get(i).setName(req.getParameter("name"));
				events.get(i).setStatus(status);

			}
			res.sendRedirect("/resources");
		}

	}
}
