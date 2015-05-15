package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.CamDao;
import dao.DaoFactory;

@WebServlet("/userList")
public class UserList extends HttpServlet {	
	
	private static final long serialVersionUID = 1L;
	
	final CamDao camDao = DaoFactory.getInstance().getCamDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		List<User> collection = camDao.userList();
		request.setAttribute("users", collection);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/userList.jsp");
		dispatcher.forward(request, response);		
	}
}
