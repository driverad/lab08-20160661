package controller.users;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF.PMF;
import model.entity.User;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

public class UsersControllerDelete extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {


		PersistenceManager pm = PMF.get().getPersistenceManager();
		String id = req.getParameter("id");
		User g = pm.getObjectById(User.class, Long.parseLong(id));

		
		pm . deletePersistentAll(g);
		
		res.sendRedirect("/users");

		// forward the request to the jsp
		
	}
}
