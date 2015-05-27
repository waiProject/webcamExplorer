package servlets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ThumbnailView
 */
@WebServlet("/thumbnail")
public class ThumbnailView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger jlog = Logger.getLogger(ThumbnailView.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		this.getThumbnail(request.getParameter("path"), response.getOutputStream());	
	}
	
	/**
	 * Reads in an File from local disc given by the path parameter.
	 * Returns this File inside the Servlets OutputStream
	 * @param path to local thumbnail (defined in 'GetWebcamImage' Class)
	 * @param outputStream of the this Servlet response to the Client
	 */
	public void getThumbnail(String path, ServletOutputStream outputStream) {
		FileInputStream is;
		try {
			is = new FileInputStream(path);
			int readBytes = 0;
			do {
				readBytes = is.read();
				outputStream.write(readBytes);
			} while (readBytes >= 0);
			outputStream.flush();
			outputStream.close();
			is.close();	
		} catch (FileNotFoundException e) {
			jlog.error("Datei konnte nicht gelesen werden von: "+path);
			e.printStackTrace();
		} catch (IOException e) {
			jlog.error(e.getMessage());
			e.printStackTrace();
		}			
	}
}
