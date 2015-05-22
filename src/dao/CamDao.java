package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Cam;
import model.User;

public interface CamDao {
	public void saveCam(Cam cam);
	public void saveUser(User user);
	
	public void deleteCam(Long id);
	public void deleteUser(Long id);
	
	public Cam getCam(Long id);
	public User getUser(Long id);
	
	public List<Cam> list();
	public List<User> userList();
	
	public User login(String user, String pass);
	public boolean isSessionOK(HttpServletRequest request);
}

