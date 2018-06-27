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
import model.entity.Role;
import model.entity.Resource;

import javax.jdo.PersistenceManager;

public class AccessControllerAdd extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
		if (req.getParameter("action") == null) {
			String query = "select from " + Role.class.getName();
			List<Role> access = (List<Role>) pm.newQuery(query).execute();
			req.setAttribute("roles", access);

			
			String query2 = "select from " + Resource.class.getName();
			List<Resource> access2 = (List<Resource>) pm.newQuery(query2).execute();
			req.setAttribute("resources", access2);

			
			req.getRequestDispatcher("/WEB-INF/Views/Access/add.jsp").forward(req, res);
			
			
			
			
		}  else {
			// create the new account
			

			String query = "select from " + Role.class.getName();
			String query2 = "select from " + Resource.class.getName();
				List<Role> access = (List<Role>) pm.newQuery(query).execute();
				List<Resource> access2 = (List<Resource>) pm.newQuery(query2).execute();
				Resource re= null;
				Role r = null;
				for(int i = 0; i< access.size();i++){
					r = access.get(i);
					if(r.getName().equals(req.getParameter("role"))){
						break;
					}
				}
				
				for(int i = 0; i< access2.size();i++){
					re = access2.get(i);
					if(re.getName().equals(req.getParameter("resource"))){
						break;
					}
				}
				String idR = Long.toString(r.getId());
				String idRe = Long.toString(re.getId());
				
				
				
			//
			
			Acces g = new Acces(idR,idRe,true, null);
				// persist the entity
				try {
					pm.makePersistent(g);
				} finally {
					pm.close();
				}
				res.sendRedirect("/access");

			
			
			
			
		}
		
	}
}
