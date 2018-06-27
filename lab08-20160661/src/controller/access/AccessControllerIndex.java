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
import controller.PMF.PMF;
import model.entity.Acces;
import javax.jdo.PersistenceManager;

public class AccessControllerIndex extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + Acces.class.getName();
		List<Acces> access = (List<Acces>) pm.newQuery(query).execute();
		req.setAttribute("access", access);
		// forward the request to the jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Access/index.jsp");
		try {
			dispatcher.forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
