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

@WebServlet("/edit")
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
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/add.jsp");
			dispatcher.forward(request, response);		
		} 
		else if(action.equals("edit")) {			
			try {
				Cam cam = camDao.get(id);
				request.setAttribute("cams", cam);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/edit.jsp");
				dispatcher.forward(request, response);
			} catch (CamNotFoundException e) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
				dispatcher.forward(request, response);
			}				
		} 
		else if(action.equals("delete")) {			
			try {
				camDao.delete(id);
				response.sendRedirect(request.getContextPath() + "/list");
			} catch (CamNotDeletedException e) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(action.equals("show")) {			
			try {
				Cam cam = camDao.get(id);
				/*String url = cam.getUrl();*/
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/show.jsp");
				dispatcher.forward(request, response);
			} catch (CamNotDeletedException e) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		Long id = null;
		
		if(request.getParameter("id") != null) {
			id = Long.valueOf(request.getParameter("id"));
		}
		
		String name = request.getParameter("name");
		String url = request.getParameter("url");
				
		Cam cam = new Cam();		
		cam.setId(id);
		cam.setName(name);
		cam.setUrl(url);		
		
		try {		
			camDao.save(cam);
			response.sendRedirect(request.getContextPath() + "/list");
		}  catch (CamNotSavedException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
