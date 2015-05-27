package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import security.SessionHandling;
import model.Cam;
import dao.CamDao;
import dao.DaoFactory;

@WebServlet("/camList")
public class CamList extends HttpServlet {	
	
	private static final long serialVersionUID = 1L;
	
	final CamDao camDao = DaoFactory.getInstance().getCamDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		if(request.isRequestedSessionIdValid()){
			System.out.println("BLABLUB SESSION is valid:"+request.getSession(false).getId());
		}
		if(!SessionHandling.isSessionOK(request)){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/login.jsp");
			dispatcher.forward(request, response);
		}else{
			List<Cam> collection = camDao.camList();
			request.setAttribute("cams", collection);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/camList.jsp");
			dispatcher.forward(request, response);
		}		
	}
}
