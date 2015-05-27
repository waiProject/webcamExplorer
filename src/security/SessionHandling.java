package security;

import javax.servlet.http.HttpServletRequest;

public class SessionHandling {
	
	public static boolean isSessionOK(HttpServletRequest request) {
		String keyWord = null;
	
		if(request.getSession(false) != null){
			keyWord = (String) request.getSession(false).getAttribute("rolle");
			if(keyWord == null){
				return false;
			}
		}else{
			return false;
		}
		return true;
	}
}
