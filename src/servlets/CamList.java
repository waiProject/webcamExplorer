package servlets;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.JNDIFactory;
import model.Cam;
import dao.CamDao;
import dao.DaoFactory;

@WebServlet("/camList")
public class CamList extends HttpServlet {	
	
	private static final long serialVersionUID = 1L;
	
	final CamDao camDao = DaoFactory.getInstance().getCamDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		try {
			System.out.println(JNDIFactory.getInstance().getEnvironmentAsString("webcamExplorer"));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("session is null: "+request.getSession(false) == null);
		if(request.getSession(false) == null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/login.jsp");
			dispatcher.forward(request, response);
		}else{
			List<Cam> collection = camDao.list();
			request.setAttribute("cams", collection);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/camList.jsp");
			dispatcher.forward(request, response);
		}		
	}
}
