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

public class ViewController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Guest.class.getSimpleName(),
				new Long(req.getParameter("accountId")).longValue());
		Guest a = pm.getObjectById(Guest.class, k);
		// query for the opportunities

		String query = "select from " + Guest.class.getName() + " where accountId =="
				+ req.getParameter("id");
		List<Guest> opportunities = (List<Guest>) pm.newQuery(query).execute();
		// pass the list to the jsp
		req.setAttribute("account", a);
		// pass the list to the jsp
		req.setAttribute("opportunities", opportunities);
		// forward the request to the jsp
		req.getRequestDispatcher("/WEB-INF/Views/Guests/view.jsp").forward(req, res);
		*/
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String id= req.getParameter("id");
		Guest  g=pm.getObjectById(Guest.class,Long .parseLong(id));
		
		req.setAttribute("guest", g);
		// forward the request to the jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Guests/view.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
