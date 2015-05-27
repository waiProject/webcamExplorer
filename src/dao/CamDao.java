package dao;

import java.util.List;

import model.Cam;
import model.Image;
import model.User;

public interface CamDao {
	public void saveCam(Cam cam);
	public void saveUser(User user);
	public void saveImage(Image image);
	
	public void deleteCam(Long id);
	public void deleteUser(Long id);
	public void deleteImage(Long id);
	
	public Cam getCam(Long id);
	public User getUser(Long id);
	public Image getImage(Long id);
	
	public List<Cam> camList();
	public List<User> userList();
	public List<Image> imageList(Long id);
	
	public User login(String user, String pass);
}

