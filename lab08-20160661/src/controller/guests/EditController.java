package controller.guests;

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
import model.entity.Guest;
import javax.jdo.PersistenceManager;

public class EditController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
			String name = req.getParameter("id");
			String iddd = null;
			Guest elegido = null;

			String id = req.getParameter("id");
			Guest g = pm.getObjectById(Guest.class, Long.parseLong(id));

			String query = "select from " + Guest.class.getName();
			@SuppressWarnings("unchecked")
			List<Guest> guests = (List<Guest>) pm.newQuery(query).execute();
			for (int i = 0; i < guests.size(); i++) {
				iddd = guests.get(i).getId().toString();
				if (iddd.equals(name)) {
					elegido = guests.get(i);
					req.setAttribute("guests", elegido);
					
				}
				
			}	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Guests/update.jsp");
			dispatcher.forward(req, res);
		}
		
		
			
}