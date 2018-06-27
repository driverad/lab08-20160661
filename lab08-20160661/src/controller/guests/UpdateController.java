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

public class UpdateController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String id = req.getParameter("id2");
		String query = "select from " + Guest.class.getName();
		@SuppressWarnings("unchecked")
		List<Guest> events = (List<Guest>) pm.newQuery(query).execute();
		boolean status = true;
		boolean gender = true;
		if (req.getParameter("guestStatus").equals("true")) {
			status = true;
		} else {
			status = false;
		}

		if (req.getParameter("gender").equals("hombre")) {
			gender = true;
		} else {
			gender = false;
		}
		String iddd = null;
		for (int i = 0; i < events.size(); i++) {
			iddd = events.get(i).getId().toString();
			if (iddd.equals(id)) {
				events.get(i).setName(req.getParameter("name"));
				events.get(i).setCity(req.getParameter("city"));
				events.get(i).setPhone(req.getParameter("phone"));
				events.get(i).setAge(req.getParameter("age"));
				events.get(i).setEmail(req.getParameter("email"));
				events.get(i).setStatus(status);
				events.get(i).setGender(gender);
				events.get(i).setDni(req.getParameter("dni"));

			}
			res.sendRedirect("/guests");
		}

	}
}
