/*
 * Created on 22.11.2004
 */
package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import security.JavaMD5Hash;
import dao.CamDao;
import dao.DaoFactory;
import exception.CamNotDeletedException;
import exception.CamNotFoundException;
import exception.CamNotSavedException;
import model.User;

@WebServlet("/editUser")
public class UserEdit extends HttpServlet {	
	
	private static final long serialVersionUID = 1L;
	
	final CamDao camDao = DaoFactory.getInstance().getCamDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		
		if (action == null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
				
		Long id = null;
		
		if (request.getParameter("id") != null) {
			id = Long.valueOf(request.getParameter("id"));
		}
				
		if(action.equals("add")){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/addUser.jsp");
			dispatcher.forward(request, response);
		}
		else if(action.equals("edit")) {			
			try {
				User user = camDao.getUser(id);
				request.setAttribute("user", user);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/editUser.jsp");
				dispatcher.forward(request, response);
			} catch (CamNotFoundException e) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
				dispatcher.forward(request, response);
			}				
		} 
		else if(action.equals("delete")) {			
			try {
				camDao.deleteUser(id);
				response.sendRedirect(request.getContextPath() + "/userList");
			} catch (CamNotDeletedException e) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
				
		Long id = null;
		
		User user = createUser(request);
		
		if(request.getParameter("id") != null) {
			id = Long.valueOf(request.getParameter("id"));
			user.setId(id);
		}
		
		try {		
			camDao.saveUser(user);
			response.sendRedirect(request.getContextPath() + "/userList");
		}  catch (CamNotSavedException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	/**
	 * Creates a User Model Object with given parameters
	 * @param request
	 * @return User
	 */
	private User createUser(HttpServletRequest request) {
		String name = request.getParameter("name");
		String pass = JavaMD5Hash.md5(request.getParameter("password"));
		String rolle = request.getParameter("rolle");
		
				
		User user = new User();
		user.setName(name);
		user.setPasswort(pass);
		user.setRolle(rolle);
		
		return user;
	}
}
