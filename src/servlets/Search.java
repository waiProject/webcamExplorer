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

import security.SessionHandling;
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
		Long cam_id = null;
		String cam_name = null;
		String cam_ort = null;
		
		if (request.getParameter("cam_id") != null) {
			cam_id = Long.valueOf(request.getParameter("cam_id"));
			cam_name = request.getParameter("cam_name");
			cam_ort = request.getParameter("cam_ort");
		}
		
		if(!SessionHandling.isSessionOK(request)){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/login.jsp");
			dispatcher.forward(request, response);
		}else{
			List<Image> imageList = camDao.imageList(cam_id);
			List<String> dateList = new LinkedList<String>();
			
			for(Image img : imageList)
			{
				if(!dateList.contains(img.getDatum()))
					dateList.add(img.getDatum());
			}
			HttpSession session = request.getSession(false);
			session.setAttribute("imageList", imageList);
			session.setAttribute("cam_id", cam_id);
			session.setAttribute("cam_name", cam_name);
			session.setAttribute("cam_ort", cam_ort);
			
			request.setAttribute("dates", dateList);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/search.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
