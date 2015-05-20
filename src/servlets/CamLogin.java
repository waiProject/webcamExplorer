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
			request.setAttribute("error", "Benutzername oder Passwort wurden nicht gefunden");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}else{
			HttpSession session = request.getSession();
			response.setHeader("JSESSIONID", session.getId());
			session.setMaxInactiveInterval(5);
			response.sendRedirect(request.getContextPath() + "/camList");
		}		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action == null) {
			request.getSession(false).invalidate();
			request.setAttribute("error", "Die Anwendung konnte nicht richtig ausgef�hrt werden");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}else{
			request.getSession(false).invalidate();
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/login.jsp");
			dispatcher.forward(request, response);
		}	
	}

}
