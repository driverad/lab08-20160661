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
import model.entity.Role;
import model.entity.User;
import javax.jdo.PersistenceManager;

public class UsersControllerUpdate extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String id = req.getParameter("id2");
		
		String query2 = "select from " + Role.class.getName();

		List<Role> access = (List<Role>) pm.newQuery(query2).execute();
		Role r = null;
		for(int i = 0; i< access.size();i++){
			r = access.get(i);
			if(r.getName().equals(req.getParameter("role"))){
				break;
			}
		}
		
		String idR = Long.toString(r.getId());

		String query = "select from " + User.class.getName();
		@SuppressWarnings("unchecked")
		List<User> events = (List<User>) pm.newQuery(query).execute();
		boolean status = true;
		boolean gender = true;
		if (req.getParameter("userStatus").equals("true")) {
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
				events.get(i).setEmail(req.getParameter("email"));
				events.get(i).setRole(idR);
				events.get(i).setStatus(status);
				events.get(i).setGender(gender);
				events.get(i).setAge(req.getParameter("age"));

			}
			res.sendRedirect("/users");
		}

	}
}
