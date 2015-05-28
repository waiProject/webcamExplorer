package servlets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Image;
import dao.CamDao;
import dao.DaoFactory;

/**
 * Servlet implementation class Search
 */
@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final CamDao camDao = DaoFactory.getInstance().getCamDao();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = null;
		
		if (request.getParameter("id") != null) {
			id = Long.valueOf(request.getParameter("id"));
		}
		
		List<Image> imageList = camDao.imageList(id);
		List<String> dateList = new LinkedList<String>();
		
		for(Image img : imageList)
		{
			if(!dateList.contains(img.getDatum()))
				dateList.add(img.getDatum());
		}
		HttpSession session = request.getSession(false);
		session.setAttribute("imageList", imageList);
		request.setAttribute("cam_id", id);
		request.setAttribute("dates", dateList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/search.jsp");
		dispatcher.forward(request, response);
	}

}
