package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jndi.JndiFactory;

import model.Cam;
import exception.CamNotDeletedException;
import exception.CamNotSavedException;
import exception.CamNotFoundException;

public class CamDaoImpl implements CamDao {
	
	final JndiFactory jndi = JndiFactory.getInstance();

	@Override
	public void delete(Long id) {
		
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
	public Cam get(Long id) {
		
		if (id == null)
			throw new IllegalArgumentException("id can not be null");
		
		Connection connection = null;		
		try {
			connection = jndi.getConnection("jdbc/libraryDB");			
			PreparedStatement pstmt = connection.prepareStatement("select id, Name, Ort, Url from cameras where id = ?");
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();							
			if (rs.next()) {
				Cam cam = new Cam();
				cam.setId(rs.getLong("id"));
				cam.setUrl(rs.getString("url"));
				cam.setName(rs.getString("name"));
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
	public void save(Cam cam) {
		
		if (cam == null)
			throw new IllegalArgumentException("cam can not be null");
		
		Connection connection = null;		
		try {
			connection = jndi.getConnection("jdbc/libraryDB");			
			if (cam.getId() == null) {
				PreparedStatement pstmt = connection.prepareStatement("insert into cam (id, name, ort, url, rolle) values (?,?,?,?,?)");
				pstmt.setLong(1, cam.getId());
				pstmt.setString(2, cam.getName());
				pstmt.setString(3, cam.getOrt());
				pstmt.setString(4, cam.getUrl());
				pstmt.setString(5, cam.getRolle());
				pstmt.executeUpdate();
			} else {
				PreparedStatement pstmt = connection.prepareStatement("update cam set name = ?, url = ? where id = ?");
				pstmt.setString(1, cam.getName());
				pstmt.setString(2, cam.getUrl());
				pstmt.setLong(3, cam.getId());
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
			
				PreparedStatement pstmt = connection.prepareStatement("select id, name, ort, url from cam");				
				ResultSet rs = pstmt.executeQuery();
								
				while (rs.next()) {
					Cam cam = new Cam();
					cam.setId(rs.getLong("id"));
					cam.setName(rs.getString("Name"));
					cam.setName(rs.getString("Ort"));
					cam.setUrl(rs.getString("Url"));
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
}
