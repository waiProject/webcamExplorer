package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import jndi.JndiFactory;
import model.Cam;
import model.User;
import exception.CamNotDeletedException;
import exception.CamNotSavedException;
import exception.CamNotFoundException;
import exception.UserNotDeletedException;
import exception.UserNotFoundException;
import exception.UserNotSavedException;

public class CamDaoImpl implements CamDao {
	
	private static Logger jlog = Logger.getLogger(CamDaoImpl.class);
	final JndiFactory jndi = JndiFactory.getInstance();

	@Override
	public void deleteCam(Long id) {
		
		if (id == null)
			throw new IllegalArgumentException("id can not be null");
		
		Connection connection = null;		
		try {
			connection = jndi.getConnection("jdbc/libraryDB");		
			PreparedStatement pstmt = connection.prepareStatement("delete from cameras where id = ?");
			pstmt.setLong(1, id);
			pstmt.executeUpdate();			
		} catch (Exception e) {
			throw new CamNotDeletedException(id);
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public Cam getCam(Long id) {
		
		if (id == null)
			throw new IllegalArgumentException("id can not be null");
		
		Connection connection = null;		
		try {
			connection = jndi.getConnection("jdbc/libraryDB");			
			PreparedStatement pstmt = connection.prepareStatement("select id, name, ort, url, rolle from cameras where id = ?");
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();							
			if (rs.next()) {
				Cam cam = new Cam();
				cam.setId(rs.getLong("id"));
				cam.setName(rs.getString("name"));
				cam.setOrt(rs.getString("ort"));
				cam.setUrl(rs.getString("url"));
				cam.setRolle(rs.getString("rolle"));
				return cam;
			} else {
				throw new CamNotFoundException(id);
			}			
		} catch (Exception e) {
			throw new CamNotFoundException(id);
		} finally {	
			closeConnection(connection);
		}
	}

	@Override
	public void saveCam(Cam cam) {
		
		if (cam == null)
			throw new IllegalArgumentException("cameras can not be null");
		
		Connection connection = null;		
		try {
			connection = jndi.getConnection("jdbc/libraryDB");			
			if (cam.getId() == null) {
				PreparedStatement pstmt = connection.prepareStatement("insert into cameras (name, ort, url, rolle) values (?,?,?,?)");
//				pstmt.setLong(1, cam.getId()); //ID wird automatisch inkrementiert von DB
				pstmt.setString(1, cam.getName());
				pstmt.setString(2, cam.getOrt());
				pstmt.setString(3, cam.getUrl());
				pstmt.setString(4, cam.getRolle());
				pstmt.executeUpdate();
			} else {
				PreparedStatement pstmt = connection.prepareStatement("update cameras set name = ?, ort = ?, url = ?, rolle = ? where id = ?");
				pstmt.setString(1, cam.getName());
				pstmt.setString(2, cam.getOrt());
				pstmt.setString(3, cam.getUrl());
				pstmt.setString(4, cam.getRolle());
				pstmt.setLong(5, cam.getId());
				pstmt.executeUpdate();
			}			
		} catch (Exception e) {
			throw new CamNotSavedException();
		} finally {
			closeConnection(connection);
		}
	}	

	@Override
	public List<Cam> list() {
		
		List<Cam> camList = new ArrayList<Cam>();
		
		Connection connection = null;		
		try {
			connection = jndi.getConnection("jdbc/libraryDB");			
			
				PreparedStatement pstmt = connection.prepareStatement("select id, name, ort, url, rolle from cameras");				
				ResultSet rs = pstmt.executeQuery();
								
				while (rs.next()) {
					Cam cam = new Cam();
					cam.setId(rs.getLong("id"));
					cam.setName(rs.getString("name"));
					cam.setOrt(rs.getString("ort"));
					cam.setUrl(rs.getString("url"));
					cam.setRolle(rs.getString("rolle"));
					camList.add(cam);
				}
			
			return camList;
		} catch (Exception e) {
			throw new CamNotFoundException();
		} finally {	
			closeConnection(connection);
		}
	}
	
	private void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// nothing to do
				e.printStackTrace();
			}				
		}
	}

	@Override
	public User login(String user, String pass) {
		
		User benutzer = new User();
		
		Connection connection = null;		
		try {
			connection = jndi.getConnection("jdbc/libraryDB");			
			jlog.info("DB Verbindung zu 'jdbc/libraryDB' erfolgreich aufgebaut");
			
				PreparedStatement pstmt = connection.prepareStatement("select name, rolle from users where name = ? and passwort = ?");				
				pstmt.setString(1, user);
				pstmt.setString(2, pass);
				ResultSet rs = pstmt.executeQuery();
								
				while (rs.next()) {
					benutzer.setName(rs.getString("name"));
					benutzer.setRolle(rs.getString("rolle"));
				}
			
			return benutzer;
		} catch (Exception e) {
			throw new UserNotFoundException(benutzer);
		} finally {	
			closeConnection(connection);
		}
	}

	@Override
	public void saveUser(User user) {
		if (user == null)
			throw new IllegalArgumentException("user darf nicht null sein!");
		
		Connection connection = null;		
		try {
			connection = jndi.getConnection("jdbc/libraryDB");			
			if (user.getId() == null) {
				PreparedStatement pstmt = connection.prepareStatement("insert into users (name, passwort, rolle) values (?,?,?)");
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPasswort());
				pstmt.setString(3, user.getRolle());
				pstmt.executeUpdate();
			} else {
				PreparedStatement pstmt = connection.prepareStatement("update users set name = ?, passwort = ?, rolle = ? where user_id = ?");
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPasswort());
				pstmt.setString(3, user.getRolle());
				pstmt.setLong(4, user.getId());
				pstmt.executeUpdate();
			}			
		} catch (Exception e) {
			throw new UserNotSavedException();
		} finally {
			closeConnection(connection);
		}
		
	}

	@Override
	public List<User> userList() {
		List<User> userList = new ArrayList<User>();
		
		Connection connection = null;		
		try {
			connection = jndi.getConnection("jdbc/libraryDB");			
			
				PreparedStatement pstmt = connection.prepareStatement("select user_id, name, rolle from users");				
				ResultSet rs = pstmt.executeQuery();
								
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getLong("user_id"));
					user.setName(rs.getString("name"));
					user.setRolle(rs.getString("rolle"));
					userList.add(user);
				}
			
			return userList;
		} catch (Exception e) {
			throw new UserNotFoundException();
		} finally {	
			closeConnection(connection);
		}
	}

	@Override
	public void deleteUser(Long id) {
		if (id == null)
			throw new IllegalArgumentException("id can not be null");
		
		Connection connection = null;		
		try {
			connection = jndi.getConnection("jdbc/libraryDB");		
			PreparedStatement pstmt = connection.prepareStatement("delete from users where user_id = ?");
			pstmt.setLong(1, id);
			pstmt.executeUpdate();			
		} catch (Exception e) {
			throw new UserNotDeletedException(id);
		} finally {
			closeConnection(connection);
		}
		
	}

	@Override
	public User getUser(Long id) {
		if (id == null)
			throw new IllegalArgumentException("id can not be null");
		
		Connection connection = null;		
		try {
			connection = jndi.getConnection("jdbc/libraryDB");			
			PreparedStatement pstmt = connection.prepareStatement("select user_id, name, rolle from users where user_id = ?");
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();							
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("user_id"));
				user.setName(rs.getString("name"));
				user.setRolle(rs.getString("rolle"));
				return user;
			} else {
				throw new UserNotFoundException(id);
			}			
		} catch (Exception e) {
			throw new UserNotFoundException(id);
		} finally {	
			closeConnection(connection);
		}
	}

	@Override
	public boolean isSessionOK(HttpServletRequest request) {
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
