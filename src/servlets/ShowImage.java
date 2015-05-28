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

import model.Image;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ThumbnailView
 */
@WebServlet("/showImage")
public class ShowImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger jlog = Logger.getLogger(ShowImage.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String localpath = request.getParameter("localpath");
//		String action = request.getParameter("action");
		
//		if(action.equals("thumbnailView")){
//			String datum = request.getParameter("datum");
//			List<Image> imageList = (List<Image>) request.getSession(false).getAttribute("imageList");
//			List<Image> imageListDate = new LinkedList<Image>();
//			
//			for(Image img : imageList){
//				if(img.getDatum().equals(datum)){
//					imageListDate.add(img);
//				}
//			}
//			request.setAttribute("images", imageListDate);
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/thumbImages.jsp");
//			dispatcher.forward(request, response);
//		}else if(action.equals("showPicture")){
			if(localpath != null){
				request.setAttribute("localpath", localpath);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/showImage.jsp");
				dispatcher.forward(request, response);
			}else{
				jlog.error("Das angeforderte Datum konnte nicht gefunden werden!");
				request.setAttribute("error", "Das angeforderte Datum konnte nicht gefunden werden!");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
//		}	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String datum = request.getParameter("datumauswahl");
		List<Image> imageList = (List<Image>) request.getSession(false).getAttribute("imageList");
		List<Image> imageListDate = new LinkedList<Image>();
		
		for(Image img : imageList){
			if(img.getDatum().equals(datum)){
				imageListDate.add(img);
			}
		}
		request.setAttribute("images", imageListDate);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/thumbImages.jsp");
		dispatcher.forward(request, response);
	}
}
