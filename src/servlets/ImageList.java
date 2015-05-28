//package servlets;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import security.SessionHandling;
//import model.Image;
//import dao.CamDao;
//import dao.DaoFactory;
//
//@WebServlet("/imageList")
//public class ImageList extends HttpServlet {	
//	
//	private static final long serialVersionUID = 1L;
//	
//	final CamDao camDao = DaoFactory.getInstance().getCamDao();
//	
//	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
//		if(!SessionHandling.isSessionOK(request)){
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/login.jsp");
//			dispatcher.forward(request, response);
//		}else{
//			Long id = null;
//			String cam_name = null;
//			String cam_ort = null;
//			
//			if (request.getParameter("id") != null) {
//				cam_name = request.getParameter("cam_name");
//				cam_ort = request.getParameter("cam_ort");
//				id = Long.valueOf(request.getParameter("id"));
//			}
//			List<Image> collection = camDao.imageList(id);
//		
//			request.setAttribute("images", collection);
//			request.setAttribute("cam_name", cam_name);
//			request.setAttribute("cam_ort", cam_ort);
//			
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/thumbImages.jsp");
//			dispatcher.forward(request, response);
//		}		
//	}
//}
