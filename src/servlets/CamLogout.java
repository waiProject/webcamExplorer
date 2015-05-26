package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CamDao;
import dao.DaoFactory;

/**
 * Servlet implementation class CamLogin
 */
@WebServlet("/logout")
public class CamLogout extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	final CamDao camDao = DaoFactory.getInstance().getCamDao();	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.sendRedirect(request.getContextPath() + "/login");		
	}

}
