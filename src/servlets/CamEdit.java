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

import dao.CamDao;
import dao.DaoFactory;
import exception.CamNotDeletedException;
import exception.CamNotFoundException;
import exception.CamNotSavedException;
import model.Cam;

@WebServlet("/editCam")
public class CamEdit extends HttpServlet {	
	
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
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/addCam.jsp");
			dispatcher.forward(request, response);		
		}
		else if(action.equals("edit")) {			
			try {
				Cam cam = camDao.getCam(id);
				request.setAttribute("cam", cam);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/editCam.jsp");
				dispatcher.forward(request, response);
			} catch (CamNotFoundException e) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
				dispatcher.forward(request, response);
			}				
		}
		else if(action.equals("delete")) {			
			try {
				camDao.deleteCam(id);
				response.sendRedirect(request.getContextPath() + "/camList");
			} catch (CamNotDeletedException e) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(action.equals("search")) {			
			try {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/SelectCam.jsp");
				dispatcher.forward(request, response);
			} catch (CamNotDeletedException e) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
				
		Long id = null;
		
		Cam cam = createCam(request);
		
		if(request.getParameter("id") != null) {
			id = Long.valueOf(request.getParameter("id"));
			cam.setId(id);
		}
		
		try {		
			camDao.saveCam(cam);
			response.sendRedirect(request.getContextPath() + "/camList");
		}  catch (CamNotSavedException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	
	private Cam createCam(HttpServletRequest request){ 
		String name = request.getParameter("name");
		String ort = request.getParameter("ort");
		String url = request.getParameter("url");
		String rolle = request.getParameter("rolle");
		
				
		Cam cam = new Cam();
		cam.setName(name);
		cam.setOrt(ort);
		cam.setUrl(url);
		cam.setRolle(rolle);
		
		return cam;
	}
}
