package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import security.JavaMD5Hash;
import model.User;
import dao.CamDao;
import dao.DaoFactory;

/**
 * Servlet implementation class CamLogin
 */
@WebServlet("/login")
public class CamLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	final CamDao camDao = DaoFactory.getInstance().getCamDao();	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("benutzer");
		String pass = request.getParameter("password");
		
		pass = JavaMD5Hash.md5(pass);
		
		User benutzer = camDao.login(user, pass);		
		
		if(benutzer.getName() == null){			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}else{
			HttpSession session = request.getSession(true);
			
			if(session.isNew()){
				session.setMaxInactiveInterval(60);
			}
			response.sendRedirect(request.getContextPath() + "/camList");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/login.jsp");
		dispatcher.forward(request, response);	
	}

}
