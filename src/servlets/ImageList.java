package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Image;
import model.User;
import dao.CamDao;
import dao.DaoFactory;

@WebServlet("/imageList")
public class ImageList extends HttpServlet {	
	
	private static final long serialVersionUID = 1L;
	
	final CamDao camDao = DaoFactory.getInstance().getCamDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		List<Image> collection = camDao.imageList();
		request.setAttribute("image", collection);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/search.jsp");
		dispatcher.forward(request, response);		
	}
}
